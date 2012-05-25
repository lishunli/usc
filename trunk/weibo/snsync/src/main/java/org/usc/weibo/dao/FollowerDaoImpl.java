package org.usc.weibo.dao;

import java.util.List;

import com.xunlei.game.activity.annotation.DataSourceType;
import com.xunlei.game.activity.dao.BaseDao;
import org.usc.weibo.util.Constants;
import org.usc.weibo.vo.Follower;

@DataSourceType(Constants.JDBC_JNDI_YOUXI_WEIBO)
public class FollowerDaoImpl extends BaseDao implements FollowerDao {
	@Override
	public void addFollower(Follower follower) {
		super.addObj("follower", follower);
	}

	@Override
	public void updateFollower(Follower follower) {
		super.updateObj("follower", follower);
	}

	@Override
	public Follower findById(Long seqId) {
		return super.findById("follower", Follower.class, seqId);
	}

	@Override
	public Follower findByUserIdAndAppId(String userId, String appId) {
		List<Follower> followers = super.queryListSQL(Follower.class, "select * from follower where userid = ? and appid = ?", new Object[] { userId, appId });

		if (followers != null) {
			return followers.get(0);
		}

		return null;
	}

}
