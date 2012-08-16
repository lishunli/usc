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

import weibo4j.Oauth;
import weibo4j.Users;
import weibo4j.Weibo;
import weibo4j.http.AccessToken;
import weibo4j.model.Status;
import weibo4j.model.User;

import com.xunlei.game.activity.log.LogFactory;
import com.xunlei.game.activity.utils.ServerUtil;
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

	private Application app;
	private Oauth oauth;

	public void auth(HttpServletRequest request, HttpServletResponse response) {
		try {
			synchronized (this) {
				app = appService.randGetOneApp(Provider.SINA);
				oauth = new Oauth();
			}

			if (app == null) {
				log.info("no SINA weibo application, please check");
				return;
			}

			response.sendRedirect(oauth.authorize(app.getOauthConsumerKey(), Constants.CONF.getValue(Constants.SINA_WEIBO_CALL_BACK_REDIRECT_URI_PROP), "code"));

		} catch (Exception e) {
			log.error("auth-error: ", e);
			super.outputRtn(request, response, new JsonRtn<Object>(-1, "网络超时，请稍后重试！").toJsonString());
		}
	}

	public void callBack(HttpServletRequest request, HttpServletResponse response) {
		try {
			String code = request.getParameter("code");

			String appId = app.getAppId();
			String clientId = app.getOauthConsumerKey();
			String clientSecret = app.getOauthConsumerSecret();
			String redirectUri = Constants.CONF.getValue(Constants.SINA_WEIBO_CALL_BACK_REDIRECT_URI_PROP);

			oauth.authorize(clientId, redirectUri, "code");
			AccessToken accessToken = oauth.getAccessTokenByCode(clientId, clientSecret, redirectUri, code);

			System.out.println("Got access token.");
			System.out.println(accessToken);

			String access_token = accessToken.getAccessToken();
			String userId = accessToken.getUid();
			System.out.println("Access token: " + access_token);

			Weibo weibo = new Weibo();
			weibo.setToken(access_token);
			Users um = new Users();
			User user = um.showUserById(userId);

			Follower follower = new Follower();
			follower.setAppId(appId);
			follower.setUserId(userId);
			follower.setUserName(user.getName());
			follower.setToken(access_token);
			follower.setVerifier(code);

			Status lastWeiboContent = user.getStatus();
			if (lastWeiboContent != null) {
				follower.setLastId(lastWeiboContent.getId());
				follower.setLastTimeStamp(lastWeiboContent.getCreatedAt().getTime());
			}

			Follower model = followerService.findByUserIdAndProvider(userId, AppUtil.getProvider(appId));
			if (model != null) {
				model.setAppId(appId);
				model.setToken(follower.getToken());
				model.setVerifier(code);
				model.setLastId(follower.getLastId());
				model.setLastTimeStamp(follower.getLastTimeStamp());
				followerService.updateFollower(model);
			} else {
				followerService.addFollower(follower);
				model = followerService.findByUserIdAndAppId(userId, appId);
			}

			SinaWeiboCache.putWeibo(model.getSeqId(), weibo);

			instance.saveObj(ServerUtil.getRealIp(request) + LEFT_FOLLOWER_NAME, model.getSeqId());
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
