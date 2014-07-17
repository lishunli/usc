package org.usc.demo.guava;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;

import com.google.common.base.Stopwatch;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.RateLimiter;

/**
* Created by Shunli on 2014/7/13.
*/
public class RateLimiterTest2 {

    private static final LoadingCache<String, RateLimiter> cache = CacheBuilder.newBuilder()/* .softValues() */.build(
            new CacheLoader<String, RateLimiter>() {
                @Override
                public RateLimiter load(String ip) throws Exception {
                    return RateLimiter.create(50 / 60.0);
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

        Stopwatch sw = Stopwatch.createStarted();
        for (int i = 0; i < 10000000; i++) {
            String ip = RandomStringUtils.randomNumeric(1);

            if (!isLimited(ip)) {
                System.out.println(ip + "," + sw.elapsed(TimeUnit.MILLISECONDS));
            } else {
                System.out.println(ip);
            }

            // try {
            // TimeUnit.MILLISECONDS.sleep(200);
            // } catch (InterruptedException e) {
            // e.printStackTrace();
            // }
        }

    }

}
