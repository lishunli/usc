package org.usc.weibo.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.usc.weibo.job.SendWeiboJob;
import org.usc.weibo.util.Constants;

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
            SchedulerFactory factory = new StdSchedulerFactory();
            Scheduler scheduler = factory.getScheduler();
            JobDetail jobDetail = null;
            Trigger trigger = null;
            jobDetail = new JobDetail("snssync.sendweibojob", "snssync.sendweibojobGroup", SendWeiboJob.class);

            trigger = new CronTrigger(SendWeiboJob.class.getName() + "Trigger", "snssync.sendweibojobGroup", Constants.SNS_SYNC_JOB_CRON);
            trigger.setJobName(jobDetail.getName());
            trigger.setJobGroup(jobDetail.getGroup());

            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
