package org.usc.demo.guava;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/**
 *
 * @author Shunli
 */
public class Test7 {
    private static Supplier<String> cache = Suppliers.memoizeWithExpiration(load(), 10, TimeUnit.SECONDS);

    public static void main(String[] args) {
        while (true) {
            // System.out.println(cache.get());
            cache.get();
        }
    }

    private static Supplier<String> load() {
        return new Supplier<String>() {
            @Override
            public String get() {
                String rtn = RandomStringUtils.randomAlphabetic(6);
                System.out.println("load-" + rtn);
                return rtn;
            }
        };
    }
}
