package org.usc.weibo.dao;

import org.usc.weibo.vo.Follower;
import org.usc.weibo.vo.Provider;

public class FollowerDaoImpl extends BaseDao implements FollowerDao {
    @Override
    public void addFollower(Follower follower) {
        super.addObj("follower", follower);
    }

    @Override
    public void updateFollower(Follower follower) {
        super.updateObj("follower", follower);
    }

    @Override
    public Follower findById(Long seqId) {
        return super.findById("follower", Follower.class, seqId);
    }

    @Override
    public Follower findByUserIdAndAppId(String userId, String appId) {
        return super.querySinglObj(Follower.class, "select * from follower where userid = ? and appid = ?", new Object[] { userId, appId });
    }

    @Override
    public Follower findByUserIdAndProvider(String userId, Provider provider) {
        return super.querySinglObj(Follower.class, "select f.* from follower f inner join application a on a.appid = f.appid and a.provider = ? where userid = ?", new Object[] { provider.name(), userId });
    }

}
