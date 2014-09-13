package org.usc.demo.lottery.limit;

import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset.Entry;

/**
 *
 * @author Shunli
 */
public class LotteryUtilTest {

    public static void main(String[] args) {
        String lotteryLimitGiftsFileName = "lottery-gifts.txt";

        Multiset<LotteryLimitGift> resultSet = HashMultiset.create();
        double count = 200;
        for (int i = 0; i < count; i++) {
            resultSet.add(LotteryUtil.lottery(lotteryLimitGiftsFileName));
        }

        Set<Entry<LotteryLimitGift>> entrySet = resultSet.entrySet();
        double effectiveCount = count - resultSet.count(null);
        for (Entry<LotteryLimitGift> entry : entrySet) {
            System.out.println(entry + ":" + entry.getCount() / effectiveCount);
        }
    }

}
