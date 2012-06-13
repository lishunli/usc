package org.usc.weibo.web.servlet;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

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
import com.xunlei.game.activity.vo.JsonRtn;

/**
 * TencentWeiboServlet
 *
 * @author Shunli
 */
public class TencentWeiboServlet extends SnsBaseServlet {
	private static final long serialVersionUID = 3469012171633045534L;

	// protected static Logger log = LogFactory.getLogger(Constants.LOG_DIR, Constants.ACT_DIR, "txweibo");

	private OAuth oauth;

	public void auth(HttpServletRequest request, HttpServletResponse response) {
		try {
			Application app = appService.randGetOneApp(Provider.TENCENT);

			if (app == null) {
				// log.info("no SINA weibo application, please check");
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
				// log.info("Get Request Token failed!");
				return;
			} else {
				String oauth_token = oauth.getOauth_token();
				String url = "http://open.t.qq.com/cgi-bin/authorize?oauth_token=" + oauth_token;

				// log.info("auth success and oauth_token=" + oauth_token);
				response.sendRedirect(url);
			}

		} catch (Exception e) {
			// log.error("auth-error: ", e);
			// super.outputRtn(request, response, new JsonRtn<Object>(-1, "网络超时，请稍后重试！").toJsonString());
			// super.outputRtn(request, response, new JsonRtn<Object>(-1, e.toString() + Arrays.toString(e.getStackTrace())).toJsonString());

			ByteArrayOutputStream os = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(os);
			e.printStackTrace(ps);
			String errorMsg = "";
			try {
				errorMsg = os.toString("UTF8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}

			// log.error("auth-error: ", e);
			super.outputRtn(request, response, new JsonRtn<Object>(-1, errorMsg).toJsonString());
			// super.outputRtn(request, response, new JsonRtn<Object>(-1, "网络超时，请稍后重试！").toJsonString());

		}
	}

	public void callBack(HttpServletRequest request, HttpServletResponse response) {
		try {
			String verify = request.getParameter("oauth_verifier");
			String appId = request.getParameter("appId");
			String oauth_token = oauth.getOauth_token();

			// 获取access token
			System.out.println(appId + "'s verify=" + verify);
			oauth.setOauth_verifier(verify);

			OAuthClient auth = new OAuthClient();
			oauth = auth.accessToken(oauth);

			if (oauth.getStatus() == 2) {
				// log.info("Get Access Token failed!");
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
				super.setCookie(request, response, RIGHT_FOLLOWER_COOKIE_NAME, model.getSeqId().toString(), -1);
				// log.info("callBack successly " + appId + " access token, followerId=" + model.getSeqId());

				String path = request.getContextPath();
				String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
				response.sendRedirect(basePath + "sns?action=sync");
			}

		} catch (Exception e) {
			// log.error("callBack-error: ", e);
			// super.outputRtn(request, response, new JsonRtn<Object>(-1, "网络超时，请稍后重试！").toJsonString());
			// super.outputRtn(request, response, new JsonRtn<Object>(-1, e.toString() + Arrays.toString(e.getStackTrace())).toJsonString());

			ByteArrayOutputStream os = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(os);
			e.printStackTrace(ps);
			String errorMsg = "";
			try {
				errorMsg = os.toString("UTF8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}

			// log.error("auth-error: ", e);
			super.outputRtn(request, response, new JsonRtn<Object>(-1, errorMsg).toJsonString());
			// super.outputRtn(request, response, new JsonRtn<Object>(-1, "网络超时，请稍后重试！").toJsonString());

		}
	}
}
