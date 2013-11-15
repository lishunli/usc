package org.usc.demo;

/**
 *
 * @author Shunli
 */
public class Test17 {

    public static void main(String[] args) {
        int j = 1;
        int size = 1000;

        for (int i = 0; i < 10000; i++) {
            if (++j % size == 0) {
                System.out.println("haha");
            }

        }

    }
}
