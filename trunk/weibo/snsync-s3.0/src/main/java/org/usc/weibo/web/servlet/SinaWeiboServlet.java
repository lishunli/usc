package org.usc.weibo.web.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.usc.weibo.cache.SinaWeiboCache;
import org.usc.weibo.util.AppUtil;
import org.usc.weibo.util.Constants;
import org.usc.weibo.vo.Application;
import org.usc.weibo.vo.Follower;
import org.usc.weibo.vo.Provider;

import weibo4j.Status;
import weibo4j.User;
import weibo4j.Weibo;
import weibo4j.WeiboException;
import weibo4j.http.AccessToken;
import weibo4j.http.RequestToken;

import com.xunlei.game.activity.log.LogFactory;
import com.xunlei.game.activity.vo.JsonRtn;

/**
 * 提供统一的接口
 *
 * @author Shunli
 */
@WebServlet(urlPatterns = "/sinaweibo")
public class SinaWeiboServlet extends SnsBaseServlet {
	private static final long serialVersionUID = -2910525161848529312L;

	protected static Logger log = LogFactory.getLogger(Constants.LOG_DIR, Constants.ACT_DIR, "sinaweibo");

	private String appId;
	private Weibo weibo;
	private RequestToken requestToken;

	public void auth(HttpServletRequest request, HttpServletResponse response) {
		try {
			Application app = appService.randGetOneApp(Provider.SINA);

			if (app == null) {
				log.info("no SINA weibo application, please check");
				return;
			}

			synchronized (this) {
				appId = app.getAppId();
			}

			System.setProperty("weibo4j.oauth.consumerKey", app.getOauthConsumerKey());
			System.setProperty("weibo4j.oauth.consumerSecret", app.getOauthConsumerSecret());

			synchronized (this) {
				weibo = new Weibo();
				requestToken = weibo.getOAuthRequestToken();
			}

			System.out.println("Got request token.");

			System.out.println("Request token: " + requestToken.getToken());
			System.out.println("Request token secret: " + requestToken.getTokenSecret());
			System.out.println("Open the following URL and grant access to your account:");

			response.sendRedirect(requestToken.getAuthorizationURL(request.getRequestURL() + "?action=callBack"));

		} catch (Exception e) {
			log.error("auth-error: ", e);
			super.outputRtn(request, response, new JsonRtn<Object>(-1, "网络超时，请稍后重试！").toJsonString());
		}
	}

	public void callBack(HttpServletRequest request, HttpServletResponse response) {
		try {
			String verify = request.getParameter("oauth_verifier");
			AccessToken accessToken = null;

			try {
				accessToken = requestToken.getAccessToken(verify);
			} catch (WeiboException te) {
				if (401 == te.getStatusCode()) {
					System.out.println("Unable to get the access token.");
				} else {
					te.printStackTrace();
				}
			}

			System.out.println("Got access token.");
			System.out.println(accessToken);

			String token = accessToken.getToken();
			String tokenSecret = accessToken.getTokenSecret();
			String userId = String.valueOf(accessToken.getUserId());
			System.out.println("Access token: " + token);
			System.out.println("Access token secret: " + tokenSecret);

			weibo.setToken(token, tokenSecret);
			User user = weibo.showUser(userId);

			Follower follower = new Follower();
			follower.setAppId(appId);
			follower.setUserId(userId);
			follower.setUserName(user.getName());
			follower.setToken(token);
			follower.setTokenSecret(tokenSecret);

			Status lastWeiboContent = user.getStatus();
			if (lastWeiboContent != null) {
				follower.setLastId(lastWeiboContent.getId());
				follower.setLastTimeStamp(lastWeiboContent.getCreatedAt().getTime());
			}

			Follower model = followerService.findByUserIdAndProvider(userId, AppUtil.getProvider(appId));
			if (model != null) {
				model.setAppId(appId);
				model.setToken(follower.getToken());
				model.setTokenSecret(follower.getTokenSecret());
				model.setLastId(follower.getLastId());
				model.setLastTimeStamp(follower.getLastTimeStamp());
				followerService.updateFollower(model);
			} else {
				followerService.addFollower(follower);
				model = followerService.findByUserIdAndAppId(userId, appId);
			}

			SinaWeiboCache.putWeibo(model.getSeqId(), weibo);
			super.setCookie(request, response, LEFT_FOLLOWER_COOKIE_NAME, model.getSeqId().toString(), -1);
			log.info("callBack successly " + appId + " access token, followerId=" + model.getSeqId());

			String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
			response.sendRedirect(basePath + "sns?action=sync");

		} catch (Exception e) {
			log.error("callBack-error: ", e);
			super.outputRtn(request, response, new JsonRtn<Object>(-1, "网络超时，请稍后重试！").toJsonString());
		}
	}
}
