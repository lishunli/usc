package org.usc.demo.lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrawUtil {

    public static int randomDraw(List<Double> list0) {
        if (list0 == null || list0.size() < 1)
            return -1;

        List<Double> list = new ArrayList<Double>();
        double sum = 0d;
        for (Double dd : list0) {
            sum += dd;
        }
        for (Double ddd : list0) {
            list.add(ddd / sum);
        }

        List<Double> nums = new ArrayList<Double>();
        double lest = 0;
        for (Double data : list) {
            double tmp = data.doubleValue();
            lest += tmp;
            nums.add(new Double(lest));
        }
        Double rtmp = Math.random();
        nums.add(new Double(rtmp));
        Collections.sort(nums);

        if (nums.indexOf(rtmp) >= list.size()) {
            double min = Double.MAX_VALUE;
            for (Double d : list) {
                if (d < min)
                    min = d;
            }
            return list.indexOf(min);
        }

        return nums.indexOf(rtmp);
    }

    public static int randomDraw(Double[] list) {
        if (list == null || list.length < 1)
            return -1;
        List<Double> list2 = new ArrayList<Double>();
        for (Double double1 : list) {
            list2.add(double1);
        }
        return randomDraw(list2);
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Double> list = new ArrayList<Double>();
        list.add(0.002d);
        list.add(0.998d);
        list.add(0.3d);
        list.add(0.4d);
        Double[] dd = list.toArray(new Double[] {});
        for (int i = 0; i < 100000; i++) {
            int rs = randomDraw(dd);
            int count = map.get(rs) == null ? 0 : map.get(rs);
            map.put(rs, count + 1);
        }

        System.out.println(map);
    }
}
