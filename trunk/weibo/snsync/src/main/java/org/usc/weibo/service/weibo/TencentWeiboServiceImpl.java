package org.usc.weibo.service.weibo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.tencent.weibo.api.Statuses_API;
import com.tencent.weibo.api.T_API;
import com.tencent.weibo.beans.OAuth;
import com.tencent.weibo.utils.WeiBoConst;
import com.xunlei.game.activity.utils.DateUtil;
import org.usc.weibo.cache.TencentOAuthCache;
import org.usc.weibo.util.Constants;
import org.usc.weibo.vo.Follower;
import org.usc.weibo.vo.Pair;
import org.usc.weibo.vo.SyncRecord;
import org.usc.weibo.vo.WeiboContent;

/**
 *
 * @author Shunli
 */
public class TencentWeiboServiceImpl extends AbstractWeiboService implements WeiboService {
	protected static final String defaultIp = "192.168.100.145";
	protected static final T_API sendApi = new T_API();
	protected static final Statuses_API statusesApi = new Statuses_API();

	public TencentWeiboServiceImpl(Follower follower) {
		super(follower);
	}

	@Override
	public Pair<Pair<Long, Long>, List<WeiboContent>> read() throws Exception {
		Long txFollowerId = follower.getSeqId();
		OAuth oauth = TencentOAuthCache.getOAuth(txFollowerId, true);

		if (oauth == null) {
			// log.info("no tx oauth,please check it " + txFollowerId);
			throw new Exception("no tencent cache");
		}

		Long lastId = follower.getLastId();
		Long lastTimeStamp = follower.getLastTimeStamp();

		String response = statusesApi.broadcast_timeline(
				oauth, WeiBoConst.ResultType.ResultType_Json,
				"2", lastTimeStamp != null ? lastTimeStamp.toString() : "0",
				"100", lastId != null ? lastId.toString() : "0",
				"0", "0", "1");

		// log.info("TencentWeiboServiceImpl.read() " + response);

		Object jsonObject = new JSONObject(response).getString("data");

		List<WeiboContent> weiboContents = null;

		if (jsonObject != null && !"null".equals(jsonObject)) {
			JSONArray txWeiboArray = new JSONObject(response).getJSONObject("data").getJSONArray("info");

			int size = txWeiboArray.length();

			if (size > 0) {
				weiboContents = new ArrayList<WeiboContent>(size);

				for (int i = 0; i < size; i++) {
					JSONObject json = (JSONObject) txWeiboArray.get(i);
					Long weiboId = Long.valueOf(json.getString("id"));
					String image = json.getString("image");
					if (!StringUtils.isBlank(image)) {
						if ("null".equalsIgnoreCase(image)) {
							image = null;
						} else {
							image = StringUtils.removeEnd(StringUtils.removeStart(image, "[\""), "\"]") + "/2000";// big image.
						}
					}

					if (!syncRecordService.isSynchronized(txFollowerId, weiboId)) {
						weiboContents.add(new WeiboContent(weiboId, json.getString("origtext"), image, json.getLong("timestamp")));
					} else {
						// log.info("skip weibo " + json);
					}
				}

				// // asc sort weibo content by id.
				// Collections.sort(weiboContents);
				// lastId = max = last list

				if (weiboContents.size() > 0) {
					// lastId = last list
					WeiboContent lastWeiboContent = weiboContents.get(weiboContents.size() - 1);
					lastId = lastWeiboContent.getId();
					lastTimeStamp = lastWeiboContent.getTimeStamp();
				}
			}

			// log.info("TencentWeiboServiceImpl.read()" + weiboContents);
		}

		return new Pair<Pair<Long, Long>, List<WeiboContent>>(new Pair<Long, Long>(lastId, lastTimeStamp), weiboContents);
	}

	@Override
	public void write(List<WeiboContent> weiboContents) throws Exception {
		Long txFollowerId = follower.getSeqId();
		OAuth oauth = TencentOAuthCache.getOAuth(txFollowerId, true);

		if (oauth == null) {
			// log.info("no tx oauth,please check it " + txFollowerId);
			throw new Exception("no tencent cache");
		}

		if (weiboContents != null && !weiboContents.isEmpty()) {
			for (WeiboContent weiboContent : weiboContents) {
				WeiboContent retweetedContent = weiboContent.getRetweetedContent();
				if (retweetedContent == null) {
					addWeibo(oauth, weiboContent, txFollowerId);
				} else {
					// first far a weibo for origion weibo.
					Long result = addWeibo(oauth, retweetedContent, txFollowerId);

					// second talk about.
					String response = sendApi.comment(oauth, WeiBoConst.ResultType.ResultType_Json, weiboContent.getText(), defaultIp, result.toString());
					int errorCode = analyzeErrorCode(response);

					if (errorCode == 0) {
						// success
						Long weiboId = analyzeWeiboId(response);
						syncRecordService.addSyncRecord(new SyncRecord(txFollowerId, weiboId, DateUtil.formatDate(new Date(), Constants.SYNC_DATE_FORMATE)));
						Thread.sleep(1000);
					}
				}
			}
		}
	}

	private Long addWeibo(OAuth oauth, WeiboContent weiboContent, Long txFollowerId) throws Exception {
		String result;
		String text = weiboContent.getText();

		if (StringUtils.isEmpty(weiboContent.getOriginalPic())) {
			result = sendApi.add(oauth, WeiBoConst.ResultType.ResultType_Json, text, defaultIp);
		} else {
			result = sendApi.add_pic(oauth, WeiBoConst.ResultType.ResultType_Json, text, defaultIp, weiboContent.getOriginalPic());
		}

		// log.info("TencentWeiboServiceImpl.addWeibo()" + weiboContent + "-" + result);

		int errorCode = analyzeErrorCode(result);
		if (errorCode == 2) {
			// error content len error, resent.
			if (text.contains("，")) {
				weiboContent.setText(text.replaceFirst("，", ","));
			} else if (text.contains("。")) {
				weiboContent.setText(text.replaceFirst("。", "."));
			} else {
				String errorMsg = "send tx weibo failed since error content len error, please check the text!" + weiboContent + "-" + result;
				// log.info(errorMsg);
				throw new Exception(errorMsg);
			}

			return addWeibo(oauth, weiboContent, txFollowerId);
		} else if (errorCode == 0) {
			// success
			Long weiboId = analyzeWeiboId(result);

			syncRecordService.addSyncRecord(new SyncRecord(txFollowerId, weiboId, DateUtil.formatDate(new Date(), Constants.SYNC_DATE_FORMATE)));
			Thread.sleep(1000);

			return weiboId;
		}

		throw new Exception("send tx weibo failed!");
	}

	private Long analyzeWeiboId(String result) throws JSONException {
		return new JSONObject(result).getJSONObject("data").getLong("id");
	}

	private int analyzeErrorCode(String result) throws JSONException {
		return new JSONObject(result).getInt("errcode");
	}

}
