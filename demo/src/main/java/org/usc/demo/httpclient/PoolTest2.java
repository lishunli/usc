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
import org.apache.http.params.CoreConnectionPNames;
import org.usc.demo.util.ListUtil;

/**
 *
 * @author Shunli
 */
public class PoolTest2 {
    private static final int THREAD_SIZE = 100;

    public static void main(String[] args) throws InterruptedException {
        HttpClient httpClient = HttpConnectionManager.getHttpClient();

        List<String> readLines = new ArrayList<String>();
        try {
            readLines = FileUtils.readLines(new File("C:\\Users\\Shunli\\Desktop\\proxy.txt"), "UTF-8");
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        ExecutorService exec = Executors.newFixedThreadPool(THREAD_SIZE);

        List<List<String>> doSubList = ListUtil.doSubList(readLines, THREAD_SIZE);
        for (List<String> proxyUrls : doSubList) {
            // create a thread for each URI
            HttpGet httpget = new HttpGet("http://localhost/");
            httpget.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 2000);
            exec.execute(new GetThread1(httpClient, httpget, proxyUrls));
        }

        exec.shutdown();
    }
}
