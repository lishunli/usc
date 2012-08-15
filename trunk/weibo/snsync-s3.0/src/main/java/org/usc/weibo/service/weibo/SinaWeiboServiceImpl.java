package org.usc.weibo.service.weibo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.usc.weibo.cache.SinaWeiboCache;
import org.usc.weibo.util.Constants;
import org.usc.weibo.util.WeiboUtil;
import org.usc.weibo.vo.Follower;
import org.usc.weibo.vo.Pair;
import org.usc.weibo.vo.SyncRecord;
import org.usc.weibo.vo.WeiboContent;

import weibo4j.Timeline;
import weibo4j.Weibo;
import weibo4j.model.Paging;
import weibo4j.model.Status;
import weibo4j.model.StatusWapper;

import com.xunlei.game.activity.utils.DateUtil;
import com.xunlei.game.activity.utils.RegUtil;

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
    public Pair<Pair<String, Long>, List<WeiboContent>> read() throws Exception {
        Long sinaFollowerId = follower.getSeqId();
        Weibo weibo = SinaWeiboCache.getWeibo(sinaFollowerId, true);

        if (weibo == null) {
            log.info("no sina weibo,please check it " + sinaFollowerId);
            throw new Exception("no sina cache");
        }

        Paging pag = new Paging();
        pag.setSinceId(StringUtils.isNotEmpty(follower.getLastId()) ? RegUtil.getLong(follower.getLastId()) : 1L);
        pag.setCount(1000);

        Timeline tm = new Timeline();
        StatusWapper statusWapper = tm.getUserTimelineByUid(follower.getUserId(), pag, 0, 0);
        List<Status> statuses = statusWapper.getStatuses();

        String lastId = follower.getLastId();
        Long lastTimeStamp = follower.getLastTimeStamp();
        List<WeiboContent> weiboContents = null;

        if (statuses != null && !statuses.isEmpty()) {
            weiboContents = new ArrayList<WeiboContent>(statuses.size());

            for (Status status : statuses) {
                if (!syncRecordService.isSynchronized(sinaFollowerId, status.getId())) {
                    Status retweetedStatus = status.getRetweetedStatus();

                    String text = status.getText();
                    String pic = status.getOriginalPic();
                    if (retweetedStatus == null) {
                        // TODO-Shunli: maybe sometimes can throw exception since different lenght of short url between sina and tx weibo.
                        weiboContents.add(new WeiboContent(status.getId(), text, pic, status.getCreatedAt().getTime()));
                    } else {
                        String retweetedId = retweetedStatus.getId();
                        String from = " //来自微博@" + retweetedStatus.getUser().getName() + " ";
                        String linkUrl = String.format(SINA_FROM_ID_TO_URL, retweetedStatus.getUser().getId(), retweetedId);
                        int maxWidth = Constants.WEIBO_CONTENT_MAX_LENGTH - WeiboUtil.length(from) - SHORT_URL_MAX_LENGTH;

                        // keep the more real original weibo text.
                        String retweetedText = retweetedStatus.getText();
                        if (WeiboUtil.length(retweetedText) <= maxWidth) {
                            retweetedText = retweetedText + from + linkUrl;
                        } else {
                            text = WeiboUtil.abbreviate(text, maxWidth) + from + linkUrl;
                        }

                        WeiboContent retweetedContent = new WeiboContent(retweetedId, retweetedText, retweetedStatus.getOriginalPic(), retweetedStatus.getCreatedAt().getTime());
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

        return new Pair<Pair<String, Long>, List<WeiboContent>>(new Pair<String, Long>(lastId, lastTimeStamp), weiboContents);
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
                Timeline tm = new Timeline();

                if (StringUtils.isBlank(weiboContent.getOriginalPic())) {
                    result = tm.UpdateStatus(weiboContent.getText());
                } else {
                    result = tm.uploadStatus(weiboContent.getText(), weiboContent.getOriginalPic());
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
