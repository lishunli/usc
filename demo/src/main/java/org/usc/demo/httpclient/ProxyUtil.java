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
    public final static String SHARE_PATH_PREFIX = "D:\\小米\\小米网盘\\代理IP\\";

    // public final static String SHARE_PATH_PREFIX = "D:\\网盘\\小米网盘\\代理IP\\";
    public static List<String> getProxyUrls() {
        List<String> readLines = new ArrayList<String>();
        try {
            // readLines = FileUtils.readLines(new File(SHARE_PATH_PREFIX + "success_proxy.txt"), "UTF-8");
            readLines = FileUtils.readLines(new File(SHARE_PATH_PREFIX + "proxy6.txt"), "UTF-8");
            // readLines = FileUtils.readLines(new File(SHARE_PATH_PREFIX + "iplist.txt"), "UTF-8");
            // readLines = FileUtils.readLines(new File(SHARE_PATH_PREFIX + "ip2.txt"), "UTF-8");
            // readLines = FileUtils.readLines(new File(SHARE_PATH_PREFIX + "proxy3.txt"), "UTF-8");
            // readLines = FileUtils.readLines(new File(SHARE_PATH_PREFIX + "proxylist-base4-1.txt"), "UTF-8");
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return readLines;
    }
}
