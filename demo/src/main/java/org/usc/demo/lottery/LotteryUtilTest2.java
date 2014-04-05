package org.usc.demo.lottery;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset.Entry;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

/**
 *
 * @author ShunLi
 */
public class LotteryUtilTest2 {
    private static final Random random = new Random();

    public static void main(String[] args) {
        List<LotteryGift2> gifts = new ArrayList<LotteryGift2>();
        // 序号==物品Id==物品名称==概率
        gifts.add(new LotteryGift2(1, "P1", "物品1", 20));
        gifts.add(new LotteryGift2(2, "P2", "物品2", 10));
        gifts.add(new LotteryGift2(3, "P3", "物品3", 40));
        gifts.add(new LotteryGift2(4, "P4", "物品4", 30));
        // gifts.add(new LotteryGift2(5, "P5", "物品5", 50));

        RangeMap<Integer, LotteryGift2> rangeMap = TreeRangeMap.create();
        int sumRate = 0;
        for (LotteryGift2 lotteryGift : gifts) {
            rangeMap.put(Range.atLeast(sumRate), lotteryGift);
            sumRate += lotteryGift.getProbability();
        }

        System.out.println(rangeMap);

        int nextInt = random.nextInt(sumRate);
        System.out.println(nextInt);
        System.out.println(rangeMap.get(nextInt));

        Multiset<LotteryGift2> resultSet = HashMultiset.create();
        double count = 10000000;
        for (int i = 0; i < count; i++) {
            resultSet.add(rangeMap.get(random.nextInt(sumRate)));
        }

        System.out.println(resultSet);

        Set<Entry<LotteryGift2>> entrySet = resultSet.entrySet();
        for (Entry<LotteryGift2> entry : entrySet) {
            System.out.println(entry.getElement() + ":" + entry.getCount() / count);
        }
    }
}
