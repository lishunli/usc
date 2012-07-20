package org.usc.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author ShunLi
 */
public class RandomTest {
    private static final Random random = new Random();

    public static void main(String[] args) {
        // System.out.println(random.nextInt(10));
        // System.out.println(nextDouble);

        // Map<String,Double> rateMap = new HashMap<String, Double>() ;

        // rateMap.

        // List<Double> orignalRates = Arrays.asList(0.1d, 0.2d, 0.3d, 0.4d);
        List<Double> rates = Arrays.asList(0.1d, 0.3d, 0.6d, 1.0d);
        double result = rates.get(0);
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();

        for (int i = 0; i < 100000; i++) {
            double nextDouble = random.nextDouble();

            for (double rate : rates) {
                if (nextDouble >= rate) {
                    continue;
                }
                result = rate;
                break;
            }
            int index = rates.indexOf(result);
            // System.out.println(result + ":" + index);

            Integer value = count.get(index);
            count.put(index, value == null ? 1 : value + 1);
        }

        System.out.println(count);

        Set<Entry<Integer, Integer>> entrySet = count.entrySet();
        double sum = 0;
        for (Entry<Integer, Integer> entry : entrySet) {
            sum += entry.getValue();
        }
        for (Entry<Integer, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + ":" + entry.getValue() / sum);
        }
    }
}
