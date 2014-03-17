package org.usc.demo.guava;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/**
 *
 * @author Shunli
 */
public class SupplierDemo2 {
    private static Supplier<String> buildSupplier() {
        return Suppliers.memoizeWithExpiration(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println("load-cache");
                return RandomStringUtils.randomAlphanumeric(10);
            }
        }, 1, TimeUnit.MINUTES);
    }

    private static Supplier<String> cache = buildSupplier();

    private static String get() {
        return cache.get();
    }

    private static void refresh() {
        cache = buildSupplier();
    }

    public static void main(String[] args) {
        System.out.println(get());
        System.out.println(get());

        refresh();
        System.out.println(get());
        System.out.println(get());
    }
}
