package org.usc.demo.lottery;

import java.util.List;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import com.xunlei.youxi.act.frm.vo.LotteryGift;

/**
 *
 * @author Shunli
 */
public class LotteryUtilWithGuavaAndCache {
    private static final LoadingCache<List<LotteryGift>, LotteryGiftGenerator> cache = CacheBuilder.newBuilder().build(
            new CacheLoader<List<LotteryGift>, LotteryGiftGenerator>() {
                @Override
                public LotteryGiftGenerator load(List<LotteryGift> gifts) throws Exception {
                    RangeMap<Double, LotteryGift> rangeMap = TreeRangeMap.create();

                    double sumRate = 0d;
                    for (LotteryGift lotteryGift : gifts) {
                        double probability = lotteryGift.getProbability();
                        if (probability > 0) {
                            rangeMap.put(Range.atLeast(sumRate), lotteryGift);
                            sumRate += probability;
                        }
                    }

                    return new LotteryGiftGenerator(sumRate, rangeMap);
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
    public static LotteryGift lottery(List<LotteryGift> gifts) {
        if (gifts == null || gifts.isEmpty()) {
            return null;
        }

        return cache.getUnchecked(gifts).randomLotteryGift();
    }
}

class LotteryGiftGenerator {
    private double sumRate;
    private RangeMap<Double, LotteryGift> rangemap;

    public LotteryGiftGenerator(double sumRate, RangeMap<Double, LotteryGift> rangemap) {
        this.sumRate = sumRate;
        this.rangemap = rangemap;
    }

    public LotteryGift randomLotteryGift() {
        return rangemap.get(Math.random() * sumRate);
    }
}
