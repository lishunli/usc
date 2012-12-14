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
            readLines = FileUtils.readLines(new File("D:\\小米\\小米网盘\\proxy3.txt"), "UTF-8");
            // readLines = FileUtils.readLines(new File("D:\\小米\\小米网盘\\proxylist-base4-1.txt"), "UTF-8");
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return readLines;
    }
}
