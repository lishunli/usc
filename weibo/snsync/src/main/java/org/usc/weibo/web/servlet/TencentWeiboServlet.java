package org.usc.weibo.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.usc.weibo.cache.TencentOAuthCache;
import org.usc.weibo.util.AppUtil;
import org.usc.weibo.vo.Application;
import org.usc.weibo.vo.Follower;
import org.usc.weibo.vo.Provider;

import com.tencent.weibo.api.User_API;
import com.tencent.weibo.beans.OAuth;
import com.tencent.weibo.utils.OAuthClient;
import com.tencent.weibo.utils.WeiBoConst.ResultType;

/**
 * TencentWeiboServlet
 *
 * @author Shunli
 */
public class TencentWeiboServlet extends SnsBaseServlet {
	private static final long serialVersionUID = 3469012171633045534L;

	// protected static Logger log = LogFactory.getLogger(Constants.LOG_DIR, Constants.ACT_DIR, "txweibo");

	private OAuth oauth;

	public void auth(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Application app = appService.randGetOneApp(Provider.TENCENT);

		if (app == null) {
			System.out.println("no SINA weibo application, please check");
			return;
		}

		String appId = app.getAppId();

		synchronized (this) {
			oauth = new OAuth(app.getOauthConsumerKey(), app.getOauthConsumerSecret(), request.getRequestURL() + "?action=callBack&appId=" + appId);
		}

		OAuthClient auth = new OAuthClient();

		// 获取request token
		oauth = auth.requestToken(oauth);

		if (oauth.getStatus() == 1) {
			System.out.println("Get Request Token failed!");
			return;
		} else {
			String oauth_token = oauth.getOauth_token();
			String url = "http://open.t.qq.com/cgi-bin/authorize?oauth_token=" + oauth_token;

			System.out.println("auth success and oauth_token=" + oauth_token);
			response.sendRedirect(url);
		}
	}

	public void callBack(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String verify = request.getParameter("oauth_verifier");
		String appId = request.getParameter("appId");
		String oauth_token = oauth.getOauth_token();

		// 获取access token
		System.out.println(appId + "'s verify=" + verify);
		oauth.setOauth_verifier(verify);

		OAuthClient auth = new OAuthClient();
		oauth = auth.accessToken(oauth);

		if (oauth.getStatus() == 2) {
			System.out.println("Get Access Token failed!");
			return;
		} else {
			User_API uApi = new User_API();
			String userInfo = uApi.info(oauth, ResultType.ResultType_Json);

			JSONObject user = (JSONObject) new JSONObject(userInfo).get("data");
			JSONArray lastWeiboContents = user.getJSONArray("tweetinfo");

			Follower follower = new Follower();
			follower.setAppId(appId);
			String userId = user.getString("name");
			follower.setUserId(userId);
			follower.setUserName(user.getString("nick"));
			follower.setToken(oauth_token);
			follower.setVerifier(oauth.getOauth_verifier());

			if (lastWeiboContents.length() > 0) {
				JSONObject lastWeiboContent = (JSONObject) lastWeiboContents.get(0);
				follower.setLastId(Long.valueOf(lastWeiboContent.getString("id")));
				follower.setLastTimeStamp(lastWeiboContent.getLong("timestamp"));
			}

			Follower model = followerService.findByUserIdAndProvider(userId, AppUtil.getProvider(appId));

			if (model != null) {
				model.setAppId(appId);
				model.setToken(follower.getToken());
				model.setVerifier(follower.getVerifier());
				model.setLastId(follower.getLastId());
				model.setLastTimeStamp(follower.getLastTimeStamp());
				followerService.updateFollower(model);
			} else {
				followerService.addFollower(follower);
				model = followerService.findByUserIdAndAppId(userId, appId);
			}

			TencentOAuthCache.putOAuth(model.getSeqId(), oauth);

			String key = super.getCookie(request, response, "saeut");
			System.out.println("cookie key = " + key);
			instance.saveObj(key + RIGHT_FOLLOWER_COOKIE_NAME, model.getSeqId(), 5 * 60 * 1000L);// 5min

			System.out.println("callBack successly " + appId + " access token, followerId=" + model.getSeqId());

			response.sendRedirect("http://snsync.sinaapp.com/sns?action=sync");
		}
	}
}
