package org.usc.weibo.web.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.usc.weibo.util.Constants;
import org.usc.weibo.vo.Relation;

import com.xunlei.game.activity.log.LogFactory;
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
			String realIp = ServerUtil.getRealIp(request);
			Long leftFollowerId = instance.getObj(realIp + LEFT_FOLLOWER_NAME, Long.class);
			Long rightFollowerId = instance.getObj(realIp + RIGHT_FOLLOWER_NAME, Long.class);

			if (leftFollowerId == null || rightFollowerId == null) {
				log.info("sync-no-mc-object,please auth both left and right!" + leftFollowerId + "," + rightFollowerId);
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
			String realIp = ServerUtil.getRealIp(request);
			Long leftFollowerId = instance.getObj(realIp + LEFT_FOLLOWER_NAME, Long.class);
			Long rightFollowerId = instance.getObj(realIp + RIGHT_FOLLOWER_NAME, Long.class);

			if (leftFollowerId == null && rightFollowerId == null) {
				log.info("cansync-no-mc-object,please auth both left and right!" + leftFollowerId + rightFollowerId);
			} else {
				relationService.cancelRelation(leftFollowerId, rightFollowerId);
				instance.delete(realIp + LEFT_FOLLOWER_NAME);
				instance.delete(realIp + RIGHT_FOLLOWER_NAME);
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
}
