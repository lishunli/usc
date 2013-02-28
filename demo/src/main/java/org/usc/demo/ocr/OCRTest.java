package org.usc.demo.ocr;

import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;

public class OCRTest {

    /**
     * @param args
     * @throws Exceptionr
     */
    public static void main(String[] args) throws Exception {
        String url = "http://dynamic.12306.cn/otsweb/passCodeAction.do?rand=sjrand";
        // String url = "http://newgame.17173.com/hao/validateCode.php";
        // String url = "https://omeo.alipay.com/service/checkcode?sessionID=b0d2492bbb0831697bbaf52731798cd8&r=0.9015433858148754";
        // String url = "http://verify2.xunlei.com/image?t=MEA";
        byte[] image = getVerifyCodeImage(url);
        String verifyCode = OCR.read(image);
        System.out.println(verifyCode);

    }

    private static byte[] getVerifyCodeImage(String url) throws Exception {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 2000);
        httpclient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 2000);

        HttpGet httpget = new HttpGet(url);
        byte[] rtn = null;
        try {
            HttpResponse response = httpclient.execute(httpget);

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                rtn = IOUtils.toByteArray(entity.getContent());
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpget.releaseConnection();
        }

        List<Cookie> cookies = httpclient.getCookieStore().getCookies();
        System.out.println(cookies/* .get(0).getValue() */);
        return rtn;
    }
}
