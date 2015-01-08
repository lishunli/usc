package org.usc.demo;

import java.util.HashSet;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

/**
 *
 * @author Shunli
 */
public class Test21 {
    public static void main(String[] args) {
        String all = "1234";
        String choose1 = "124";
        String right1 = "123";

        HashSet<Character> allSet = Sets.newHashSet(Lists.charactersOf(all));
        HashSet<Character> choose1Set = Sets.newHashSet(Lists.charactersOf(choose1));
        HashSet<Character> right1Set = Sets.newHashSet(Lists.charactersOf(right1));

        if (Sets.difference(choose1Set, allSet).size() == 0) {
            System.out.println("匹配");
        } else {
            System.out.println("参数错误");
        }

        System.out.println(Sets.intersection(choose1Set, right1Set).size());

        String choose2 = "1";
        String right2 = "3";

        HashSet<Character> choose2Set = Sets.newHashSet(Lists.charactersOf(choose2));
        HashSet<Character> right2Set = Sets.newHashSet(Lists.charactersOf(right2));

        if (Sets.difference(choose2Set, allSet).size() == 0) {
            System.out.println("匹配");
        } else {
            System.out.println("参数错误");
        }

        System.out.println(Sets.intersection(choose2Set, right2Set).size());

    }
}
