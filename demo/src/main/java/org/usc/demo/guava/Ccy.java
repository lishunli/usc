package org.usc.demo.guava;


public class Ccy extends CcyKey {
    private int money;

    public Ccy() {
        super();
    }

    public Ccy(String id, String name, int money) {
        super(id, name);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
