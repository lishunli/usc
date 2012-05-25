package org.usc.weibo.service;

import java.util.List;

import com.xunlei.game.activity.dao.DaoFactory;
import org.usc.weibo.dao.RelationDao;
import org.usc.weibo.vo.Relation;

public class RelationServiceImpl implements RelationService {
	private static RelationDao dao = DaoFactory.getDao(RelationDao.class);

	@Override
	public void addRelation(Relation relation) {
		dao.addRelation(relation);
	}

	@Override
	public void updateRelation(Relation relation) {
		dao.updateRelation(relation);
	}

	@Override
	public List<Relation> findAll() {
		return dao.findAll();
	}
}
