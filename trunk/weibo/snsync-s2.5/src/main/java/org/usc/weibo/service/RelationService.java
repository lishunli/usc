package org.usc.weibo.service;

import java.util.List;

import org.usc.weibo.vo.Relation;

public interface RelationService {
	void addRelation(Relation relation);
	void updateRelation(Relation relation);
	List<Relation> findAll();
	Relation findByTwoWayFollowers(Long leftFollowerId, Long rightFollowerId);
	void cancelRelation(Long leftFollowerId, Long rightFollowerId);
}
