package org.usc.demo.lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Shunli
 */
public class LotteryUtil {
    public static int lottery(List<Double> orignalRates) {
        if (orignalRates == null || orignalRates.isEmpty()) {
            return -1;
        }

        int size = orignalRates.size();
        List<Double> sortOrignalRates = new ArrayList<Double>(size);

        Double sumRate = 0d;
        for (Double rate : orignalRates) {
            sumRate += rate;
        }

        Double tempSumRate = 0d;
        for (Double rate : orignalRates) {
            tempSumRate += rate;
            sortOrignalRates.add(tempSumRate / sumRate);
        }

        double nextDouble = Math.random();
        sortOrignalRates.add(nextDouble);
        Collections.sort(sortOrignalRates);

        return sortOrignalRates.indexOf(nextDouble);
    }
}
