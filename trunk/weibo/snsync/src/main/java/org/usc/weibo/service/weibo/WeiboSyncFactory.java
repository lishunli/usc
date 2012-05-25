package org.usc.weibo.service.weibo;

import java.util.List;

import org.apache.log4j.Logger;

import com.xunlei.game.activity.log.LogFactory;
import com.xunlei.game.activity.service.ServiceFactory;
import org.usc.weibo.service.ApplicationService;
import org.usc.weibo.util.Constants;
import org.usc.weibo.vo.Follower;
import org.usc.weibo.vo.Pair;
import org.usc.weibo.vo.Provider;
import org.usc.weibo.vo.WeiboContent;

/**
 *
 * @author Shunli
 */
public class WeiboSyncFactory {
	private static Logger log = LogFactory.getLogger(Constants.LOG_DIR, Constants.ACT_DIR, "sendWeiboJob");

	protected static ApplicationService appService = ServiceFactory.getService(ApplicationService.class);

	public static void weiboSync(Follower leftFollower, Follower rightFollower, Integer isTwoWay) throws Exception {
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
	 * @param leftWeiboService
	 * @param rightWeiboService
	 * @throws Exception
	 */
	private static void oneWaySync(WeiboService leftWeiboService, WeiboService rightWeiboService) throws Exception {
		// 1st. read
		Pair<Pair<Long, Long>, List<WeiboContent>> leftReader = leftWeiboService.read();

		if (leftReader == null) {
			log.info("something error, please check." + leftReader);
			return;
		}

		// 2nd. write weibo.
		rightWeiboService.write(leftReader.getSecond());

		// 3rd. update last id.
		Pair<Long, Long> lastInfo = leftReader.getFirst();
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
