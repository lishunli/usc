package org.usc.demo;


/**
 *
 * @author Shunli
 */
public class Test11 {
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        B b1 = new B();
        b1.addCache("test1", "test1");

        B b2 = new B();
        b2.addCache("test2", "test2");

        B b3 = new B();
        System.out.println(b3.getCache());

    }
}
