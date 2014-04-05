package org.usc.demo.lottery;

public class LotteryGift2 {
    private int index;
    private String giftId;
    private String giftName;
    private int probability;

    public LotteryGift2(int index, String giftId, String giftName, int probability) {
        this.index = index;
        this.giftId = giftId;
        this.giftName = giftName;
        this.probability = probability;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getGiftId() {
        return giftId;
    }

    public void setGiftId(String giftId) {
        this.giftId = giftId;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    @Override
    public String toString() {
        return "LotteryGift [index=" + index + ", gitfId=" + giftId + ", giftName=" + giftName + ", probability=" + probability + "]";
    }
}
