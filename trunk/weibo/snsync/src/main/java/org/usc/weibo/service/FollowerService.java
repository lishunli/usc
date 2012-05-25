package org.usc.weibo.service;

import org.usc.weibo.vo.Follower;

public interface FollowerService {
	void addFollower(Follower follower);

	void updateFollower(Follower follower);

	Follower findById(Long seqId);

	Follower findByUserIdAndAppId(String userId, String appId);

}
