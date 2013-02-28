package org.usc.demo.httpclient.practice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.usc.demo.httpclient.ProxyUtil;
import org.usc.demo.ocr.OCR;
import org.usc.demo.util.ListUtil;

/**
 *
 * @author Shunli
 */
public class Vote2 {

    public static void main(String[] args) throws Exception {
        int threadSize = 200;
        int times = 1;
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

            File file = new File(ProxyUtil.SHARE_PATH_PREFIX + "success_proxy.txt");

            List<String> alreadySuccessList = FileUtils.readLines(file);
            successProxys.addAll(alreadySuccessList); // combine

            Set<String> removeDuplicated = new TreeSet<String>(successProxys);// remove duplicated elements
            FileUtils.writeLines(file, removeDuplicated);

            // System.out.println(successProxys);
        }

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
                System.out.println("now handle " + handleCount.incrementAndGet() + "," + successCount + "," + successProxys.size());
                // String[] split = line.split(":");
                String[] split = line.split(" ");
                // String[] split = line.split("\t");
                // String[] split = line.split("\t")[0].split(":");
                String hostname = split[0];
                int port = Integer.parseInt(split[1]);

                // System.out.println(hostname + ":" + port + ".");

                vote(hostname, port);
            }
        }

        /**
         * @param hostname
         * @param port
         */
        private void vote(String hostname, int port) {
            try {
                DefaultHttpClient httpclient = new DefaultHttpClient();
                httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 60000);
                httpclient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 120000);

                HttpGet httpget = new HttpGet("http://newgame.17173.com/hao/validateCode.php");
                byte[] image = null;

                HttpResponse response = httpclient.execute(httpget);

                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    image = IOUtils.toByteArray(entity.getContent());
                }

                String verifyCode = OCR.read(image);
                // System.out.println(verifyCode);

                List<NameValuePair> formparams = new ArrayList<NameValuePair>();
                formparams.add(new BasicNameValuePair("GameId", "1147"));
                formparams.add(new BasicNameValuePair("doStr", "vote"));
                formparams.add(new BasicNameValuePair("code", verifyCode));

                HttpPost httppost = new HttpPost("http://newgame.17173.com/hao/vote2011.php");
                httppost.setEntity(new UrlEncodedFormEntity(formparams, "UTF-8"));
                httppost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.20 (KHTML, like Gecko) Chrome/25.0.1337.0 Safari/537.20");
                httppost.setHeader("Origin", "http://newgame.17173.com");
                httppost.setHeader("Referer", "http://newgame.17173.com/_rustyh/vote.shtml");
                httppost.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(hostname, port));

                response = httpclient.execute(httppost);

                if (response != null) {
                    int statusCode = response.getStatusLine().getStatusCode();

                    if (statusCode == HttpStatus.SC_OK) {
                        // System.out.println(httppost.getParams().getParameter(ConnRoutePNames.DEFAULT_PROXY));
                        successProxys.add(hostname + ":" + port);
                        String result = EntityUtils.toString(response.getEntity(), "gbk");

                        // System.out.println(result);
                        if ("投票成功！感谢您宝贵的一票。投票成功！感谢您宝贵的一票。".equals(result)) {
                            successCount.incrementAndGet();
                        } else if ("验证码错误!".equals(result)) {
                            // System.out.println("continue at " + hostname + ":" + port);
                            vote(hostname, port);
                        }
                    }

                }

            } catch (Exception e) {
                // e.printStackTrace();
                System.err.println(e.getMessage());
            }
        }
    }
}
