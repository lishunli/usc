package org.usc.demo.guava;

public class Currency implements Cloneable, Comparable<Currency> {
    private String userId;
    private int qty;

    public Currency() {
    }

    public Currency(String userId, int qty) {
        this.userId = userId;
        this.qty = qty;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Currency [userId=" + userId + ", qty=" + qty + "]";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int compareTo(Currency dest) {
        return dest.getQty() - this.qty;
    }

}
