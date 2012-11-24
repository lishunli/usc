package org.usc.weibo.web.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.usc.weibo.service.weibo.WeiboSyncFactory;
import org.usc.weibo.util.Constants;
import org.usc.weibo.vo.Relation;

import com.xunlei.game.activity.log.LogFactory;
import com.xunlei.game.activity.utils.RegUtil;
import com.xunlei.game.activity.utils.ServerUtil;
import com.xunlei.game.activity.vo.JsonRtn;

/**
 * sync
 *
 * @author Shunli
 */
@WebServlet(urlPatterns = "/sns")
public class SnsServlet extends SnsBaseServlet {
    private static final long serialVersionUID = -1477065409747225124L;
    protected static Logger log = LogFactory.getLogger(Constants.LOG_DIR, Constants.ACT_DIR, "sns");

    public void sync(HttpServletRequest request, HttpServletResponse response) {
        try {
            Long leftFollowerId = RegUtil.getLong(super.getCookie(request, response, LEFT_FOLLOWER_COOKIE_NAME));
            Long rightFollowerId = RegUtil.getLong(super.getCookie(request, response, RIGHT_FOLLOWER_COOKIE_NAME));

            if (leftFollowerId == null || rightFollowerId == null) {
                log.info("sync-no-cookie,please auth both left and right!" + leftFollowerId + "," + rightFollowerId);
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

            log.info("sync success:" + leftFollowerId + "," + rightFollowerId + "," + ServerUtil.getRealIp(request));
            String path = request.getContextPath();
            String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
            response.sendRedirect(basePath);
        } catch (Exception e) {
            log.error("sync-error: ", e);
            super.outputRtn(request, response, new JsonRtn<Object>(-1, "网络超时，请稍后重试！").toJsonString());
        }
    }

    public void cansync(HttpServletRequest request, HttpServletResponse response) {
        try {
            Long leftFollowerId = RegUtil.getLong(super.getCookie(request, response, LEFT_FOLLOWER_COOKIE_NAME));
            Long rightFollowerId = RegUtil.getLong(super.getCookie(request, response, RIGHT_FOLLOWER_COOKIE_NAME));

            if (leftFollowerId == null && rightFollowerId == null) {
                log.info("cansync-no-cookie,please auth both left and right!" + leftFollowerId + rightFollowerId);
            } else {
                relationService.cancelRelation(leftFollowerId, rightFollowerId);
                super.delCookie(response, LEFT_FOLLOWER_COOKIE_NAME);
                super.delCookie(response, RIGHT_FOLLOWER_COOKIE_NAME);

                log.info("cansync success:" + leftFollowerId + "," + rightFollowerId + "," + ServerUtil.getRealIp(request));
            }

            String path = request.getContextPath();
            String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
            response.sendRedirect(basePath);
        } catch (Exception e) {
            log.error("cansync-error: ", e);
            super.outputRtn(request, response, new JsonRtn<Object>(-1, "网络超时，请稍后重试！").toJsonString());
        }
    }

    public void doAction(HttpServletRequest request, HttpServletResponse response) {
        try {
            // WeiboSyncFactory.sync();
            Long leftFollowerId = RegUtil.getLong(super.getCookie(request, response, LEFT_FOLLOWER_COOKIE_NAME));
            Long rightFollowerId = RegUtil.getLong(super.getCookie(request, response, RIGHT_FOLLOWER_COOKIE_NAME));

            if (leftFollowerId == null || rightFollowerId == null) {
                log.info("sync-no-cookie,please auth both left and right!" + leftFollowerId + "," + rightFollowerId);
                super.outputRtn(request, response, "请同时用新浪和腾讯账号登录");
                return;
            }

            WeiboSyncFactory.sync(leftFollowerId, rightFollowerId);
            log.info("doAction-success");
            super.outputRtn(request, response, new JsonRtn<Object>(0, "成功").toJsonString());
        } catch (Exception e) {
            log.error("doAction-error: ", e);
            super.outputRtn(request, response, new JsonRtn<Object>(-1, "网络超时，请稍后重试！").toJsonString());
        }
    }

}
