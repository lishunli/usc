package org.usc.demo.guava;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

/**
 *
 * @author Shunli
 */
public class Test8 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Currency> yourList = new ArrayList<Currency>();
        yourList.add(new Currency("1", 2));
        yourList.add(new Currency("1", 1));
        yourList.add(new Currency("2", 1));

        Multimap<String, Currency> grouped = Multimaps.index(yourList, new Function<Currency, String>() {
            @Override
            public String apply(Currency item) {
                return item.getUserId();
            }
        });

        System.out.println(grouped);

        Multimap<String, Currency> myMultimap = ArrayListMultimap.create();
        for (Currency levelRank : yourList) {
            myMultimap.put(levelRank.getUserId(), levelRank);
        }

        System.out.println(myMultimap.asMap());

        //
        // Map<String, Currency> mappedRoles = Maps.uniqueIndex(yourList, new Function<Currency, String>() {
        // public String apply(Currency from) {
        // return from.getServerId();
        // }
        // });

        // System.out.println(mappedRoles);
    }

}
