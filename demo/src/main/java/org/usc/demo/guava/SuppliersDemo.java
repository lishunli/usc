package org.usc.demo.guava;

import org.apache.commons.lang3.RandomStringUtils;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/**
 *
 * @author Shunli
 */
public class SuppliersDemo {
    private static Supplier<String> cache = Suppliers.memoize(load());

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("start");
        System.out.println(cache.get());
        System.out.println(cache.get());
        System.out.println("end");

         int i = 0;
         while (true) {
         System.out.println(cache.get());

         if ((++i) % 10000 == 0) {
         System.out.println("re-load");
         cache = Suppliers.memoize(load());
         }

         }
    }
    private static Supplier<String> load() {
        System.out.println("xx");

        return new Supplier<String>() {
            @Override
            public String get() {
                System.out.println("load");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                }

                return RandomStringUtils.randomAlphabetic(6);
            }
        };
    }
}
