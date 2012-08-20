package org.usc.weibo.cache;

import org.usc.weibo.service.FollowerService;
import org.usc.weibo.util.Constants;
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

	public static Weibo getWeibo(Long followerId) {
		return getWeibo(followerId, Boolean.FALSE);
	}

	public static Weibo getWeibo(Long followerId, Boolean createIfNotExist) {
		String key = Constants.WEIBO_CACHE_PREFIX + followerId;

		// TODO-Shunli: since sina Weibo can't been serializabled, so trun off first in MC.
		Weibo weibo = null;// instance.getObj(key, Weibo.class);

		if (weibo == null && createIfNotExist) {
			Follower follower = followerService.findById(followerId);

			if (follower != null) {
				weibo = new Weibo();
				weibo.setToken(follower.getToken());

				instance.saveObj(key, weibo);
			}
		}

		return weibo;
	}

	public static void putWeibo(Long followerId, Weibo weibo) {
		instance.saveObj(Constants.WEIBO_CACHE_PREFIX + followerId, weibo);
	}

}
