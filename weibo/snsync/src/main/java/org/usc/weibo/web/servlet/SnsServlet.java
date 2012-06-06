package org.usc.weibo.web.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.usc.weibo.service.RelationService;
import org.usc.weibo.util.Constants;
import org.usc.weibo.vo.Relation;

import com.xunlei.game.activity.log.LogFactory;
import com.xunlei.game.activity.service.ServiceFactory;
import com.xunlei.game.activity.utils.RegUtil;
import com.xunlei.game.activity.vo.JsonRtn;
import com.xunlei.game.activity.web.servlet.BaseServlet;

/**
 * sync
 *
 * @author Shunli
 */
@WebServlet(urlPatterns = "/snsservlet")
public class SnsServlet extends BaseServlet {
	private static final long serialVersionUID = -1477065409747225124L;
	protected static Logger log = LogFactory.getLogger(Constants.LOG_DIR, Constants.ACT_DIR, "snsservlet");
	protected static RelationService relationService = ServiceFactory.getService(RelationService.class);

	public void doAction(HttpServletRequest request, HttpServletResponse response) {
		try {

			Long leftFollowerId = RegUtil.getLong(super.getCookie(request, response, "leftFollowerId"));
			Long rightFollowerId = RegUtil.getLong(super.getCookie(request, response, "rightFollowerId"));

			if (leftFollowerId == null || rightFollowerId == null) {
				log.info("doAction-no-cookie,please auth both left and right!" + leftFollowerId + rightFollowerId);
				return;
			}

			Relation originRelation = relationService.findByTwoWayFollowers(leftFollowerId, rightFollowerId);

			if (originRelation == null) {
				Relation relation = new Relation(leftFollowerId, rightFollowerId); // default is two-way
				relationService.addRelation(relation);
			} else {
				// update , now is no-op, maybe will change th two way property.
				// originRelation.setIsTwoWay(0);
				// relationService.updateRelation(originRelation);
			}

			String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
			response.sendRedirect(basePath);
		} catch (Exception e) {
			log.error("doAction-error: ", e);
			super.outputRtn(request, response, new JsonRtn<Object>(-1, "网络超时，请稍后重试！").toJsonString());
		}
	}
}
