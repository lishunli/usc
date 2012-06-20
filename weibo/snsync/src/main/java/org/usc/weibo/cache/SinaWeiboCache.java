package org.usc.weibo.cache;

import org.usc.weibo.service.FollowerService;
import org.usc.weibo.util.Constants;
import org.usc.weibo.vo.Follower;

import weibo4j.Weibo;

import com.sina.sae.memcached.SaeMemcache;
import com.xunlei.game.activity.service.ServiceFactory;

/**
 *
 * @author Shunli
 */
public class SinaWeiboCache {
    private static FollowerService followerService = ServiceFactory.getService(FollowerService.class);

    // private static ApplicationService applicationService = ServiceFactory.getService(ApplicationService.class);

    public static Weibo getWeibo(Long followerId) {
        return getWeibo(followerId, Boolean.FALSE);
    }

    public static Weibo getWeibo(Long followerId, Boolean createIfNotExist) {
        String key = Constants.WEIBO_CACHE_PREFIX + followerId;

        SaeMemcache mc = new SaeMemcache();
        mc.init();

        Weibo weibo = mc.get(key);

        if (weibo == null && createIfNotExist) {
            Follower follower = followerService.findById(followerId);

            if (follower != null) {
                // Application app = applicationService.findAppById(follower.getAppId());

                // System.setProperty("weibo4j.oauth.consumerKey", app.getOauthConsumerKey());
                // System.setProperty("weibo4j.oauth.consumerSecret", app.getOauthConsumerSecret());

                weibo = new Weibo();
                weibo.setToken(follower.getToken());

                mc.set(key, weibo);
            }
        }

        return weibo;
    }

    public static void putWeibo(Long followerId, Weibo weibo) {
        SaeMemcache mc = new SaeMemcache();
        mc.init();
        mc.set(Constants.WEIBO_CACHE_PREFIX + followerId, weibo);
    }

}
