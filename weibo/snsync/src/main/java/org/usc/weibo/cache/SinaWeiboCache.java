package org.usc.weibo.cache;

import org.usc.weibo.service.ApplicationService;
import org.usc.weibo.service.FollowerService;
import org.usc.weibo.util.Constants;
import org.usc.weibo.vo.Application;
import org.usc.weibo.vo.Follower;

import weibo4j.Weibo;

import com.xunlei.game.activity.service.ServiceFactory;

/**
 *
 * @author Shunli
 */
public class SinaWeiboCache {
	private final static CacheService instance = CacheService.instance();
	private static FollowerService followerService = ServiceFactory.getService(FollowerService.class);
	private static ApplicationService applicationService = ServiceFactory.getService(ApplicationService.class);

	public static Weibo getWeibo(Long followerId) {
		return getWeibo(followerId, Boolean.FALSE);
	}

	public static Weibo getWeibo(Long followerId, Boolean createIfNotExist) {
		String key = Constants.WEIBO_CACHE_PREFIX + followerId;

		Weibo weibo = instance.getObj(key, Weibo.class);

		if (weibo == null && createIfNotExist) {
			Follower follower = followerService.findById(followerId);

			if (follower != null) {
				Application app = applicationService.findAppById(follower.getAppId());

				// System.setProperty("weibo4j.oauth.consumerKey", app.getOauthConsumerKey());
				// System.setProperty("weibo4j.oauth.consumerSecret", app.getOauthConsumerSecret());

				weibo = new Weibo();
				weibo.setOAuthConsumer(app.getOauthConsumerKey(), app.getOauthConsumerSecret());
				weibo.setToken(follower.getToken(), follower.getTokenSecret());

				instance.saveObj(key, weibo);
			}
		}

		return weibo;
	}

	public static void putWeibo(Long followerId, Weibo weibo) {
		instance.saveObj(Constants.WEIBO_CACHE_PREFIX + followerId, weibo);
	}

}
