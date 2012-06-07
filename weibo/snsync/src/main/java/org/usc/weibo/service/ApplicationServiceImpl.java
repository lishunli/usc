package org.usc.weibo.service;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.WeakHashMap;

import org.usc.weibo.cache.CacheEntry;
import org.usc.weibo.dao.ApplicationDao;
import org.usc.weibo.vo.Application;
import org.usc.weibo.vo.Provider;

import com.xunlei.game.activity.dao.DaoFactory;

public class ApplicationServiceImpl implements ApplicationService {
	private final static Random random = new Random();
	private static ApplicationDao dao = DaoFactory.getDao(ApplicationDao.class);
	private Map<String, CacheEntry<Application>> appCacheById = new WeakHashMap<String, CacheEntry<Application>>(); // key = appId
	private Map<Provider, CacheEntry<List<Application>>> appCacheByProvider = new WeakHashMap<Provider, CacheEntry<List<Application>>>(); // key = provider

	@Override
	public Application findAppById(String appId) {
		Application app = null;
		CacheEntry<Application> cacheEntry = appCacheById.get(appId);

		if (cacheEntry != null && !cacheEntry.isExpired()) {
			app = cacheEntry.getItem();
		} else { // no cache or cache is invalid
			app = dao.findAppById(appId);
			appCacheById.put(appId, new CacheEntry<Application>(app));
		}

		return app;
	}

	@Override
	public Application randGetOneApp(Provider provider) {
		List<Application> apps = null;
		CacheEntry<List<Application>> cacheEntry = appCacheByProvider.get(provider);

		if (cacheEntry != null && !cacheEntry.isExpired()) {
			apps = cacheEntry.getItem();
		} else { // no cache or cache is invalid
			apps = dao.findAppsByProvider(provider);
			appCacheByProvider.put(provider, new CacheEntry<List<Application>>(apps));
		}

		int size = apps.size();
		if (size > 0) {
			return apps.get(random.nextInt(size));
		}
		return null;
	}

}
