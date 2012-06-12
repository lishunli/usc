package org.usc.weibo.dao;

import org.usc.weibo.vo.SyncRecord;

/**
 *
 * @author ShunLi
 */
public class SyncRecordDaoImpl extends BaseDao implements SyncRecordDao {

    // @Override
    // public void batchInsert(List<SyncRecord> syncRecords) {
    // }
    @Override
    public void addSyncRecord(SyncRecord relation) {
        super.addObj("syncrecord", relation);
    }

    @Override
    public boolean isSynchronized(Long followerId, Long weiboId) {
        Integer count = super.queryCountSQL("select count(*) from syncrecord where followerid = ? and weiboid =?", new Object[] { followerId, weiboId });
        if (count > 0) {
            return true;
        }
        return false;
    }

}
