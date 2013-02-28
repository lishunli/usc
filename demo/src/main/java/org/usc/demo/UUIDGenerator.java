package org.usc.demo;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Shunli
 */
public class UUIDGenerator {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
        }
    }

}
