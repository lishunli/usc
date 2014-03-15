package org.usc.demo.guava.cache;

import java.util.concurrent.ExecutionException;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 *
 * @author Shunli
 */
public abstract class AbstractCache1<K, V> {
    protected LoadingCache<K, V> cache = newBuilder().build(new CacheLoader<K, V>() {
        @Override
        public V load(K key) throws Exception {
            return loadCache(key);
        }
    });

    protected CacheBuilder<Object, Object> newBuilder() {
        return CacheBuilder.newBuilder();
    }

    protected abstract V loadCache(K key) throws Exception;

    public V get(K key) throws Exception {
        return cache.get(key);
    }

    public V getToNull(K key) {
        try {
            return cache.get(key);
        } catch (ExecutionException e) {
            return null;
        }
    }

    public V getUnchecked(K key) {
        return cache.getUnchecked(key);
    }

    public void refresh(K key) {
        if (key != null) {
            cache.refresh(key);
        }
        // else {
        // invalidateAll();
        // }
    }

    public void invalidate(K key) {
        if (key != null) {
            cache.invalidate(key);
        }
    }

    public void invalidateAll() {
        cache.invalidateAll();
    }
}
