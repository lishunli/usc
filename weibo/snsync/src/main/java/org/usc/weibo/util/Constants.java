package org.usc.weibo.util;

import org.usc.weibo.config.Config;

public class Constants {
	public static final String JDBC_JNDI_YOUXI_WEIBO = "jdbc/xlgame_youxi_weibo";

	public static final String LOG_DIR = Config.getProperty("log_dir");
	public static final String ACT_DIR = "snsync";
	public static final String SYNC_DATE_FORMATE = "yyyyMMdd";

	public static final Long CACHE_PERIOD = 2 * 60 * 60 * 1000L; // h
	public static final Integer WEIBO_CONTENT_MAX_LENGTH = 140;

	public static final String SERVERLIST = Config.getProperty("serverlist");
	public static final String WEIBO_CACHE_PREFIX = "WEIBO_";

	public static final String DOMAIN = Config.getProperty("domain");

	public static final String SNS_SYNC_JOB_CRON = Config.getProperty("sns_sync_job_cron");

}
