package org.usc.demo.httpclient;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpHost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;

/**
 *
 * @author Shunli
 */
public class ProxyTest2 {

    public static void main(String[] args) throws Exception {
        testProxy();
    }

    private static void testProxy() throws Exception {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);

        List<String> readLines = new ArrayList<String>();
        try {
            readLines = FileUtils.readLines(new File("D:\\小米\\小米网盘\\proxy.txt"), "UTF-8");
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        URIBuilder uriBuilder = new URIBuilder("http://www.baidu.com");
        URI uri = uriBuilder.build();
        System.out.println(uri);

        for (String line : readLines) {
            String[] split = line.split("\t")[0].split(":");
            String hostname = split[0];
            int port = Integer.parseInt(split[1]);

            // HttpHost proxy = new HttpHost("61.30.127.2", 80);
            HttpHost proxyHost = new HttpHost(hostname, port);

            HttpUtil.httpGet(uri, proxyHost);

        }

    }

}
