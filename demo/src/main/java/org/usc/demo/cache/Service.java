package org.usc.demo.cache;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author Shunli
 */
public class Service {
    public static List<String> getKeys(String giftId) {
         System.out.println("load from Service");

        List<String> keys = new ArrayList<String>(100);
        for (int i = 0; i < 100; i++) {
            keys.add(RandomStringUtils.randomAlphanumeric(10));
        }

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
        }

        return keys;
    }
}
