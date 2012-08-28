package org.usc.weibo.service.weibo;

import java.util.List;

import org.apache.log4j.Logger;
import org.usc.weibo.service.ApplicationService;
import org.usc.weibo.service.FollowerService;
import org.usc.weibo.service.RelationService;
import org.usc.weibo.util.Constants;
import org.usc.weibo.vo.Follower;
import org.usc.weibo.vo.Pair;
import org.usc.weibo.vo.Provider;
import org.usc.weibo.vo.Relation;
import org.usc.weibo.vo.WeiboContent;

import com.xunlei.game.activity.log.LogFactory;
import com.xunlei.game.activity.service.ServiceFactory;

/**
 *
 * @author Shunli
 */
public class WeiboSyncFactory {
    private static Logger log = LogFactory.getLoggerDaily(Constants.LOG_DIR, Constants.ACT_DIR, "sendWeiboJob");

    protected static ApplicationService appService = ServiceFactory.getService(ApplicationService.class);
    protected static FollowerService followerService = ServiceFactory.getService(FollowerService.class);
    protected static RelationService relationService = ServiceFactory.getService(RelationService.class);

    public static void weiboSync(Follower leftFollower, Follower rightFollower, int isTwoWay) throws Exception {
        WeiboService leftWeiboService = buildWeiboService(leftFollower);
        WeiboService rightWeiboService = buildWeiboService(rightFollower);

        if (leftWeiboService == null || rightWeiboService == null) {
            log.info("no weibo service, please check again.");
            return;
        }

        if (isTwoWay == 1) { // 0 one way , 1 two way
            oneWaySync(leftWeiboService, rightWeiboService);
            oneWaySync(rightWeiboService, leftWeiboService);
        } else if (isTwoWay == 0) {
            oneWaySync(leftWeiboService, rightWeiboService);
        } else {
            log.info("please check the relation's two way param.");
        }

    }

    /**
     * common method to sync weibo. job + manual
     *
     *
     * @throws Exception
     */
    public static void sync() throws Exception {
        List<Relation> allRelations = relationService.findAll();

        for (Relation realation : allRelations) {
            log.info("hanlde " + realation);

            Follower leftFollower = followerService.findById(realation.getLeftFollowerId());
            Follower rightFollower = followerService.findById(realation.getRightFollowerId());

            if (leftFollower == null || rightFollower == null) {
                log.info("no follower" + leftFollower + rightFollower);
                return;
            }

            weiboSync(leftFollower, rightFollower, realation.getIsTwoWay());
        }
    }

    /**
     * @param leftWeiboService
     * @param rightWeiboService
     * @throws Exception
     */
    private static void oneWaySync(WeiboService leftWeiboService, WeiboService rightWeiboService) throws Exception {
        // 1st. read
        Pair<Pair<String, Long>, List<WeiboContent>> leftReader = leftWeiboService.read();

        if (leftReader == null) {
            log.info("something error, please check." + leftReader);
            return;
        }

        // 2nd. write weibo.
        rightWeiboService.write(leftReader.getSecond());

        // 3rd. update last id.
        Pair<String, Long> lastInfo = leftReader.getFirst();
        leftWeiboService.updateLastInfo(lastInfo.getFirst(), lastInfo.getSecond());
    }

    private static WeiboService buildWeiboService(Follower follower) {
        WeiboService weiboService = null;
        String provider = appService.findAppById(follower.getAppId()).getProvider();

        if (Provider.SINA.name().equalsIgnoreCase(provider)) {
            weiboService = new SinaWeiboServiceImpl(follower);
        } else if (Provider.TENCENT.name().equalsIgnoreCase(provider)) {
            weiboService = new TencentWeiboServiceImpl(follower);
        }

        return weiboService;
    }

}
