package org.usc.demo;

import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author Shunli
 */
public class Test15 {
    // private static final String ORDER_ID_PREFIX = "54";

    public static void main(String[] args) {
        for (int i = 0; i < 10000000; i++) {
            // String uuid = UUID.randomUUID().toString();
            //
            // System.out.println(uuid);
            // System.out.println(StringUtils.overlay(uuid, ORDER_ID_PREFIX, 0, ORDER_ID_PREFIX.length()));
            // System.out.println(RandomUtils.nextInt(10));
            System.out.println(RandomStringUtils.randomNumeric(4));
        }
    }
}

// System.out.println(StringUtils.overlay(UUID.randomUUID().toString(), "54", 0, 2));
