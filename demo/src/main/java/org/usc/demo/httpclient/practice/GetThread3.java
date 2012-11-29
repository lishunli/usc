package org.usc.demo.httpclient.practice;

import org.usc.demo.httpclient.HttpUtil;

/**
 * 带URL的简单get thread
 *
 * @author Shunli
 */
public class GetThread3 extends Thread {
    private String url;

    public GetThread3(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " working");
        HttpUtil.httpGet(url);
    }
}
