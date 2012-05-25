package org.usc.weibo.service;

import java.util.Map;
import java.util.WeakHashMap;

import com.xunlei.game.activity.dao.DaoFactory;
import org.usc.weibo.cache.CacheEntry;
import org.usc.weibo.dao.FollowerDao;
import org.usc.weibo.vo.Follower;

public class FollowerServiceImpl implements FollowerService {
	private static FollowerDao dao = DaoFactory.getDao(FollowerDao.class);
	private Map<Long, CacheEntry<Follower>> followerCache = new WeakHashMap<Long, CacheEntry<Follower>>(); // followerId==seqId

	@Override
	public void addFollower(Follower follower) {
		dao.addFollower(follower);
	}

	@Override
	public void updateFollower(Follower follower) {
		dao.updateFollower(follower);
	}

	@Override
	public Follower findById(Long seqId) {
		Follower follower = null;
		CacheEntry<Follower> cacheEntry = followerCache.get(seqId);

		if (cacheEntry != null && !cacheEntry.isExpired()) {
			follower = cacheEntry.getItem();
		} else { // no cache or cache is invalid
			follower = dao.findById(seqId);
			followerCache.put(seqId, new CacheEntry<Follower>(follower));
		}

		return follower;
	}

	@Override
	public Follower findByUserIdAndAppId(String userId, String appId) {
		return dao.findByUserIdAndAppId(userId, appId);
	}
}
