package org.usc.demo.guava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class Test {
    public static void main(String[] args) {
        List<Currency> previousList = new ArrayList<Currency>();
        previousList.add(new Currency("U1", 10));
        previousList.add(new Currency("U1", 10));
        previousList.add(new Currency("U2", 15));

        List<Currency> todayList = new ArrayList<Currency>();
        todayList.add(new Currency("U1", 10));
        todayList.add(new Currency("U2", 10));
        todayList.add(new Currency("U3", 35));

        // SortedSetMultimap<String, Currency> sortMultiMap = SortedSeWtMultimap.class

        Multimap<String, Currency> multiMap = HashMultimap.create();
        doSum(previousList, multiMap);
        doSum(todayList, multiMap);

        System.out.println(multiMap);

        List<Collection<Currency>> ccys = new ArrayList<Collection<Currency>>(multiMap.asMap().values());
        Comparator<Collection<Currency>> c = new Comparator<Collection<Currency>>() {
            @Override
            public int compare(Collection<Currency> o1, Collection<Currency> o2) {
                int leftSum = 0, rightSum = 0;
                for (Currency ccy : o1) {
                    leftSum += ccy.getQty();
                }
                for (Currency ccy : o2) {
                    rightSum += ccy.getQty();
                }

                return rightSum - leftSum;
            }
        };
        Collections.sort(ccys, c);

        System.out.println(ccys);

    }

    private static void doSum(List<Currency> currencys, Multimap<String, Currency> multiMap) {
        for (Currency currency : currencys) {
            multiMap.put(currency.getUserId(), currency);
        }
    }

}
