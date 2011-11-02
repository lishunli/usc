package org.usc.demo;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ShunLi
 */
public class Test4 {
    public static void main(String[] args) {
        int count = 1000000;

//        long start = System.nanoTime();
//        for (int i = 0; i < count; i++) {
//            for (String string : getDate()) {
//                string = string + "1";
//            }
//        }
//        System.out.println(System.nanoTime() - start);

        long start2 = System.nanoTime();
        for (int i = 0; i < count; i++) {
            List<String> date = getDate();
            for (String string : date) {
                string = string + "1";
            }
        }
        System.out.println(System.nanoTime() - start2);
    }

    private static List<String> getDate() {
        return Arrays.asList("1", "1", "1", "1", "1", "1", "1", "1", "1", "1");
    }

}
