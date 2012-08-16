package org.usc.weibo.web.servlet;

import org.usc.weibo.cache.CacheService;
import org.usc.weibo.service.ApplicationService;
import org.usc.weibo.service.FollowerService;
import org.usc.weibo.service.RelationService;

import com.xunlei.game.activity.service.ServiceFactory;
import com.xunlei.game.activity.web.servlet.BaseServlet;

/**
 * SnsBaseServlet
 *
 * @author Shunli
 */
public class SnsBaseServlet extends BaseServlet {
	private static final long serialVersionUID = -4919948752973997373L;
	protected static final String LEFT_FOLLOWER_NAME = "_leftFollowerId";
	protected static final String RIGHT_FOLLOWER_NAME = "_rightFollowerId";
	protected static final CacheService instance = CacheService.instance();
	protected static FollowerService followerService = ServiceFactory.getService(FollowerService.class);
	protected static ApplicationService appService = ServiceFactory.getService(ApplicationService.class);
	protected static RelationService relationService = ServiceFactory.getService(RelationService.class);
}
