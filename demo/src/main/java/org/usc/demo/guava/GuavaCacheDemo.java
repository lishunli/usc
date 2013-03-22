package org.usc.demo.guava;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class GuavaCacheDemo {
    public static void main(String[] args) throws ExecutionException {
        // //设置缓存最大个数为100，缓存过期时间为5秒
        LoadingCache<String, Long> cache = CacheBuilder.newBuilder().maximumSize(18)
                .expireAfterAccess(5, TimeUnit.SECONDS).build(new CacheLoader<String, Long>() {
                    @Override
                    public Long load(String key) throws Exception {
                        System.out.println("load " + key);
                        return Long.valueOf(key);
                    }

                });

        for (int i = 0; i < 20; i++) {
            cache.get(i + "");
             System.out.println(cache.asMap());
            // System.out.println(value);
        }
        System.out.println("next");
        for (int i = 19; i >= 0; i--) {
            cache.get(i + "");
            // System.out.println(cache.asMap());
            // System.out.println(value);
        }

    }
}
