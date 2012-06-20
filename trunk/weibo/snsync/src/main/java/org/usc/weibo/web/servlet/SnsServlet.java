package org.usc.weibo.web.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.usc.weibo.service.weibo.WeiboSyncFactory;
import org.usc.weibo.util.Constants;
import org.usc.weibo.vo.Follower;
import org.usc.weibo.vo.Relation;

import com.sina.sae.memcached.SaeMemcache;
import com.xunlei.game.activity.utils.ServerUtil;

/**
 * SnsServlet
 *
 * @author Shunli
 */
public class SnsServlet extends SnsBaseServlet {
    private static final long serialVersionUID = -1477065409747225124L;

    // protected static Logger log = LogFactory.getLogger(Constants.LOG_DIR, Constants.ACT_DIR, "sns");

    public void sync(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String key = ServerUtil.getRealIp(request);// super.getCookie(request, response, Constants.SINA_APP_COOKIE_KEY);
        System.out.println("cookie key = " + key);

        SaeMemcache mc = new SaeMemcache();
        mc.init();

        Long leftFollowerId = mc.get(key + LEFT_FOLLOWER_COOKIE_NAME);
        Long rightFollowerId = mc.get(key + RIGHT_FOLLOWER_COOKIE_NAME);

        if (leftFollowerId == null || rightFollowerId == null) {
            System.out.println("sync-no-cookie,please auth both left and right!" + leftFollowerId + "," + rightFollowerId);
        } else {
            Relation originRelation = relationService.findByTwoWayFollowers(leftFollowerId, rightFollowerId);

            if (originRelation == null) {
                Relation relation = new Relation(leftFollowerId, rightFollowerId); // default is two-way
                relationService.addRelation(relation);
            } else {
                // update , now is no-op, maybe will change th two way property.
                // originRelation.setIsTwoWay(0);
                // relationService.updateRelation(originRelation);
            }
        }

        System.out.println("sync success:" + leftFollowerId + "," + rightFollowerId + "," + ServerUtil.getRealIp(request));
        response.sendRedirect(Constants.REDIRECT_URL);
    }

    public void cansync(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String key = super.getCookie(request, response, "saeut");
        System.out.println("cookie key = " + key);

        SaeMemcache mc = new SaeMemcache();
        mc.init();

        Long leftFollowerId = mc.get(key + LEFT_FOLLOWER_COOKIE_NAME);
        Long rightFollowerId = mc.get(key + RIGHT_FOLLOWER_COOKIE_NAME);

        if (leftFollowerId == null && rightFollowerId == null) {
            System.out.println("cansync-no-cookie,please auth both left and right!" + leftFollowerId + rightFollowerId);
        } else {
            relationService.cancelRelation(leftFollowerId, rightFollowerId);
            mc.delete(key + LEFT_FOLLOWER_COOKIE_NAME);
            mc.delete(key + RIGHT_FOLLOWER_COOKIE_NAME);
            System.out.println("cansync success:" + leftFollowerId + "," + rightFollowerId + "," + ServerUtil.getRealIp(request));
        }

        response.sendRedirect(Constants.REDIRECT_URL);
    }

    public void syncJob(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("syncJob start...");

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

        System.out.println("syncJob end...");
    }

}
