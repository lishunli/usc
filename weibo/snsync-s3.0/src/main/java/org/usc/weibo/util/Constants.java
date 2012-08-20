package org.usc.weibo.util;

import com.xunlei.game.activity.config.DynamicConfig;

public class Constants {
	public static final String JDBC_JNDI_YOUXI_WEIBO = "jdbc/xlgame_youxi_weibo";

	public static DynamicConfig.Config CONF = DynamicConfig.instance().newConfig("snsync-config.properties");

	public static final String LOG_DIR = CONF.getValue("log_dir");
	public static final String ACT_DIR = CONF.getValue("act_dir");
	public static final String SYNC_DATE_FORMATE = "yyyyMMdd";

	public static final Long CACHE_PERIOD = 2 * 60 * 60 * 1000L; // h
	public static final Integer WEIBO_CONTENT_MAX_LENGTH = 140;

	public static final String SERVERLIST = CONF.getValue("serverlist");
	public static final String WEIBO_CACHE_PREFIX = "WEIBO_";

	public static final String SINA_WEIBO_CALL_BACK_REDIRECT_URI_PROP = "sina_weibo_call_back_redirect_uri";
	public static final String DOMAIN = CONF.getValue("domain");

}
