package org.usc.demo.trove;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;

public class MapTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
//        System.gc();
        int times = 10000000;

        long start = System.currentTimeMillis();
        Map<String, String> map2 = new HashMap<String, String>();
        for (int i = 0; i < times; i++) {
            map2.put(RandomStringUtils.randomAlphanumeric(4), RandomStringUtils.randomAlphanumeric(10));
        }
        System.out.println("JDK-escaped" + (System.currentTimeMillis() - start));

    }

}
