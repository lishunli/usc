package org.usc.weibo.cache;

import org.usc.weibo.util.Constants;

/**
 *
 * @author Shunli
 */
public class CacheEntry<T> {
	private T item;
	private long lastCacheTimeMillis;

	public CacheEntry(T item) {
		this.item = item;
		this.lastCacheTimeMillis = System.currentTimeMillis();
	}

	public T getItem() {
		return item;
	}

	public long getLastCacheTimeMillis() {
		return lastCacheTimeMillis;
	}

	public boolean isExpired() {
		return System.currentTimeMillis() - lastCacheTimeMillis > Constants.CACHE_PERIOD;
	}

}
