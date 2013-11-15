package org.usc.demo;

import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author Shunli
 */
public class RandomGenerator {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(RandomStringUtils.randomAlphanumeric(6));
        }
    }

}
