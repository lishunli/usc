package org.usc.weibo.job;

import java.util.List;

import org.usc.weibo.service.FollowerService;
import org.usc.weibo.service.RelationService;
import org.usc.weibo.service.weibo.WeiboSyncFactory;
import org.usc.weibo.vo.Follower;
import org.usc.weibo.vo.Relation;

import com.xunlei.game.activity.job.AbstractJob;
import com.xunlei.game.activity.service.ServiceFactory;

public class SendWeiboJob extends AbstractJob {
    // private static Logger log = LogFactory.getLogger(Constants.LOG_DIR, Constants.ACT_DIR, "sendWeiboJob");
    private static FollowerService followerService = ServiceFactory.getService(FollowerService.class);
    private static RelationService relationService = ServiceFactory.getService(RelationService.class);

    @Override
    public void run() {
        try {
            System.out.println("SendWeiboJob start...");

            List<Relation> allRelations = relationService.findAll();

            for (Relation realation : allRelations) {
                System.out.println("hanlde " + realation);

                Follower leftFollower = followerService.findById(realation.getLeftFollowerId());
                Follower rightFollower = followerService.findById(realation.getRightFollowerId());

                if (leftFollower == null || rightFollower == null) {
                    System.out.println("no follower" + leftFollower + rightFollower);
                    return;
                }

                WeiboSyncFactory.weiboSync(leftFollower, rightFollower, realation.getIsTwoWay());
            }

            System.out.println("SendWeiboJob end...");
        } catch (Exception e) {
            // log.error(e);
        }
    }

}
