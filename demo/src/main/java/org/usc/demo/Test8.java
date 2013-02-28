package org.usc.demo;

/**
 *
 * @author Shunli
 */
public class Test8 {

    public static void main(String[] args) {
        double probability = 0.2d;
        for (int i = 0; i < 10000; i++) {
            double random = Math.random();
            if (random >= (1 - probability)) {
                System.out.println("hit");
            } else {
                System.out.println("not hit");
            }
        }

        System.out.println("end");
    }
}
