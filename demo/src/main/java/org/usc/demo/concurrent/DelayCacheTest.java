package org.usc.demo.concurrent;

import java.util.concurrent.TimeUnit;

public class DelayCacheTest<K, V> {
    public static void main(String[] args) throws Exception {
        DelayCache<Integer, String> cache = new DelayCache<Integer, String>();
        cache.put(1, "aaaa", 3, TimeUnit.SECONDS);

        Thread.sleep(1000 * 2);
        {
            String str = cache.get(1);
            System.out.println(str);
        }

        Thread.sleep(1000 * 2);
        {
            String str = cache.get(1);
            System.out.println(str);
        }
    }
}
