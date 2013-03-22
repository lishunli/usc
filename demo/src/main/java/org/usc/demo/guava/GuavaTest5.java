package org.usc.demo.guava;

import java.util.concurrent.Callable;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 *
 * @author Shunli
 */
public class GuavaTest5 {

    public static void main(String[] args) throws Exception {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .build(); // look Ma, no CacheLoader

        // If the key wasn't in the "easy to compute" group, we need to
        // do things the hard way.
        final String key = "1";
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return doThingsTheHardWay(key);
            }
        };

        cache.get(key, callable);
        System.out.println("hello");
    }

    protected static String doThingsTheHardWay(String key) {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return key + "-value";
    }
}
