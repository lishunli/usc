package org.usc.demo.observer;


public class WeiboPublisher extends AbstractPublisher {
    private String weiboName;

    public String getWeiboName() {
        return weiboName;
    }

    public WeiboPublisher(String weiboName) {
        this.weiboName = weiboName;
    }
}
