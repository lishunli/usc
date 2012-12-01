package org.usc.demo.httpclient.practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.usc.demo.httpclient.HttpUtil;
import org.usc.demo.ocr.OCR;

/**
 *
 * @author Shunli
 */
public class Vote2 {

    public static void main(String[] args) throws Exception {
        DefaultHttpClient httpclient = HttpUtil.getHttpclient();

        HttpGet httpget = new HttpGet("http://newgame.17173.com/hao/validateCode.php");
        byte[] image = null;
        try {
            HttpResponse response = httpclient.execute(httpget);

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                image = IOUtils.toByteArray(entity.getContent());
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpget.releaseConnection();
        }

        String verifyCode = OCR.read(image);
        System.out.println(verifyCode);

        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("GameId", "1147"));
        formparams.add(new BasicNameValuePair("doStr", "vote"));
        formparams.add(new BasicNameValuePair("code", verifyCode));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");

        HttpPost httppost = new HttpPost("http://newgame.17173.com/hao/vote2011.php");
        httppost.setEntity(entity);
        httppost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.20 (KHTML, like Gecko) Chrome/25.0.1337.0 Safari/537.20");
        httppost.setHeader("Origin", "http://newgame.17173.com");
        httppost.setHeader("Referer", "http://newgame.17173.com/_rustyh/vote.shtml");
        // httppost.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost("178.18.17.250", 8080));

        HttpUtil.http(httppost, new HttpHost("178.18.17.250", 8080));

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
}
