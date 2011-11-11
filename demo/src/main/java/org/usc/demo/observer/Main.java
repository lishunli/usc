package org.usc.demo.observer;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        AbstractPublisher weiboPublisher = new WeiboPublisher("李顺利的新浪微博");
        weiboPublisher.addObservers(Arrays.asList(new Reader("李开复"), new Reader("雷军"), new Reader("小米")));

        weiboPublisher.publish(args);

        AbstractPublisher blogJavaBlogPublisher = new BlogPublisher("李顺利的BlogJava博客");
        blogJavaBlogPublisher.addObservers(Arrays.asList(new Reader("robbin"), new Reader("蒋涛"), new Reader("myFuns")));

        blogJavaBlogPublisher.publish();

        AbstractPublisher sinaBlogPublisher = new BlogPublisher("李顺利的新浪博客");
        sinaBlogPublisher.addObservers(Arrays.asList(new Reader("robbin"), new Reader("蒋涛"), new Reader("myFuns")));

        sinaBlogPublisher.publish();
    }

}
