package org.usc.demo.trove;

import gnu.trove.map.hash.THashMap;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;

public class TroveTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int times = 10000000;

        long start = System.currentTimeMillis();
        Map<String, String> map2 = new HashMap<String, String>();
        for (int i = 0; i < times; i++) {
            map2.put(RandomStringUtils.randomAlphanumeric(4), RandomStringUtils.randomAlphanumeric(10));
        }
        System.out.println("JDK-escaped" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        THashMap<String, String> map = new THashMap<String, String>();
        for (int i = 0; i < times; i++) {
            map.put(RandomStringUtils.randomAlphanumeric(4), RandomStringUtils.randomAlphanumeric(10));
        }
        System.out.println("Trove-escaped" + (System.currentTimeMillis() - start));

    }

}
