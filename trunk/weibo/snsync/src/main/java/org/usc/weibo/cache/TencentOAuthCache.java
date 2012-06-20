package org.usc.weibo.cache;

import org.usc.weibo.service.ApplicationService;
import org.usc.weibo.service.FollowerService;
import org.usc.weibo.util.Constants;
import org.usc.weibo.vo.Application;
import org.usc.weibo.vo.Follower;

import com.sina.sae.memcached.SaeMemcache;
import com.tencent.weibo.beans.OAuth;
import com.tencent.weibo.utils.OAuthClient;
import com.xunlei.game.activity.service.ServiceFactory;

/**
 *
 * @author Shunli
 */
public class TencentOAuthCache {
    private static FollowerService followerService = ServiceFactory.getService(FollowerService.class);
    private static ApplicationService applicationService = ServiceFactory.getService(ApplicationService.class);

    public static OAuth getOAuth(Long followerId) {
        return getOAuth(followerId, Boolean.FALSE);
    }

    public static OAuth getOAuth(Long followerId, Boolean createIfNotExist) {
        String key = Constants.WEIBO_CACHE_PREFIX + followerId;

        SaeMemcache mc = new SaeMemcache();
        mc.init();

        OAuth oAuth = mc.get(key);

        if (oAuth == null && createIfNotExist) {
            Follower follower = followerService.findById(followerId);

            if (follower != null) {
                Application app = applicationService.findAppById(follower.getAppId());

                oAuth = new OAuth(app.getOauthConsumerKey(), app.getOauthConsumerSecret(), "null");
                oAuth.setOauth_token(follower.getToken());
                oAuth.setOauth_verifier(follower.getVerifier());

                OAuthClient auth = new OAuthClient();

                try {
                    oAuth = auth.accessToken(oAuth);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (oAuth.getStatus() == 2) {
                    // Get Access Token failed!
                    oAuth = null;
                }

                mc.set(key, oAuth);
            }
        }

        return oAuth;
    }

    public static void putOAuth(Long followerId, OAuth oAuth) {
        SaeMemcache mc = new SaeMemcache();
        mc.init();
        mc.set(Constants.WEIBO_CACHE_PREFIX + followerId, oAuth);
    }

}
