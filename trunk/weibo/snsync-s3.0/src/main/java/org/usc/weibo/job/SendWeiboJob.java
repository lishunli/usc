package org.usc.weibo.job;

import org.apache.log4j.Logger;
import org.usc.weibo.service.weibo.WeiboSyncFactory;
import org.usc.weibo.util.Constants;

import com.xunlei.game.activity.job.AbstractJob;
import com.xunlei.game.activity.log.LogFactory;

public class SendWeiboJob extends AbstractJob {
    private static Logger log = LogFactory.getLoggerDaily(Constants.LOG_DIR, Constants.ACT_DIR, "sendWeiboJob");

    @Override
    public void run() {
        try {
            log.info("SendWeiboJob start...");

            WeiboSyncFactory.sync();

            log.info("SendWeiboJob end...");
        } catch (Exception e) {
            log.error(e);
        }
    }

}
