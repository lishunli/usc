package org.usc.weibo.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.usc.weibo.job.SendWeiboJob;
import org.usc.weibo.util.Constants;

import com.xunlei.game.activity.job.JobFactory;

/**
 *
 * @author Shunli
 */
public class SnsSyncListener implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			// Logger log = LogFactory.getLogger(Constants.LOG_DIR, Constants.ACT_DIR, "sendWeiboJob");

			JobFactory.instance().initJob("snssync.sendweibojob", SendWeiboJob.class, null, null, Constants.SNS_SYNC_JOB_CRON);

			// log.info("snssync.job.init.success!");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
