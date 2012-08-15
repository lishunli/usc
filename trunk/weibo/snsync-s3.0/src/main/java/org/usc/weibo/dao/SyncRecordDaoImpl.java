package org.usc.weibo.dao;

import com.xunlei.game.activity.annotation.DataSourceType;
import com.xunlei.game.activity.dao.BaseDao;
import org.usc.weibo.util.Constants;
import org.usc.weibo.vo.SyncRecord;

/**
 *
 * @author ShunLi
 */
@DataSourceType(Constants.JDBC_JNDI_YOUXI_WEIBO)
public class SyncRecordDaoImpl extends BaseDao implements SyncRecordDao {
    @Override
    public void addSyncRecord(SyncRecord relation) {
        super.addObj("syncrecord", relation);
    }

    @Override
    public boolean isSynchronized(Long followerId, String weiboId) {
        Integer count = super.queryCountSQL("select count(*) from syncrecord where followerid = ? and weiboid =?", new Object[] { followerId, weiboId });
        if (count > 0) {
            return true;
        }
        return false;
    }

}
