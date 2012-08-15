package org.usc.weibo.service;

import com.xunlei.game.activity.dao.DaoFactory;
import org.usc.weibo.dao.SyncRecordDao;
import org.usc.weibo.vo.SyncRecord;

/**
 *
 * @author ShunLi
 */
public class SyncRecordServiceImpl implements SyncRecordService {
    private static SyncRecordDao dao = DaoFactory.getDao(SyncRecordDao.class);

    @Override
    public void addSyncRecord(SyncRecord relation) {
        dao.addSyncRecord(relation);
    }

    @Override
    public boolean isSynchronized(Long followerId, String weiboId) {
        return dao.isSynchronized(followerId, weiboId);
    }

}
