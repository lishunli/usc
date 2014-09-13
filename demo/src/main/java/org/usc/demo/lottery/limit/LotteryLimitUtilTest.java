package org.usc.demo.lottery.limit;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shunli
 */
public class LotteryLimitUtilTest {

    public static void main(String[] args) {
        List<LotteryLimitGift> gifts = new ArrayList<LotteryLimitGift>();
        // 序号==物品Id==物品名称==概率
        gifts.add(new LotteryLimitGift(1, "P1", "物品1", 1, 1));
        gifts.add(new LotteryLimitGift(2, "P2", "物品2", 2, 2));
        gifts.add(new LotteryLimitGift(3, "P3", "物品3", 3d, 3));
        gifts.add(new LotteryLimitGift(4, "P4", "物品4", 4d, 4));

        LotteryLimitGift lotteryLimitGift = new LotteryLimitGift(1, "P1", "物品1", 1, 10);
        System.out.println(lotteryLimitGift.hashCode());

        lotteryLimitGift.setLimit(1);
        System.out.println(lotteryLimitGift.hashCode());

        // for (LotteryLimitGift lotteryLimitGift : gifts) {
        // System.out.println(lotteryLimitGift.hashCode());
        // System.out.println(gifts.hashCode());
        // lotteryLimitGift.setLimit(1);
        // System.out.println(lotteryLimitGift.hashCode());
        // System.out.println(gifts.hashCode());
        // }

        // Multiset<LotteryLimitGift> resultSet = HashMultiset.create();
        // double count = 100;
        // for (int i = 0; i < count; i++) {
        // // LotteryLimitGift lottery = LotteryLimitUtil.lottery(gifts);
        // // if (lottery == null) {
        // // continue;
        // // }
        // //
        // // int limit = lottery.getLimit();
        // // if (limit <= 1) {
        // // gifts.remove(lottery);
        // // } else {
        // // lottery.setLimit(limit - 1);
        // // }
        //
        //
        // resultSet.add(LotteryUtil.lottery(gifts));
        // }
        //
        // // System.out.println(resultSet);
        //
        // Set<Entry<LotteryLimitGift>> entrySet = resultSet.entrySet();
        // for (Entry<LotteryLimitGift> entry : entrySet) {
        // System.out.println(entry);
        // System.out.println(entry.getElement() + ":" + entry.getCount() / count);
        // }
        //
        // // Stopwatch stopwatch = Stopwatch.createStarted();
        // // for (int i = 0; i < count; i++) {
        // // LotteryLimitUtil.lottery(gifts);
        // // }
        // // System.out.println(stopwatch);
    }

}
