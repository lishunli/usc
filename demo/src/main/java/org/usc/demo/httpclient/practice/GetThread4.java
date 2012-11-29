package org.usc.demo.httpclient.practice;

import java.net.URI;

import org.usc.demo.httpclient.HttpUtil;

/**
 * 带URI的简单get thread
 *
 * @author Shunli
 */
public class GetThread4 extends Thread {
    private URI uri;

    public GetThread4(URI uri) {
        this.uri = uri;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " working");
        HttpUtil.httpGet(uri);
    }
}
