package org.usc.demo.guava;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;

public class GuavaCacheDemo {
    public static void main(String[] args) throws ExecutionException {
        // //设置缓存最大个数为100，缓存过期时间为5秒
        LoadingCache<String, Long> cache = CacheBuilder.newBuilder().recordStats()
                .maximumSize(18)
                .expireAfterAccess(5, TimeUnit.SECONDS)
                .build(new CacheLoader<String, Long>() {
                    @Override
                    public Long load(String key) throws Exception {
                        System.out.println("load " + key);
                        return Long.valueOf(key);
                    }

                });

        System.out.println(cache.stats());
        for (int i = 0; i < 20; i++) {
            cache.get(i + "");
            System.out.println(cache.asMap());
            // System.out.println(value);
        }
        System.out.println("next");
        for (int i = 19; i >= 0; i--) {
            cache.get(i + "");
            System.out.println(cache.get(i + ""));
            // System.out.println(cache.asMap());
            // System.out.println(value);
        }

        cache.get("100");

        CacheStats stats = cache.stats();
        stats.hitRate();
        stats.missRate();
        stats.loadExceptionRate();
        stats.averageLoadPenalty();

        System.out.println(stats.hitRate());
        System.out.println(stats.missRate());
        System.out.println(stats.loadExceptionRate());
        System.out.println(stats.averageLoadPenalty());
        System.out.println(stats);

        // CacheStats delta = cache.stats().minus(stats);
        // delta.hitCount();
        // delta.missCount();
        // delta.loadSuccessCount();
        // delta.loadExceptionCount();
        // delta.totalLoadTime();
        //
        // System.out.println(delta.hitCount());
        // System.out.println(delta.missCount());
        // System.out.println(delta.loadSuccessCount());
        // System.out.println(delta.loadExceptionCount());
        // System.out.println(delta.totalLoadTime());

    }
}
