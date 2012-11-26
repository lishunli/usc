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

            String timeStamp = System.currentTimeMillis() + "";
            HttpGet httpget = new HttpGet("http://hits.17173.com/mood/moodOpa.php?channel=10009&web_id=3109360&kind=1&action=1&mood=3&r=" + timeStamp + "&ajajId=ajaj1");
            HttpUtil.httpGet(httpget, new HttpHost(hostname, port));
        }
    }
}
