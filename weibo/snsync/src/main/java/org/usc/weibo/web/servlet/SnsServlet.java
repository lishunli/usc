package org.usc.weibo.web.servlet;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.usc.weibo.vo.Relation;

import com.xunlei.game.activity.utils.RegUtil;
import com.xunlei.game.activity.vo.JsonRtn;

/**
 * SnsServlet
 *
 * @author Shunli
 */
public class SnsServlet extends SnsBaseServlet {
	private static final long serialVersionUID = -1477065409747225124L;

	// protected static Logger log = LogFactory.getLogger(Constants.LOG_DIR, Constants.ACT_DIR, "sns");

	public void sync(HttpServletRequest request, HttpServletResponse response) {
		try {
			Long leftFollowerId = RegUtil.getLong(super.getCookie(request, response, LEFT_FOLLOWER_COOKIE_NAME));
			Long rightFollowerId = RegUtil.getLong(super.getCookie(request, response, RIGHT_FOLLOWER_COOKIE_NAME));

			if (leftFollowerId == null || rightFollowerId == null) {
				// log.info("sync-no-cookie,please auth both left and right!" + leftFollowerId + "," + rightFollowerId);
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

			// log.info("sync success:" + leftFollowerId + "," + rightFollowerId + "," + ServerUtil.getRealIp(request));
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
			response.sendRedirect(basePath);
		} catch (Exception e) {
			// log.error("sync-error: ", e);
			// super.outputRtn(request, response, new JsonRtn<Object>(-1, "网络超时，请稍后重试！").toJsonString());
			// super.outputRtn(request, response, new JsonRtn<Object>(-1, e.toString() + Arrays.toString(e.getStackTrace())).toJsonString());

			ByteArrayOutputStream os = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(os);
			e.printStackTrace(ps);
			String errorMsg = "";
			try {
				errorMsg = os.toString("UTF8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}

			// log.error("auth-error: ", e);
			super.outputRtn(request, response, new JsonRtn<Object>(-1, errorMsg).toJsonString());
			// super.outputRtn(request, response, new JsonRtn<Object>(-1, "网络超时，请稍后重试！").toJsonString());

		}
	}
	public void cansync(HttpServletRequest request, HttpServletResponse response) {
		try {
			Long leftFollowerId = RegUtil.getLong(super.getCookie(request, response, LEFT_FOLLOWER_COOKIE_NAME));
			Long rightFollowerId = RegUtil.getLong(super.getCookie(request, response, RIGHT_FOLLOWER_COOKIE_NAME));

			if (leftFollowerId == null && rightFollowerId == null) {
				// log.info("cansync-no-cookie,please auth both left and right!" + leftFollowerId + rightFollowerId);
			} else {
				relationService.cancelRelation(leftFollowerId, rightFollowerId);
				super.delCookie(response, LEFT_FOLLOWER_COOKIE_NAME);
				super.delCookie(response, RIGHT_FOLLOWER_COOKIE_NAME);
				// log.info("cansync success:" + leftFollowerId + "," + rightFollowerId + "," + ServerUtil.getRealIp(request));
			}

			String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
			response.sendRedirect(basePath);
		} catch (Exception e) {
			// log.error("cansync-error: ", e);
			// super.outputRtn(request, response, new JsonRtn<Object>(-1, "网络超时，请稍后重试！").toJsonString());
			// super.outputRtn(request, response, new JsonRtn<Object>(-1, e.toString() + Arrays.toString(e.getStackTrace())).toJsonString());

			ByteArrayOutputStream os = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(os);
			e.printStackTrace(ps);
			String errorMsg = "";
			try {
				errorMsg = os.toString("UTF8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}

			// log.error("auth-error: ", e);
			super.outputRtn(request, response, new JsonRtn<Object>(-1, errorMsg).toJsonString());
			// super.outputRtn(request, response, new JsonRtn<Object>(-1, "网络超时，请稍后重试！").toJsonString());

		}
	}
}
