package org.usc.demo.lottery.limit;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import com.xunlei.youxi.core.log.LoggerFactory;
import com.xunlei.youxi.core.util.FileUtil;

/**
 * 不同概率抽奖工具包
 *
 * @author Shunli
 */
public class LotteryUtil {
    private static Logger log = LoggerFactory.getLogger(LotteryUtil.class);

    private static class LotteryLimitGiftGenerator {
        private double sumRate;
        private RangeMap<Double, LotteryLimitGift> rangemap;

        public LotteryLimitGiftGenerator(double sumRate, RangeMap<Double, LotteryLimitGift> rangemap) {
            this.sumRate = sumRate;
            this.rangemap = rangemap;
        }

        public LotteryLimitGift randomLotteryLimitGift() {
            return rangemap.get(Math.random() * sumRate);
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
        }
    }

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

                    LotteryLimitGiftGenerator lotteryLimitGiftGenerator = new LotteryLimitGiftGenerator(sumRate, rangeMap);
                    log.info("load-lottery-gifts-range:{}", lotteryLimitGiftGenerator);
                    return lotteryLimitGiftGenerator;
                }
            });

    private static final LoadingCache<String, List<LotteryLimitGift>> giftCache = CacheBuilder.newBuilder().build(
            new CacheLoader<String, List<LotteryLimitGift>>() {
                @Override
                public List<LotteryLimitGift> load(String lotteryLimitGiftsFileName) throws Exception {
                    List<LotteryLimitGift> lotteryLimitGifts = new ArrayList<LotteryLimitGift>();
                    for (String line : FileUtil.readLinesFromResource(lotteryLimitGiftsFileName)) {
                        String[] content = StringUtils.split(line, "==");
                        if (content == null || content.length < 5) {
                            continue;
                        }

                        double probability = NumberUtils.toDouble(content[2]);
                        int limit = NumberUtils.toInt(content[3]);
                        // TODO-Shunli: must limit - count from db already exists
                        // TODO-Shunli: and will refresh at zero per day.
                        if (probability <= 0 || limit <= 0) {
                            continue;
                        }

                        int index = NumberUtils.toInt(content[0]);
                        String giftName = content[1];
                        String giftId = content[4];
                        lotteryLimitGifts.add(new LotteryLimitGift(index, giftId, giftName, probability, limit));
                    }

                    log.info("load-lottery-gifts:{},{}", lotteryLimitGiftsFileName, lotteryLimitGifts);
                    return lotteryLimitGifts;
                }
            });

    /**
     * 根据给定的抽奖礼包文件进行抽奖，<br>
     * 其中文件中每行表示一个抽奖的礼包，格式e.g. 礼包对应页面上面的索引==礼包名称==概率==礼包id
     *
     * @param lotteryLimitGiftsFileName
     *            抽奖礼包文件
     * @return
     */
    public static LotteryLimitGift lottery(String lotteryLimitGiftsFileName) {
        try {
            return lottery(giftCache.get(lotteryLimitGiftsFileName));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 根据不同的概率随机抽奖
     *
     * @param gifts
     *            抽奖礼物列表
     * @return
     *         中奖的礼物
     */
    public synchronized static LotteryLimitGift lottery(List<LotteryLimitGift> gifts) {
        if (gifts == null || gifts.isEmpty()) {
            return null;
        }

        try {
            LotteryLimitGift lottery = cache.get(gifts).randomLotteryLimitGift();
            int limit = lottery.getLimit();
            if (limit <= 1) {
                // 达到限量后去掉此礼包的抽奖
                gifts.remove(lottery);
            } else {
                // 没有达到限量，限量-1
                lottery.setLimit(limit - 1);
            }

            return lottery;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 刷新抽奖礼包的列表
     *
     * @param lotteryLimitGiftsFileName
     *            抽奖礼包文件
     */
    public static void refreshGiftCache(String lotteryLimitGiftsFileName) {
        if (StringUtils.isNotEmpty(lotteryLimitGiftsFileName)) {
            giftCache.refresh(lotteryLimitGiftsFileName);
        } else {
            giftCache.invalidateAll();
        }
    }
}
