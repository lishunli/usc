package org.usc.demo.lottery;

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

        Double sumRate = 0d;
        for (Double rate : orignalRates) {
            sumRate += rate;
        }

        Double tempSumRate = 0d;
        double luckyNum = Math.random() * sumRate;
        for (int i = 0; i < size; i++) {
            tempSumRate += orignalRates.get(i);
            if (luckyNum < tempSumRate) {
                return i;
            }
        }

        return size - 1;
    }
}
