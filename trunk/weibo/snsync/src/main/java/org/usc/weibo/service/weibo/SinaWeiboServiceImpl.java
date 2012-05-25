package org.usc.weibo.service.weibo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import weibo4j.Paging;
import weibo4j.Status;
import weibo4j.Weibo;

import com.xunlei.game.activity.utils.DateUtil;
import org.usc.weibo.cache.SinaWeiboCache;
import org.usc.weibo.util.Constants;
import org.usc.weibo.util.WeiboUtil;
import org.usc.weibo.vo.Follower;
import org.usc.weibo.vo.Pair;
import org.usc.weibo.vo.SyncRecord;
import org.usc.weibo.vo.WeiboContent;

/**
 *
 * @author Shunli
 */
public class SinaWeiboServiceImpl extends AbstractWeiboService implements WeiboService {
	private static final String SINA_FROM_ID_TO_URL = "http://api.t.sina.com.cn/%s/statuses/%s";
	private static final int SHORT_URL_MAX_LENGTH = 10;

	public SinaWeiboServiceImpl(Follower follower) {
		super(follower);
	}

	@Override
	public Pair<Pair<Long, Long>, List<WeiboContent>> read() throws Exception {
		Long sinaFollowerId = follower.getSeqId();
		Weibo weibo = SinaWeiboCache.getWeibo(sinaFollowerId, true);

		if (weibo == null) {
			log.info("no sina weibo,please check it " + sinaFollowerId);
			throw new Exception("no sina cache");
		}

		Paging pag = new Paging();
		pag.setSinceId(follower.getLastId() != null ? follower.getLastId() : 1L);
		pag.setCount(1000);
		List<Status> statuses = weibo.getUserTimeline(follower.getUserId(), pag);

		Long lastId = follower.getLastId();
		Long lastTimeStamp = follower.getLastTimeStamp();
		List<WeiboContent> weiboContents = null;

		if (statuses != null && !statuses.isEmpty()) {
			weiboContents = new ArrayList<WeiboContent>(statuses.size());

			for (Status status : statuses) {
				if (!syncRecordService.isSynchronized(sinaFollowerId, status.getId())) {
					Status retweetedStatus = status.getRetweeted_status();

					String text = status.getText();
					String pic = status.getOriginal_pic();
					if (retweetedStatus == null) {
						// TODO-Shunli: maybe sometimes can throw exception since different lenght of short url between sina and tx weibo.
						weiboContents.add(new WeiboContent(status.getId(), text, pic, status.getCreatedAt().getTime()));
					} else {
						long retweetedId = retweetedStatus.getId();
						WeiboContent retweetedContent = new WeiboContent(retweetedId, retweetedStatus.getText(), retweetedStatus.getOriginal_pic(), retweetedStatus.getCreatedAt().getTime());

						String from = " //来自微博@" + retweetedStatus.getUser().getName() + " ";
						int maxWidth = Constants.WEIBO_CONTENT_MAX_LENGTH - WeiboUtil.length(from) - SHORT_URL_MAX_LENGTH;

						text = WeiboUtil.abbreviate(text, maxWidth) + from + String.format(SINA_FROM_ID_TO_URL, retweetedStatus.getUser().getId(), retweetedId);

						weiboContents.add(new WeiboContent(status.getId(), text, "", status.getCreatedAt().getTime(), retweetedContent));
					}
				} else {
					log.info("skip weibo " + status);
				}
			}

			// // asc sort weibo content by id.
			// Collections.sort(weiboContents);

			if (weiboContents.size() > 0) {
				// lastId = max = last list
				WeiboContent lastWeiboContent = weiboContents.get(weiboContents.size() - 1);
				lastId = lastWeiboContent.getId();
				lastTimeStamp = lastWeiboContent.getTimeStamp();
			}
		}

		log.info("SinaWeiboServiceImpl.read()" + weiboContents);

		return new Pair<Pair<Long, Long>, List<WeiboContent>>(new Pair<Long, Long>(lastId, lastTimeStamp), weiboContents);
	}
	@Override
	public void write(List<WeiboContent> weiboContents) throws Exception {

		/**
		 * bcoz weibo limit too much, so write to sina weibo handle in later.
		 */
		Long sinaFollowerId = follower.getSeqId();
		Weibo weibo = SinaWeiboCache.getWeibo(sinaFollowerId, true);

		if (weibo == null) {
			log.info("no sina weibo,please check it " + sinaFollowerId);
			throw new Exception("no sina cache");
		}

		if (weiboContents != null) {
			for (WeiboContent weiboContent : weiboContents) {
				Status result = null;

				if (StringUtils.isBlank(weiboContent.getOriginalPic())) {
					result = weibo.updateStatus(weiboContent.getText());
				} else {
					result = weibo.uploadStatus(weiboContent.getText(), weiboContent.getOriginalPic());
				}

				if (result != null) {
					// i want lazy... + Sleep
					syncRecordService.addSyncRecord(new SyncRecord(sinaFollowerId, result.getId(), DateUtil.formatDate(new Date(), Constants.SYNC_DATE_FORMATE)));
					Thread.sleep(5000);
				}

				log.info("SinaWeiboServiceImpl.write()" + weiboContent + "-" + (result != null ? result.getId() : ""));
			}
		}

	}

}
