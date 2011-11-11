package org.usc.demo.observer;

import java.util.Observable;
import java.util.Observer;

public class Reader implements Observer {
    private String readerName;

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public Reader(String readerName) {
        this.readerName = readerName;
    }

    public void update(Observable o, Object arg) {
        System.out.println("params is " + arg);
        if (o instanceof WeiboPublisher) {
            WeiboPublisher weibo = (WeiboPublisher) o;
            System.out.println(this.readerName + " want to follow " + weibo.getWeiboName() + "'s weibo");
        } else if (o instanceof BlogPublisher) {
            BlogPublisher blogJava = (BlogPublisher) o;
            System.out.println(this.readerName + " want to subscribe " + blogJava.getBlogJavaName() + "'s blog");
        }
    }

}
