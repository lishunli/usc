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

/**
 *
 * @author Shunli
 */
public class PoolTest2 {
    private static final int BATCH_SIZE = 10;

    public static void main(String[] args) throws InterruptedException {
        HttpClient httpClient = HttpConnectionManager.getHttpClient();

        List<String> readLines = new ArrayList<String>();
        try {
            readLines = FileUtils.readLines(new File("D:\\小米\\小米网盘\\proxy.txt"), "UTF-8");
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        int size = readLines.size();
        ExecutorService exec = Executors.newFixedThreadPool(size / BATCH_SIZE + 1);
        for (int i = 0; i * BATCH_SIZE < size; i++) {
            int fromIndex = i * BATCH_SIZE;
            int toIndex = size - fromIndex > BATCH_SIZE ? fromIndex + BATCH_SIZE : size;

            List<String> proxyUrls = readLines.subList(fromIndex, toIndex);

            // create a thread for each URI
            HttpGet httpget = new HttpGet("http://localhost/");
            httpget.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 2000);
            exec.execute(new GetThread(httpClient, httpget, proxyUrls));
        }

        exec.shutdown();
    }
}
