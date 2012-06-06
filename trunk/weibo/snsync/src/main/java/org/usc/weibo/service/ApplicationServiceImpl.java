package org.usc.weibo.service;

import java.util.Map;
import java.util.WeakHashMap;

import org.usc.weibo.cache.CacheEntry;
import org.usc.weibo.dao.ApplicationDao;
import org.usc.weibo.vo.Application;
import org.usc.weibo.vo.Provider;

import com.xunlei.game.activity.dao.DaoFactory;

public class ApplicationServiceImpl implements ApplicationService {
	private static ApplicationDao dao = DaoFactory.getDao(ApplicationDao.class);
	private Map<String, CacheEntry<Application>> appCache = new WeakHashMap<String, CacheEntry<Application>>(); // appId

	@Override
	public Application findAppById(String appId) {
		Application app = null;
		CacheEntry<Application> cacheEntry = appCache.get(appId);

		if (cacheEntry != null && !cacheEntry.isExpired()) {
			app = cacheEntry.getItem();
		} else { // no cache or cache is invalid
			app = dao.findAppById(appId);
			appCache.put(appId, new CacheEntry<Application>(app));
		}

		return app;
	}

	@Override
	public Application findAppByProvider(Provider provider) {
		return dao.findAppByProvider(provider);
	}

	@Override
	public Application randGetOneApp(Provider provider) {
		return dao.randGetOneApp(provider);
	}

}
