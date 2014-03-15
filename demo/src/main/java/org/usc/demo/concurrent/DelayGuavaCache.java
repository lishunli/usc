package org.usc.demo.concurrent;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class DelayGuavaCache {
    private final static DelayQueue<DelayItem<String>> queue = new DelayQueue<DelayItem<String>>();
    private final static LoadingCache<String, String> cache = CacheBuilder.newBuilder().build(new CacheLoader<String, String>() {
        @Override
        public String load(String key) throws Exception {
            long time = 2;
            TimeUnit unit = TimeUnit.SECONDS;
            long nanoTime = TimeUnit.NANOSECONDS.convert(time, unit);
            queue.put(new DelayItem<String>(key, nanoTime));

            // System.out.println(System.nanoTime());
            System.out.println(TimeUnit.SECONDS.convert(System.nanoTime(), TimeUnit.NANOSECONDS));
            return "DelayGuavaCache-" + RandomStringUtils.randomAlphanumeric(6);
        }
    });

    static {
        Thread daemonThread = new Thread(new Runnable() {
            public void run() {
                delayCheck();
            }
        });
        daemonThread.setDaemon(true);
        daemonThread.start();
    }

    private static void delayCheck() {
        while (true) {
            try {
                DelayItem<String> delayItem = queue.take();
                if (delayItem != null) {
                    cache.invalidate(delayItem.getItem());// invalidate cache for expiry/delay item
                }
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public static String get(String key) {
        return cache.getUnchecked(key);
    }
}
