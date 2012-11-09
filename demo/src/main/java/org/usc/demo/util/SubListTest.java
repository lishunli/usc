package org.usc.demo.util;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Shunli
 */
public class SubListTest {

    public static void main(String[] args) {
        int count = 28;
        List<String> list1 = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            list1.add("Test" + (i + 1));
        }

        List<List<String>> subListList1 = ListUtil.doSubList(list1, 10);
        for (List<String> subList : subListList1) {
            System.out.println(subList);
        }

        List<Integer> list2 = new ArrayList<Integer>();
        for (int i = 0; i < count; i++) {
            list2.add(i + 1);
        }

        List<List<Integer>> subListList2 = ListUtil.doSubList(list2, 20);
        for (List<Integer> subList : subListList2) {
            System.out.println(subList);
        }
    }

}
