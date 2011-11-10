package org.usc.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ShunLi
 */
public class ListTest {

    public static void main(String[] args) {

        int count = 10;

        long start = System.nanoTime();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for (int i = 0; i < count; i++) {
            arrayList.add(i);
        }

        // System.out.println("ArrayList add:" + (System.nanoTime() - start));

        // ArrayList<Integer> newArrayList = (ArrayList<Integer>) arrayList.clone();
        ArrayList<Integer> newArrayList = arrayList;
        newArrayList.remove(0);
        System.out.println(newArrayList);
        System.out.println(arrayList);

        List<String> list = Arrays.<String> asList("1");

        System.out.println(list);

        start = System.nanoTime();
        List<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 0; i < count; i++) {
            linkedList.add(i);
        }
        System.out.println("LinkedList add:" + (System.nanoTime() - start));

        start = System.nanoTime();
        while (!arrayList.isEmpty()) {
            arrayList.remove(0);
        }
        System.out.println("ArrayList remove:" + (System.nanoTime() - start));

        start = System.nanoTime();
        while (linkedList != null && linkedList.size() > 0) {
            linkedList.remove(0);
        }
        System.out.println("ArrayList remove:" + (System.nanoTime() - start));

    }
}
