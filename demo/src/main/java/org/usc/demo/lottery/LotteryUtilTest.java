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
import com.xunlei.youxi.act.frm.vo.LotteryGift;

/**
 *
 * @author ShunLi
 */
public class LotteryUtilTest {
    private static final Random random = new Random();

    public static void main(String[] args) {
        List<LotteryGift> gifts = new ArrayList<LotteryGift>();
        // 序号==物品Id==物品名称==概率
        gifts.add(new LotteryGift(1, "P1", "物品1", 0.2d));
        gifts.add(new LotteryGift(2, "P2", "物品2", 0.1d));
        gifts.add(new LotteryGift(3, "P3", "物品3", 0.4d));
        gifts.add(new LotteryGift(4, "P4", "物品4", 0.3d));
        gifts.add(new LotteryGift(5, "P5", "物品5", -0.5d));
        gifts.add(new LotteryGift(6, "P6", "物品6", 0d));

        RangeMap<Double, LotteryGift> rangeMap = TreeRangeMap.create();
        double sumRate = 0d;
        for (LotteryGift lotteryGift : gifts) {
            double probability = lotteryGift.getProbability();
            if (probability > 0) {
                rangeMap.put(Range.atLeast(sumRate), lotteryGift);
                sumRate += probability;
            }
        }

        System.out.println(rangeMap);

        double nextDouble = random.nextDouble() * sumRate;
        System.out.println(nextDouble);
        System.out.println(rangeMap.get(nextDouble));
        System.out.println(rangeMap.get(Math.random() * sumRate));

        Multiset<LotteryGift> resultSet = HashMultiset.create();
        double count = 100000;
        for (int i = 0; i < count; i++) {
            resultSet.add(rangeMap.get(random.nextDouble() * sumRate));
        }

        System.out.println(resultSet);

        Set<Entry<LotteryGift>> entrySet = resultSet.entrySet();
        for (Entry<LotteryGift> entry : entrySet) {
            System.out.println(entry.getElement() + ":" + entry.getCount() / count);
        }
    }
}
