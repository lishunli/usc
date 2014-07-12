package org.usc.demo;

import java.util.Arrays;

/**
 *
 * @author Shunli
 */
public class Test17 {

    public static void main(String[] args) {
//        int j = 1;
//        int size = 1000;
//
//        for (int i = 0; i < 10000; i++) {
//            if (++j % size == 0) {
//                System.out.println("haha");
//            }
//
//        }

        String[] array = {"1"};
        System.out.println(Arrays.toString(array));
        
        array[0] = "2";
        System.out.println(Arrays.toString(array));
    }
}
