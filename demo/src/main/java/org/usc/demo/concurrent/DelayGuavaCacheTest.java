package org.usc.demo.concurrent;


public class DelayGuavaCacheTest<K, V> {
    public static void main(String[] args) throws Exception {
        System.out.println(DelayGuavaCache.get("1"));

        Thread.sleep(1000 * 2);
        {
            System.out.println(DelayGuavaCache.get("1"));
        }

        Thread.sleep(1000 * 2);
        {
            System.out.println(DelayGuavaCache.get("1"));
        }

        for (;;) {
            DelayGuavaCache.get("1");
            System.out.println(DelayGuavaCache.get("1"));
        }
    }
}
