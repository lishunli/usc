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
 * 提供统一的接口
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
			Long leftFollowerId = RegUtil.getLong(request.getParameter("leftFollowerId"));
			Long rightFollowerId = RegUtil.getLong(request.getParameter("rightFollowerId"));
			Relation relation = new Relation(leftFollowerId, rightFollowerId); // default is two-way

			relationService.addRelation(relation);
		} catch (Exception e) {
			log.error("doAction-error: ", e);
			super.outputRtn(request, response, new JsonRtn<Object>(-1, "网络超时，请稍后重试！").toJsonString());
		}
	}
}
