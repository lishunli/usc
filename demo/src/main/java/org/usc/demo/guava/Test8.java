package org.usc.demo.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 *
 * @author Shunli
 */
public class Test8 {
    public static <K, V> LoadingCache<K, V> cached(CacheLoader<K, V> cacheLoader) {
        LoadingCache<K, V> cache = CacheBuilder.newBuilder().build(cacheLoader);
        return cache;
    }

    public static void main(String[] args) {

    }

}
