package org.usc.weibo.job;

import java.util.List;

import org.apache.log4j.Logger;
import org.usc.weibo.service.FollowerService;
import org.usc.weibo.service.RelationService;
import org.usc.weibo.service.weibo.WeiboSyncFactory;
import org.usc.weibo.util.Constants;
import org.usc.weibo.vo.Follower;
import org.usc.weibo.vo.Relation;

import com.xunlei.game.activity.job.AbstractJob;
import com.xunlei.game.activity.log.LogFactory;
import com.xunlei.game.activity.service.ServiceFactory;

public class SendWeiboJob extends AbstractJob {
	private static Logger log = LogFactory.getLoggerDaily(Constants.LOG_DIR, Constants.ACT_DIR, "sendWeiboJob");
	private static FollowerService followerService = ServiceFactory.getService(FollowerService.class);
	private static RelationService relationService = ServiceFactory.getService(RelationService.class);

	@Override
	public void run() {
		try {
			log.info("SendWeiboJob start...");

			List<Relation> allRelations = relationService.findAll();

			for (Relation realation : allRelations) {
				log.info("hanlde " + realation);

				Follower leftFollower = followerService.findById(realation.getLeftFollowerId());
				Follower rightFollower = followerService.findById(realation.getRightFollowerId());

				if (leftFollower == null || rightFollower == null) {
					log.info("no follower" + leftFollower + rightFollower);
					return;
				}

				WeiboSyncFactory.weiboSync(leftFollower, rightFollower, realation.getIsTwoWay());
			}

			log.info("SendWeiboJob end...");
		} catch (Exception e) {
			log.error(e);
		}
	}

}
