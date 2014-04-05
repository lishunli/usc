package org.usc.demo.lottery;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.google.common.base.Stopwatch;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset.Entry;
import com.xunlei.youxi.act.frm.vo.LotteryGift;

/**
 *
 * @author Shunli
 */
public class LotteryUtilWithGuavaTest {

    public static void main(String[] args) {
        List<LotteryGift> gifts = new ArrayList<LotteryGift>();
        // 序号==物品Id==物品名称==概率
        gifts.add(new LotteryGift(1, "P1", "物品1", 0.2d));
        gifts.add(new LotteryGift(2, "P2", "物品2", 0.1d));
        gifts.add(new LotteryGift(3, "P3", "物品3", 0.4d));
        gifts.add(new LotteryGift(41, "P41", "物品41", 0.3d));
        gifts.add(new LotteryGift(42, "P42", "物品42", 0.3d));
        gifts.add(new LotteryGift(5, "P5", "物品5", -0.5d));
        gifts.add(new LotteryGift(6, "P6", "物品6", 0d));

        Multiset<LotteryGift> resultSet = HashMultiset.create();
        double count = 10000000;
        for (int i = 0; i < count; i++) {
            resultSet.add(LotteryUtilWithGuava.lottery(gifts));
        }

        System.out.println(resultSet);

        Set<Entry<LotteryGift>> entrySet = resultSet.entrySet();
        for (Entry<LotteryGift> entry : entrySet) {
            System.out.println(entry.getElement() + ":" + entry.getCount() / count);
        }

        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < count; i++) {
            LotteryUtilWithGuava.lottery(gifts);
        }
        System.out.println(stopwatch);
    }

}
