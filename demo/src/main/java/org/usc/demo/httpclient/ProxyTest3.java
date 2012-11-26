package org.usc.demo.httpclient;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.io.FileUtils;
import org.usc.demo.util.ListUtil;

/**
 *
 * @author Shunli
 */
public class ProxyTest3 {
    private static final int BATCH_SIZE = 10;

    public static void main(String[] args) throws InterruptedException {
        List<String> readLines = new ArrayList<String>();
        try {
            readLines = FileUtils.readLines(new File("D:\\小米\\小米网盘\\proxy.txt"), "UTF-8");
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        List<List<String>> doSubList = ListUtil.doSubList(readLines, BATCH_SIZE);
        ExecutorService exec = Executors.newFixedThreadPool(BATCH_SIZE);

        for (List<String> proxyUrls : doSubList) {
            exec.execute(new GetThread3(proxyUrls));
        }

        exec.shutdown();
    }
}
