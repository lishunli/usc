package org.usc.weibo.cache;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.usc.weibo.config.Config;

import com.sina.sae.memcached.SaeMemcache;

public class CacheService {
	private static CacheService instance = new CacheService();
	private static SaeMemcache mc;

	public static CacheService instance() {
		return instance;
	}
	private CacheService() {
		String ip = Config.getProperty("serverlist");

		if (StringUtils.isNotBlank(ip)) {
			mc = new SaeMemcache(new String[] { ip });
		} else {
			mc = new SaeMemcache();
		}

		mc.init();
	}

	public SaeMemcache getClient() {
		return mc;
	}

	public <T> void saveObj(String key, T obj) {
		this.getClient().set(key, obj);
	}

	public <T> void saveObj(String key, T obj, Long expiry) {
		this.getClient().set(key, obj, new Date().getTime() + expiry);
	}

	@SuppressWarnings("unchecked")
	public <T> T getObj(String key, Class<T> clazz) {
		Object o = this.getClient().get(key);
		if (o == null)
			return null;
		return (T) o;
	}

	public boolean deleteObj(String key) {
		return this.getClient().delete(key);
	}
}
