package org.usc.demo.guava;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.RateLimiter;


/**
 * @author Shunli
 */
public class RateLimiterTest3 {

    private static final LoadingCache<String, RateLimiter> cache = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.HOURS).build(
    //private static final LoadingCache<String, RateLimiter> cache = CacheBuilder.newBuilder().maximumSize(10000).build(
            new CacheLoader<String, RateLimiter>() {
                @Override
                public RateLimiter load(String ip) throws Exception {
                    return RateLimiter.create(60 / 60.0);
                }
            });


    public static boolean isLimited(String ip) {
        try {
            RateLimiter rateLimiter = cache.get(ip);
           return !(rateLimiter.tryAcquire());
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) throws ExecutionException {
        while(true){
            String ip = RandomStringUtils.randomAlphanumeric(20);
            cache.get(ip);
            System.out.println(ip);
        }

    }


}
