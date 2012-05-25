package org.usc.weibo.util;

import com.xunlei.game.activity.config.Config;
import com.xunlei.game.activity.utils.RegUtil;

public class Constants {
	public static final String JDBC_JNDI_YOUXI_WEIBO = "jdbc/xlgame_youxi_weibo";

	public static final String LOG_DIR = Config.getProperty("log_dir");
	public static final String ACT_DIR = "youxiweibo";
	public static final String SYNC_DATE_FORMATE = "yyyyMMdd";

	public static final String WEIBO_URL_PREFIX = Config.getProperty("weibo_url_prefix");
	public static final Long CACHE_PERIOD = RegUtil.getLong(Config.getProperty("cache_period")) * 60 * 60 * 1000L; // h
	public static final Integer WEIBO_CONTENT_MAX_LENGTH = 140;

	public static final String SERVERLIST = Config.getProperty("serverlist");
	// public static final Long REFRESH_CACHE_TIME = RegUtil.getLong(Config.getProperty("refresh_cache_time"));
	public static final String WEIBO_CACHE_PREFIX = "WEIBO_";
}
