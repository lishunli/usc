package org.usc.demo.httpclient;

import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpGet;

public class GetThread2 extends Thread {
    private final HttpGet httpget;
    private List<String> proxyUrls;

    public GetThread2(HttpGet httpget, List<String> proxyUrls) {
        this.httpget = httpget;
        this.proxyUrls = proxyUrls;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " working");
        for (String line : proxyUrls) {
            String[] split = line.split("\t")[0].split(":");
            String hostname = split[0];
            int port = Integer.parseInt(split[1]);

            HttpUtil.http(httpget, new HttpHost(hostname, port));
        }
    }
}
