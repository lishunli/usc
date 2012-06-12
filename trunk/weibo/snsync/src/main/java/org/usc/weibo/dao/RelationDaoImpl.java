package org.usc.weibo.dao;

import java.util.ArrayList;
import java.util.List;

import org.usc.weibo.vo.Relation;

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

    @Override
    public void cancelRelation(Long leftFollowerId, Long rightFollowerId) {
        if (leftFollowerId == null && rightFollowerId == null) {
            return;
        }

        StringBuffer sql = new StringBuffer("delete from relation where 1=1 ");

        if (leftFollowerId != null) {
            sql.append(" and leftfollowerid = " + leftFollowerId);
        }
        if (rightFollowerId != null) {
            sql.append(" and rightfollowerid = " + rightFollowerId);
        }
        super.executeSQL(sql.toString());
    }

}
