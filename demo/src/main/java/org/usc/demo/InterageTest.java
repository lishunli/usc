package org.usc.demo;

/**
 *
 * @author ShunLi
 */
public class InterageTest {

    private final static int i1 = 0;
    private final static Integer i2 = 1;

    public static void main(String[] args) {
        Integer i = new Integer(0);
        System.out.println(i == i1);
        System.out.println(i == i2);
    }
}
