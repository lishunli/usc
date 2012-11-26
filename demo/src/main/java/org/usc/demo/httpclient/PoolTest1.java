package org.usc.demo.httpclient;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.CoreConnectionPNames;
import org.usc.demo.util.ListUtil;

/**
 *
 * @author Shunli
 */
public class PoolTest1 {
    private static final int BATCH_SIZE = 10;

    public static void main(String[] args) throws InterruptedException {
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
        ClientConnectionManager cm = new PoolingClientConnectionManager(schemeRegistry);

        HttpClient httpClient = new DefaultHttpClient(cm);
        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);

        List<String> readLines = new ArrayList<String>();
        try {
            readLines = FileUtils.readLines(new File("D:\\小米\\小米网盘\\proxy.txt"), "UTF-8");
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        List<List<String>> doSubList = ListUtil.doSubList(readLines, BATCH_SIZE);
        ExecutorService exec = Executors.newFixedThreadPool(BATCH_SIZE);

        for (List<String> proxyUrls : doSubList) {
            // create a thread for each URI
            HttpGet httpget = new HttpGet("http://www.baidu.com");
            // httpget.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 20000);
            exec.execute(new GetThread1(httpClient, httpget, proxyUrls));
        }

        exec.shutdown();
    }
}
