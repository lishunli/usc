package org.usc.demo.httpclient.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        int threadSize = 20;
        List<List<String>> doSubList = ListUtil.doSubList(ProxyUtil.getProxyUrls(), threadSize);
        ExecutorService exec = Executors.newFixedThreadPool(threadSize);

        for (List<String> proxyUrls : doSubList) {
            exec.execute(new GetThread(proxyUrls));
        }
        exec.shutdown();

        // HttpUtil.http(httppost);

        // HttpResponse response = null;
        // try {
        // response = httpclient.execute(httppost);
        //
        // if (response != null) {
        // System.out.println(response.getStatusLine());
        // System.out.println(EntityUtils.toString(response.getEntity()));
        // }
        // } catch (ClientProtocolException e) {
        // e.printStackTrace();
        // } catch (IOException e) {
        // e.printStackTrace();
        // } finally {
        // httppost.releaseConnection();
        // }

    }

    static class GetThread extends Thread {
        private List<String> proxyUrls;

        public GetThread(List<String> proxyUrls) {
            this.proxyUrls = proxyUrls;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " working");
            for (String line : proxyUrls) {
                String[] split = line.split("\t")[0].split(":");
                String hostname = split[0];
                int port = Integer.parseInt(split[1]);

                // System.out.println(hostname + ":" + port + ".");

                try {
                    DefaultHttpClient httpclient = new DefaultHttpClient();
                    httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);

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
                            System.out.println(httppost.getParams().getParameter(ConnRoutePNames.DEFAULT_PROXY));
                            System.out.println(EntityUtils.toString(response.getEntity(), "gbk"));
                        }

                    }

                } catch (Exception e) {
                     e.printStackTrace();
                }
            }
        }
    }
}
