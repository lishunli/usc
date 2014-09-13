package org.usc.demo.lottery.limit;

import java.util.List;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

/**
 *
 * @author Shunli
 */
public class LotteryLimitUtil {
    private static final LoadingCache<List<LotteryLimitGift>, LotteryLimitGiftGenerator> cache = CacheBuilder.newBuilder().build(
            new CacheLoader<List<LotteryLimitGift>, LotteryLimitGiftGenerator>() {
                @Override
                public LotteryLimitGiftGenerator load(List<LotteryLimitGift> gifts) throws Exception {
                    RangeMap<Double, LotteryLimitGift> rangeMap = TreeRangeMap.create();

                    double sumRate = 0d;
                    for (LotteryLimitGift lotteryLimitGift : gifts) {
                        double probability = lotteryLimitGift.getProbability();
                        if (probability > 0) {
                            rangeMap.put(Range.atLeast(sumRate), lotteryLimitGift);
                            sumRate += probability;
                        }
                    }

                    return new LotteryLimitGiftGenerator(sumRate, rangeMap);
                }
            });

    /**
     * 根据不同的概率随机抽奖
     *
     * @param gifts
     *            抽奖礼物列表
     * @return
     *         中奖的礼物
     */
    public static LotteryLimitGift lottery(List<LotteryLimitGift> gifts) {
        if (gifts == null || gifts.isEmpty()) {
            return null;
        }

        return cache.getUnchecked(gifts).randomLotteryLimitGift();
    }
}

class LotteryLimitGiftGenerator {
    private double sumRate;
    private RangeMap<Double, LotteryLimitGift> rangemap;

    public LotteryLimitGiftGenerator(double sumRate, RangeMap<Double, LotteryLimitGift> rangemap) {
        this.sumRate = sumRate;
        this.rangemap = rangemap;
    }

    public LotteryLimitGift randomLotteryLimitGift() {
        // double key = Math.random() * sumRate;
        // System.out.println(rangemap);
        // Entry<Range<Double>, LotteryLimitGift> entry = rangemap.getEntry(key);
        // LotteryLimitGift lotteryLimitGift = entry.getValue();
        // int limit = lotteryLimitGift.getLimit();
        // if (limit <= 1) {
        // rangemap.remove(entry.getKey());
        // }
        // return lotteryLimitGift;

        return rangemap.get(Math.random() * sumRate);
    }
}
