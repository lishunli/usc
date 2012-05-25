package org.usc.weibo.service.weibo;

import com.xunlei.game.activity.service.ServiceFactory;
import org.usc.weibo.service.FollowerService;
import org.usc.weibo.service.SyncRecordService;
import org.usc.weibo.vo.Follower;

/**
 *
 * @author ShunLi
 */
public abstract class AbstractWeiboService {
	protected static FollowerService followerService = ServiceFactory.getService(FollowerService.class);
	protected static SyncRecordService syncRecordService = ServiceFactory.getService(SyncRecordService.class);
	protected Follower follower;

	public AbstractWeiboService(Follower follower) {
		this.follower = follower;
	}

	public void updateLastId(Long finalLastId) {
		if (follower != null && follower.getLastId() != finalLastId) {
			follower.setLastId(finalLastId);
			followerService.updateFollower(follower);
		}
	}

	public void updateLastInfo(Long lastId, Long lastTimeStamp) {
		if (follower != null && (follower.getLastId() != lastId) || follower.getLastTimeStamp() != lastTimeStamp) {
			follower.setLastId(lastId);
			follower.setLastTimeStamp(lastTimeStamp);
			followerService.updateFollower(follower);
		}

	}

}
