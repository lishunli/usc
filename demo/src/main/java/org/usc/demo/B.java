package org.usc.demo;

import java.util.HashMap;
import java.util.Map;

public class B {
    // static {
    // System.out.println("hellojava");
    // }
    // public static final String NAME = "bluedavy";

    private static final Map<String, String> cache = new HashMap<String, String>();

    public static void addCache(String key, String value) {
        cache.put(key, value);
    }

    public static Map<String, String> getCache() {
        return cache;
    }
}
