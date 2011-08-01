package org.usc.demo.observer;

import java.util.Observable;
import java.util.Observer;

public class Reader implements Observer {

    public void update(Observable o, Object arg) {
        if (o instanceof WeiboPublisher) {
            WeiboPublisher weibo = (WeiboPublisher) o;
            System.out.println("I want to follow " + weibo.getWeiboName() + "'s weibo");
        } else if (o instanceof BlogJavaPublisher) {
            BlogJavaPublisher blogJava = (BlogJavaPublisher) o;
            System.out.println("I want to subscribe " + blogJava.getBlogJavaName() + "'s blog");
        }
    }

}
