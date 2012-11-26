package org.usc.demo.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Shunli
 */
public class HttpGetTest {
    public static void main(String[] args) throws URISyntaxException, ParseException {
        HttpClient httpclient = new DefaultHttpClient();
        httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 2000);

        URIBuilder uriBuilder = new URIBuilder("http://www.baidu.com");
        uriBuilder.addParameter("username", "中文");
        uriBuilder.addParameter("paaword", "303001");
        URI uri = uriBuilder.build();
        System.out.println(uri);

        HttpGet httpget = new HttpGet(uri);
        httpget.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 2000);
        HttpResponse response = null;
        try {
            response = httpclient.execute(httpget);

            if (response != null) {
                System.out.println(response.getStatusLine());
                System.out.println(EntityUtils.toString(response.getEntity()));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpget.releaseConnection();
        }

    }
    // new URIBuilder().setScheme("http")
    // .setHost("act.game.xunlei.com")
    // .setPort(85)
    // .setPath("/xlgame_dcf/dcfplayerregression2");

}
