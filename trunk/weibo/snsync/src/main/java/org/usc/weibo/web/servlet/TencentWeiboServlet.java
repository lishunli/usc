package org.usc.weibo.web.servlet;

import java.net.URLEncoder;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.usc.weibo.cache.TencentOAuthCache;
import org.usc.weibo.service.ApplicationService;
import org.usc.weibo.service.FollowerService;
import org.usc.weibo.util.AppUtil;
import org.usc.weibo.util.Constants;
import org.usc.weibo.vo.Application;
import org.usc.weibo.vo.Follower;
import org.usc.weibo.vo.Provider;

import com.tencent.weibo.api.User_API;
import com.tencent.weibo.beans.OAuth;
import com.tencent.weibo.utils.OAuthClient;
import com.tencent.weibo.utils.WeiBoConst.ResultType;
import com.xunlei.game.activity.log.LogFactory;
import com.xunlei.game.activity.service.ServiceFactory;
import com.xunlei.game.activity.vo.JsonRtn;
import com.xunlei.game.activity.web.servlet.BaseServlet;

/**
 * 提供统一的接口
 *
 * @author Shunli
 */
@SuppressWarnings({ "rawtypes", "serial" })
@WebServlet(urlPatterns = "/txweibo")
public class TencentWeiboServlet extends BaseServlet {

	protected static Logger log = LogFactory.getLogger(Constants.LOG_DIR, Constants.ACT_DIR, "txweibo");
	protected static FollowerService followerService = ServiceFactory.getService(FollowerService.class);
	protected static ApplicationService appService = ServiceFactory.getService(ApplicationService.class);

	private OAuth oauth;

	public void auth(HttpServletRequest request, HttpServletResponse response) {
		try {
			Application app = appService.randGetOneApp(Provider.TENCENT);

			if (app == null) {
				log.info("no SINA weibo application, please check");
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
				log.info("Get Request Token failed!");
				return;
			} else {
				String oauth_token = oauth.getOauth_token();
				String url = "http://open.t.qq.com/cgi-bin/authorize?oauth_token=" + oauth_token;

				log.info("auth success and oauth_token=" + oauth_token);
				response.sendRedirect(url);
			}

		} catch (Exception e) {
			log.error("auth-error: ", e);
			super.outputRtn(request, response, new JsonRtn(-1, "网络超时，请稍后重试！").toJsonString());
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
				log.info("Get Access Token failed!");
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
					followerService.updateFollower(model);
				} else {
					followerService.addFollower(follower);
					model = followerService.findByUserIdAndAppId(userId, appId);
				}

				TencentOAuthCache.putOAuth(model.getSeqId(), oauth);

				log.info("callBack successly " + appId + " access token, followerId=" + model.getSeqId());

				Follower rightFollower = followerService.findByUserIdAndAppId(userId, appId);
				Cookie cookie = new Cookie("rightFollowerId", URLEncoder.encode(rightFollower.getSeqId().toString(), "UTF-8"));
				cookie.setDomain("127.0.0.1");
				cookie.setMaxAge(-1);
				cookie.setPath("/");
				response.addCookie(cookie);

				String path = request.getContextPath();
				String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
				response.sendRedirect(basePath);
			}

		} catch (Exception e) {
			log.error("callBack-error: ", e);
			super.outputRtn(request, response, new JsonRtn(-1, "网络超时，请稍后重试！").toJsonString());
		}
	}
}
