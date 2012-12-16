package org.usc.demo.guava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<Currency> previousList = new ArrayList<Currency>();
        previousList.add(new Currency("U1", 10));
        previousList.add(new Currency("U1", 10));
        previousList.add(new Currency("U2", 15));

        List<Currency> todayList = new ArrayList<Currency>();
        todayList.add(new Currency("U1", 10));
        todayList.add(new Currency("U2", 10));
        todayList.add(new Currency("U3", 35));

        for (int i = 0; i < 1000000; i++) {
            Map<String, Currency> sumMap = new HashMap<String, Currency>();
            doSum(previousList, sumMap);
            doSum(todayList, sumMap);

            ArrayList<Currency> list = new ArrayList<Currency>(sumMap.values());
            Collections.sort(list);
            System.out.println(list);
        }

    }

    private static void doSum(List<Currency> currencys, Map<String, Currency> sumMap) throws CloneNotSupportedException {
        for (Currency currency : currencys) {
            String key = currency.getUserId();

            if (sumMap.containsKey(key)) {
                Currency tempCcy = sumMap.get(key);
                tempCcy.setQty(tempCcy.getQty() + currency.getQty());
            } else {
                sumMap.put(key, (Currency) currency.clone());
            }
        }
    }

}
