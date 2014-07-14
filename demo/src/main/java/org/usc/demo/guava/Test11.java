package org.usc.demo.guava;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 *
 * @author Shunli
 */
public class Test11 {
    public static void main(String[] args) {
        List<String> list = ImmutableList.of("a", "b", "c", "d", "e");

        System.out.println(Lists.partition(list, 2));

        System.out.println(Iterables.partition(list, 2));
        System.out.println(Iterables.paddedPartition(list, 2));
    }

}
