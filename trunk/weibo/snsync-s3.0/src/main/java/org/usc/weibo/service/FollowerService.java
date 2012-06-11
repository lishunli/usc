package org.usc.weibo.service;

import org.usc.weibo.vo.Follower;
import org.usc.weibo.vo.Provider;

public interface FollowerService {
	void addFollower(Follower follower);
	void updateFollower(Follower follower);
	Follower findById(Long seqId);
	Follower findByUserIdAndAppId(String userId, String appId);
	Follower findByUserIdAndProvider(String userId, Provider provider);

}
