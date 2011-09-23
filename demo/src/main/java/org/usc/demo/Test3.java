package org.usc.demo;

import java.math.BigDecimal;

/**
 *
 * @author ShunLi
 */
public class Test3 {

    public static void main(String[] args) {
            BigDecimal b = new BigDecimal("-1.7777");
            System.out.println(b.setScale(2, 0));
    }

}
