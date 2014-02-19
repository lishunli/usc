package org.usc.demo.guava;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/**
 *
 * @author Shunli
 */
public class Test6 {
    private static Supplier<String> cache = Suppliers.memoizeWithExpiration(load(), 1, TimeUnit.MINUTES);

    public static void main(String[] args) {
        while (true) {
            cache.get();
            // System.out.println(cache.get());
        }
    }

    private static Supplier<String> load() {
        return new Supplier<String>() {
            @Override
            public String get() {
                String randomAlphabetic = RandomStringUtils.randomAlphabetic(6);
                System.out.println("load-" + randomAlphabetic);
                return randomAlphabetic;
            }
        };
    }
}
