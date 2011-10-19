package org.usc.demo;

import java.math.BigDecimal;

/**
 *
 * @author ShunLi
 */
public class Test3 {

    public static void main(String[] args) {
        BigDecimal b1 = null;
        BigDecimal b2 = BigDecimal.ZERO;
        BigDecimal b3 = new BigDecimal("1.1");
        BigDecimal b4 = new BigDecimal("1.10");

        System.out.println(b1 == b2);
        System.out.println(b3 == b4);
        System.out.println(b3.compareTo(b4));
        System.out.println(b1 == BigDecimal.ZERO);
        System.out.println(b2 == BigDecimal.ZERO);
    }

}
