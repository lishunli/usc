package org.usc.demo.httpclient;

import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpGet;

public class GetThread3 extends Thread {
    private List<String> proxyUrls;

    public GetThread3(List<String> proxyUrls) {
        this.proxyUrls = proxyUrls;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " working");
        for (String line : proxyUrls) {
            String[] split = line.split("\t")[0].split(":");
            String hostname = split[0];
            int port = Integer.parseInt(split[1]);

            HttpGet httpget = new HttpGet("http://www.baidu.com");
            HttpUtil.http(httpget, new HttpHost(hostname, port));
        }
    }
}
