package org.usc.demo.guava;

/**
 *
 * @author Shunli
 */
public class CacheTest {
    // private static final Cache11 cache11 = CacheFactory1.getInstance(Cache11.class);

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Cache11 cache11 = new Cache11();
        // CacheOne cacheOne = CacheOne.getInstance();
        System.out.println(cache11.getUnchecked("1"));
        System.out.println(cache11.getUnchecked("1"));

        // Cache21 cache21 = new Cache21();

        System.out.println(CacheFactory1.getInstance(Cache11.class).getUnchecked("1"));
        System.out.println(CacheFactory1.getInstance(Cache11.class).getUnchecked("1"));
        System.out.println(CacheFactory2.getInstance(Cache11.class).getUnchecked("1"));
        System.out.println(CacheFactory2.getInstance(Cache11.class).getUnchecked("1"));
        System.out.println(CacheFactory3.getInstance(Cache11.class).getUnchecked("1"));
        System.out.println(CacheFactory3.getInstance(Cache11.class).getUnchecked("1"));
        System.out.println(CacheFactory3.getInstance(Cache12.class).getUnchecked("1"));
        System.out.println(CacheFactory3.getInstance(Cache12.class).getUnchecked("1"));

        while (true) {
            System.out.println(CacheFactory3.getInstance(Cache12.class).getUnchecked("1"));
        }
    }
}
