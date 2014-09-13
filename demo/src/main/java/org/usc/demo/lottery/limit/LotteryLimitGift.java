package org.usc.demo.lottery.limit;

import org.usc.demo.lottery.LotteryGift;

/**
 *
 * @author Shunli
 */
public class LotteryLimitGift extends LotteryGift {
    private int limit;

    public LotteryLimitGift(int index, String giftId, String giftName, double probability, int limit) {
        super(index, giftId, giftName, probability);
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

}
