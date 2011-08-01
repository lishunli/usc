package org.usc.demo.observer;

import java.util.Observable;

public class WeiboPublisher extends Observable {

    private String weiboName;

    public String getWeiboName() {
        return weiboName;
    }

    public WeiboPublisher(String weiboName) {
        this.weiboName = weiboName;
    }

    public void publish() {
        setChanged();
        notifyObservers(this);
    }

}
