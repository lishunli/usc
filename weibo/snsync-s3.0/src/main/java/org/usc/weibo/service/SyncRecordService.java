package org.usc.weibo.service;

import org.usc.weibo.vo.SyncRecord;

/**
 *
 * @author ShunLi
 */
public interface SyncRecordService {
    void addSyncRecord(SyncRecord relation);
    boolean isSynchronized(Long followerId, String weiboId);
}
