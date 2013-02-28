package org.usc.demo;

import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author Shunli
 */
public class Rand {

    /**
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            System.out.println("XTBZC" + RandomStringUtils.randomAlphanumeric(15));
        }
    }

}
