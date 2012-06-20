package org.usc.weibo.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.sina.sae.memcached.SaeMemcache;
import com.xunlei.game.activity.utils.ServerUtil;

/**
 * SinaWeiboServlet
 *
 * @author Shunli
 */
public class SinaWeiboServlet extends SnsBaseServlet {
    private static final long serialVersionUID = -2910525161848529312L;

    // protected static Logger log = LogFactory.getLogger(Constants.LOG_DIR, Constants.ACT_DIR, "sinaweibo");

    private Application app;
    private Oauth oauth;

    public void auth(HttpServletRequest request, HttpServletResponse response) throws Exception {
        synchronized (this) {
            app = appService.randGetOneApp(Provider.SINA);

            if (app == null) {
                System.out.println("no SINA weibo application, please check");
                return;
            }

            oauth = new Oauth();
            System.out.println("SinaWeiboServlet app=" + app);
            System.out.println("SinaWeiboServlet oauth=" + oauth);
            String url = oauth.authorize("code", app.getOauthConsumerKey(), Constants.SINA_WEIBO_CALLBACK_URL);

            response.sendRedirect(url);
        }
    }

    public void callBack(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("SinaWeiboServlet app=" + app);
        String verify = request.getParameter("code");
        String appId = app.getAppId();

        AccessToken accessToken = oauth.getAccessTokenByCode(verify, app.getOauthConsumerKey(), app.getOauthConsumerSecret(), Constants.SINA_WEIBO_CALLBACK_URL);
        String access_token = accessToken.getAccessToken();
        String userId = accessToken.getUid();

        Weibo weibo = new Weibo();
        weibo.setToken(access_token);

        Users userApi = new Users();
        User user = userApi.showUserById(userId);

        Follower follower = new Follower();
        follower.setAppId(appId);
        follower.setUserId(userId);
        follower.setUserName(user.getName());
        follower.setToken(access_token);

        Status lastWeiboContent = user.getStatus();
        if (lastWeiboContent != null) {
            follower.setLastId(Long.valueOf(lastWeiboContent.getId()));
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

        String key = ServerUtil.getRealIp(request);// super.getCookie(request, response, Constants.SINA_APP_COOKIE_KEY);
        System.out.println("cookie key = " + key);

        SaeMemcache mc = new SaeMemcache();
        mc.init();
        mc.set(key + LEFT_FOLLOWER_COOKIE_NAME, model.getSeqId(), 5 * 60 * 1000L);

        System.out.println("callBack successly " + appId + " access token, followerId=" + model.getSeqId());

        response.sendRedirect("http://snsync.sinaapp.com/sns?action=sync");
    }
}
