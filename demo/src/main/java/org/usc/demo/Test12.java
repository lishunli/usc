package org.usc.demo;

/**
 *
 * @author Shunli
 */
public class Test12 {
    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        System.out.println(now - 5 * 60 * 1000);
        System.out.println(now);

        long stamp = 1372384286L;

        System.out.println(Math.abs(now - stamp) > 5 * 60 * 1000);
        System.out.println(Math.abs(now - stamp * 1000) > 5 * 60 * 1000);

        if (Math.abs(now - stamp) > 5 * 60 * 1000 && Math.abs(now - stamp * 1000) > 5 * 60 * 1000) {
            System.out.println("expired");
        }

    }
}
