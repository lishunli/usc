package org.usc.weibo.dao;

import org.usc.weibo.vo.Follower;

public interface FollowerDao {
	void addFollower(Follower follower);
	void updateFollower(Follower follower);
	Follower findById(Long seqId);
	Follower findByUserIdAndAppId(String userId, String appId);
}
