package org.usc.demo.httpclient.practice;

import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpGet;
import org.usc.demo.httpclient.HttpUtil;

/**
 * 带URL有代理的get thread
 *
 * @author Shunli
 */
public class GetThread1 extends Thread {
    private String url;
    private List<String> proxyUrls;

    public GetThread1(String url, List<String> proxyUrls) {
        this.url = url;
        this.proxyUrls = proxyUrls;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " working");
        for (String line : proxyUrls) {
            String[] split = line.split("\t")[0].split(":");
            String hostname = split[0];
            int port = Integer.parseInt(split[1]);

            HttpGet httpget = new HttpGet(url);
            HttpUtil.http(httpget, new HttpHost(hostname, port));
        }
    }
}
