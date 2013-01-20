package org.usc.demo.httpclient.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.usc.demo.httpclient.ProxyUtil;
import org.usc.demo.util.ListUtil;

/**
 *
 * @author Shunli
 */
public class Vote3 {

    public static void main(String[] args) throws Exception {
        int threadSize = 30;
        int times = 5;
        List<String> proxyList = new ArrayList<String>();
        for (int i = 0; i < times; i++) {
            proxyList.addAll(ProxyUtil.getProxyUrls());
        }

        List<List<String>> doSubList = ListUtil.doSubList(proxyList, threadSize);
        ExecutorService exec = Executors.newFixedThreadPool(threadSize);

        AtomicInteger handleCount = new AtomicInteger();
        AtomicInteger successCount = new AtomicInteger();
        List<String> successProxys = new CopyOnWriteArrayList<String>();
        for (List<String> proxyUrls : doSubList) {
            exec.execute(new GetThread(proxyUrls, handleCount, successCount, successProxys));
        }
        exec.shutdown();

        // better use CountDownLatch
        if (exec.awaitTermination(1, TimeUnit.HOURS)) {
            System.out.println("【结果】handle " + handleCount.get() + ", success handle " + successCount.get() + ", success proxy " + successProxys.size());

            // File file = new File("D:\\网盘\\小米网盘\\代理IP\\success_proxy.txt");
            //
            // List<String> alreadySuccessList = FileUtils.readLines(file);
            // successProxys.addAll(alreadySuccessList); // combine
            //
            // Set<String> removeDuplicated = new TreeSet<String>(successProxys);// remove duplicated elements
            // FileUtils.writeLines(file, removeDuplicated);
            //
            // // System.out.println(successProxys);
        }

    }

    private final static int MAX_TOTAL_CONNECTIONS = 600; // 最大连接数
    private final static int MAX_ROUTE_CONNECTIONS = 100; // 每个路由最大连接数
    private final static int CONNECT_TIMEOUT = 60000; // 连接超时时间
    private final static int READ_TIMEOUT = 120000; // 读取超时时间

    private static DefaultHttpClient httpclient;

    static {
        HttpParams httpParams = new BasicHttpParams();
        httpParams.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, CONNECT_TIMEOUT);
        httpParams.setParameter(CoreConnectionPNames.SO_TIMEOUT, READ_TIMEOUT);
        httpParams.setParameter(CoreProtocolPNames.HTTP_CONTENT_CHARSET, "UTF-8");

        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
        schemeRegistry.register(new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));

        PoolingClientConnectionManager cm = new PoolingClientConnectionManager(schemeRegistry);
        cm.setMaxTotal(MAX_TOTAL_CONNECTIONS);
        cm.setDefaultMaxPerRoute(MAX_ROUTE_CONNECTIONS);

        httpclient = new DefaultHttpClient(cm);
        httpclient.setParams(httpParams);

    }

    static class GetThread extends Thread {
        private List<String> proxyUrls;
        private AtomicInteger handleCount;
        private AtomicInteger successCount;
        private List<String> successProxys;

        public GetThread(List<String> proxyUrls, AtomicInteger handleCount, AtomicInteger successCount, List<String> successProxys) {
            this.proxyUrls = proxyUrls;
            this.handleCount = handleCount;
            this.successCount = successCount;
            this.successProxys = successProxys;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " working");
            for (String line : proxyUrls) {
                System.out.println("[Vote3]now handle " + handleCount.incrementAndGet() + "," + successCount + "," + successProxys.size());
                // String[] split = line.split(":");
                // String[] split = line.split(" ");
                // String[] split = line.split("\t");
                String[] split = line.split("\t")[0].split(":");
                String hostname = split[0];
                int port = Integer.parseInt(split[1]);

                // HttpUtil.httpGet(url, new HttpHost(hostname, port));
                vote(hostname, port);
            }
        }

        private void vote(String hostname, int port) {
            String url = "http://china.17173.com/2012/join.php?do=GameVote&A2=10673&A1=11649&A3=253&A4=0&A5";
            HttpGet httpRequest = new HttpGet(url);
            httpRequest.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(hostname, port));
            HttpResponse response = null;
            try {
                response = httpclient.execute(httpRequest);

                if (response != null) {
                    int statusCode = response.getStatusLine().getStatusCode();

                    if (statusCode == HttpStatus.SC_OK) {
                        successProxys.add(hostname + ":" + port);
                        String result = EntityUtils.toString(response.getEntity());

                        String flag = new JSONObject(result).getString("flag");
                        // System.out.println(result);
                        if ("1".equals(flag)) {
                            successCount.incrementAndGet();
                            // continue
                            // vote(hostname, port);
                        } else if ("0".equals(flag)) {
                            // already vote
                        } else {
                            System.out.println(result);
                        }
                    }
                }
            } catch (Exception e) {
                httpRequest.abort();
            } finally {
                httpRequest.releaseConnection();
            }
        }
    }
}
