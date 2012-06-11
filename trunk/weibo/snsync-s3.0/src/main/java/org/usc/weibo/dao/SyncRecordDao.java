package org.usc.weibo.dao;

import org.usc.weibo.vo.SyncRecord;

/**
 *
 * @author ShunLi
 */
public interface SyncRecordDao {
	// void batchInsert(List<SyncRecord> syncRecords);
	void addSyncRecord(SyncRecord relation);
	boolean isSynchronized(Long followerId, Long weiboId);
}
