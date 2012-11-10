package org.usc.demo.httpclient;

import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public class GetThread extends Thread {
    private final HttpClient httpClient;
    private final HttpContext context;
    private final HttpGet httpget;
    private List<String> proxyUrls;

    public GetThread(HttpClient httpClient, HttpGet httpget, List<String> proxyUrls) {
        this.context = new BasicHttpContext();

        this.httpClient = httpClient;
        this.httpget = httpget;
        this.proxyUrls = proxyUrls;
    }

    @Override
    public void run() {
        // System.out.println(Thread.currentThread().getName() + " working");
        for (String line : proxyUrls) {
            String[] split = line.split(":");
            String hostname = split[0];
            int port = Integer.parseInt(split[1]);

            HttpHost proxy = new HttpHost(hostname, port);
            httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);

            try {
                this.httpClient.execute(this.httpget, this.context);
                // System.out.println("\"" + hostname + "\" ," + port /* + " test ok." */);
                System.out.println("httpParams.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(\"" + hostname + "\" ," + port + "));"/* + " test ok." */);

            } catch (Exception e) {
                // e.printStackTrace();
                // System.out.println(hostname + ":" + port + " test failed.");
                this.httpget.abort();
            } finally {
                this.httpget.releaseConnection();
            }
        }
    }
}
