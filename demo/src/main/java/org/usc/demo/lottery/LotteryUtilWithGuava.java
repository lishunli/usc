package org.usc.demo.lottery;

import java.util.List;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import com.xunlei.youxi.act.frm.vo.LotteryGift;

/**
 *
 * @author Shunli
 */
public class LotteryUtilWithGuava {
    /**
     * 根据不同的概率随机抽奖
     *
     * @param gifts
     *            抽奖礼物列表
     * @return
     *         中奖的礼物
     */
    public static LotteryGift lottery(List<LotteryGift> gifts) {
        if (gifts == null || gifts.isEmpty()) {
            return null;
        }

        RangeMap<Double, LotteryGift> rangeMap = TreeRangeMap.create();
        double sumRate = 0d;
        for (LotteryGift lotteryGift : gifts) {
            double probability = lotteryGift.getProbability();
            if (probability > 0) {
                rangeMap.put(Range.atLeast(sumRate), lotteryGift);
                sumRate += probability;
            }
        }

        return rangeMap.get(Math.random() * sumRate);
    }
}
