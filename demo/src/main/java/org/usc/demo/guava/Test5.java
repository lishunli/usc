package org.usc.demo.guava;

import java.util.List;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class Test5 {
    public static void main(String[] args) {
        try {
            System.out.println(Lists.partition(ImmutableList.<String> of(), 10));
        } catch (Exception e) {
            System.out.println("empty-list");
        }

        List<String> list = null;
        Optional<List<String>> fromNullable = Optional.fromNullable(list);
        System.out.println(fromNullable.get());
    }

}
