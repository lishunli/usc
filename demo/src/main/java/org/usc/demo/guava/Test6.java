package org.usc.demo.guava;

import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 *
 * @author Shunli
 */
public class Test6 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = ImmutableList.of("1", "2", "3", "4", "5", "6", "7");
        List<List<String>> partition = new Partition<String>(list, 3);
        System.out.println(partition);

        List<List<String>> distribution = new Distribution<String>(list, 3);
        System.out.println(distribution);
        // for (List<String> list2 : distribution) {
        // System.out.println(list2);
        // }
        // System.out.println("end");
    }

}
