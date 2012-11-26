package org.usc.demo.httpclient;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Shunli
 */
public class ProxyTest1 {

    public static void main(String[] args) {
        testProxy();
    }

    private static void testProxy() {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);

        List<String> readLines = new ArrayList<String>();
        try {
            readLines = FileUtils.readLines(new File("D:\\小米\\小米网盘\\proxy.txt"), "UTF-8");
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        HttpGet httpget = new HttpGet("http://www.baidu.com");
        httpget.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 2000);

        for (String line : readLines) {
            String[] split = line.split(":");
            String hostname = split[0];
            int port = Integer.parseInt(split[1]);

            // HttpHost proxy = new HttpHost("61.30.127.2", 80);
            HttpHost proxy = new HttpHost(hostname, port);
            httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);

            try {
                HttpResponse execute = httpclient.execute(httpget);
                System.out.println(EntityUtils.toString(execute.getEntity()));
                System.out.println(hostname + ":" + port + " test ok.");
            } catch (Exception e) {
                // e.printStackTrace();
                System.out.println(hostname + ":" + port + " test failed.");
            } finally {
                httpget.releaseConnection();
            }
        }

    }

}
