package org.usc.weibo.web.servlet;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.usc.weibo.service.ApplicationService;
import org.usc.weibo.service.FollowerService;
import org.usc.weibo.service.RelationService;
import org.usc.weibo.util.Constants;

import com.xunlei.game.activity.log.LogFactory;
import com.xunlei.game.activity.service.ServiceFactory;
import com.xunlei.game.activity.web.servlet.BaseServlet;

/**
 * SnsBaseServlet
 *
 * @author Shunli
 */
public class SnsBaseServlet extends BaseServlet {
	private static final long serialVersionUID = -4919948752973997373L;
	protected static Logger log = LogFactory.getLogger(Constants.LOG_DIR, Constants.ACT_DIR, "snsbase");
	protected static final String LEFT_FOLLOWER_COOKIE_NAME = "leftFollowerId";
	protected static final String RIGHT_FOLLOWER_COOKIE_NAME = "rightFollowerId";
	protected static FollowerService followerService = ServiceFactory.getService(FollowerService.class);
	protected static ApplicationService appService = ServiceFactory.getService(ApplicationService.class);
	protected static RelationService relationService = ServiceFactory.getService(RelationService.class);

	@Override
	protected void setCookie(HttpServletRequest request, HttpServletResponse response, String cookiename, String cookievalue, int expiry) {
		Cookie cookie;
		try {
			cookie = new Cookie(cookiename, URLEncoder.encode(cookievalue, "UTF-8"));
			cookie.setDomain(Constants.DOMAIN);
			cookie.setMaxAge(-1);
			cookie.setPath("/");
			response.addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			log.error("setCookie-error: ", e);
		}
	}

	@Override
	protected void delCookie(HttpServletResponse response, String cookieName) {
		Cookie cookie = new Cookie(cookieName, null);
		cookie.setDomain(Constants.DOMAIN);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
}
