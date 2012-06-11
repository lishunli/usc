package org.usc.weibo.dao;

import java.util.List;

import org.usc.weibo.vo.Relation;

public interface RelationDao {
	void addRelation(Relation relation);
	void updateRelation(Relation relation);
	List<Relation> findAll();
	Relation findByTwoWayFollowers(Long leftFollowerId, Long rightFollowerId);
}
