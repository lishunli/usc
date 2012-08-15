package org.usc.weibo.dao;

import org.usc.weibo.vo.SyncRecord;

/**
 *
 * @author ShunLi
 */
public interface SyncRecordDao {
    void addSyncRecord(SyncRecord relation);
    boolean isSynchronized(Long followerId, String weiboId);
}
