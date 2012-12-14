package org.usc.demo.httpclient;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 *
 * @author Shunli
 */
public class ProxyUtil {
    public static List<String> getProxyUrls() {
        List<String> readLines = new ArrayList<String>();
        try {
            String filePathPrefix = "D:\\网盘\\小米网盘\\";
            // String filePathPrefix = "D:\\小米网盘\\小米网盘\\";
            readLines = FileUtils.readLines(new File(filePathPrefix + "success_proxy.txt"), "UTF-8");
            // readLines = FileUtils.readLines(new File(filePathPrefix + "proxy3.txt"), "UTF-8");
            // readLines = FileUtils.readLines(new File(filePathPrefix + "proxylist-base4-1.txt"), "UTF-8");
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return readLines;
    }
}
