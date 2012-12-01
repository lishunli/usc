package org.usc.demo.httpclient.practice;

import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpGet;
import org.usc.demo.httpclient.HttpUtil;

/**
 * 带时间戳URL有代理的get thread
 *
 * @author Shunli
 */
public class GetThread2 extends Thread {
    private String urlFormat;
    private List<String> proxyUrls;

    public GetThread2(String urlFormat, List<String> proxyUrls) {
        this.urlFormat = urlFormat;
        this.proxyUrls = proxyUrls;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " working");
        for (String line : proxyUrls) {
            String[] split = line.split("\t")[0].split(":");
            String hostname = split[0];
            int port = Integer.parseInt(split[1]);

            HttpGet httpget = new HttpGet(String.format(urlFormat, System.currentTimeMillis()));
            HttpUtil.http(httpget, new HttpHost(hostname, port));
        }
    }
}
