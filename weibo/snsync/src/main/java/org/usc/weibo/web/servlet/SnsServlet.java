package org.usc.weibo.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.usc.weibo.util.Constants;
import org.usc.weibo.vo.Relation;

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
		String key = super.getCookie(request, response, "saeut");
		System.out.println("cookie key = " + key);
		Long leftFollowerId = instance.getObj(key + LEFT_FOLLOWER_COOKIE_NAME, Long.class);// RegUtil.getLong(super.getCookie(request, response,
		Long rightFollowerId = instance.getObj(key + RIGHT_FOLLOWER_COOKIE_NAME, Long.class);// RegUtil.getLong(super.getCookie(request, response,
																								// RIGHT_FOLLOWER_COOKIE_NAME));
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
		Long leftFollowerId = instance.getObj(key + LEFT_FOLLOWER_COOKIE_NAME, Long.class);
		Long rightFollowerId = instance.getObj(key + RIGHT_FOLLOWER_COOKIE_NAME, Long.class);

		if (leftFollowerId == null && rightFollowerId == null) {
			System.out.println("cansync-no-cookie,please auth both left and right!" + leftFollowerId + rightFollowerId);
		} else {
			relationService.cancelRelation(leftFollowerId, rightFollowerId);
			instance.deleteObj(key + LEFT_FOLLOWER_COOKIE_NAME);
			instance.deleteObj(key + RIGHT_FOLLOWER_COOKIE_NAME);
			System.out.println("cansync success:" + leftFollowerId + "," + rightFollowerId + "," + ServerUtil.getRealIp(request));
		}

		response.sendRedirect(Constants.REDIRECT_URL);
	}
}
