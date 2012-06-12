package org.usc.weibo.cache;

import com.sina.sae.memcached.SaeMemcache;

public class CacheService {
	private static CacheService instance = new CacheService();
	private static SaeMemcache mc = new SaeMemcache();;

	public static CacheService instance() {
		return instance;
	}
	private CacheService() {
		mc.init();
	}

	public SaeMemcache getClient() {
		return mc;
	}

	public <T> void saveObj(String key, T obj) {
		this.getClient().set(key, obj);
	}

	@SuppressWarnings("unchecked")
	public <T> T getObj(String key, Class<T> clazz) {
		Object o = this.getClient().get(key);
		if (o == null)
			return null;
		return (T) o;
	}
}
