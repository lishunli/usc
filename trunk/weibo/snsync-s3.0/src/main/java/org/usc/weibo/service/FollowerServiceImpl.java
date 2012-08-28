package org.usc.weibo.service;

import java.util.Map;
import java.util.WeakHashMap;

import org.usc.weibo.cache.CacheEntry;
import org.usc.weibo.dao.FollowerDao;
import org.usc.weibo.vo.Follower;
import org.usc.weibo.vo.Provider;

import com.xunlei.game.activity.dao.DaoFactory;

public class FollowerServiceImpl implements FollowerService {
    private static FollowerDao dao = DaoFactory.getDao(FollowerDao.class);
    @SuppressWarnings("unused")
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
        // Follower follower = null;
        // CacheEntry<Follower> cacheEntry = followerCache.get(seqId);
        //
        // if (cacheEntry != null && !cacheEntry.isExpired()) {
        // follower = cacheEntry.getItem();
        // } else { // no cache or cache is invalid
        // follower = dao.findById(seqId);
        // followerCache.put(seqId, new CacheEntry<Follower>(follower));
        // }
        //
        // return follower;

        return dao.findById(seqId);
    }

    @Override
    public Follower findByUserIdAndAppId(String userId, String appId) {
        return dao.findByUserIdAndAppId(userId, appId);
    }

    @Override
    public Follower findByUserIdAndProvider(String userId, Provider provider) {
        return dao.findByUserIdAndProvider(userId, provider);
    }
}
