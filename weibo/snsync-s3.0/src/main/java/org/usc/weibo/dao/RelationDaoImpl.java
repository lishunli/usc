package org.usc.weibo.dao;

import java.util.ArrayList;
import java.util.List;

import com.xunlei.game.activity.annotation.DataSourceType;
import com.xunlei.game.activity.dao.BaseDao;
import org.usc.weibo.util.Constants;
import org.usc.weibo.vo.Relation;

@DataSourceType(Constants.JDBC_JNDI_YOUXI_WEIBO)
public class RelationDaoImpl extends BaseDao implements RelationDao {
	@Override
	public void addRelation(Relation relation) {
		super.addObj("relation", relation);
	}

	@Override
	public void updateRelation(Relation relation) {
		super.updateObj("relation", relation);
	}

	@Override
	public List<Relation> findAll() {
		List<Relation> queryListSQL = super.queryListSQL(Relation.class, "select * from relation", null);
		if (queryListSQL == null) {
			queryListSQL = new ArrayList<Relation>();
		}
		return queryListSQL;
	}

	@Override
	public Relation findByTwoWayFollowers(Long leftFollowerId, Long rightFollowerId) {
		return super.querySinglObj(Relation.class, "select * from relation where leftfollowerid = ? and rightfollowerid = ?", new Object[] { leftFollowerId, rightFollowerId });
	}

}
