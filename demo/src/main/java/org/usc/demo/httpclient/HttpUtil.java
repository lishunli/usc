package org.usc.demo.httpclient;

import java.net.URI;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
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

/**
 *
 * @author Shunli
 */
public class HttpUtil {
    private final static int MAX_TOTAL_CONNECTIONS = 200 * 1000; // 最大连接数
    private final static int MAX_ROUTE_CONNECTIONS = 20 * 10000; // 每个路由最大连接数
    private final static int CONNECT_TIMEOUT = 10000; // 连接超时时间
    private final static int READ_TIMEOUT = 30000; // 读取超时时间

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

    public static DefaultHttpClient getHttpclient() {
        return httpclient;
    }

    public static void httpGet(String url) {
        HttpGet httpget = new HttpGet(url);
        http(httpget);
    }

    public static void httpGet(URI uri) {
        HttpGet httpget = new HttpGet(uri);
        http(httpget);
    }

    public static void httpGet(String url, HttpHost proxyHost) {
        HttpGet httpget = new HttpGet(url);
        http(httpget, proxyHost);
    }

    public static void httpGet(URI uri, HttpHost proxyHost) {
        HttpGet httpget = new HttpGet(uri);
        http(httpget, proxyHost);
    }

    // public static void httpPost(String url) {
    // HttpPost httppost = new HttpPost(url);
    // http(httppost);
    // }
    //
    // public static void httpPost(URI uri) {
    // HttpPost httppost = new HttpPost(uri);
    // http(httppost);
    // }
    //
    // public static void httpPost(String url, HttpHost proxyHost) {
    // HttpPost httppost = new HttpPost(url);
    // http(httppost, proxyHost);
    // }
    //
    // public static void httpPost(URI uri, HttpHost proxyHost) {
    // HttpPost httppost = new HttpPost(uri);
    // http(httppost, proxyHost);
    // }

    public static void http(HttpRequestBase httpRequest) {
        httpRequest.getParams().removeParameter(ConnRoutePNames.DEFAULT_PROXY);

        HttpResponse response = null;
        try {
            response = httpclient.execute(httpRequest);

            if (response != null) {
                System.out.println(response.getStatusLine().getStatusCode());
                System.out.println(EntityUtils.toString(response.getEntity()));
            }
        } catch (Exception e) {
            e.printStackTrace();
            httpRequest.abort();
        } finally {
            // System.out.println("release");
            httpRequest.releaseConnection();
        }
    }

    public static void http(HttpRequestBase httpRequest, HttpHost proxyHost) {
        httpRequest.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxyHost);
        HttpResponse response = null;
        try {
            response = httpclient.execute(httpRequest);

            if (response != null) {
                int statusCode = response.getStatusLine().getStatusCode();

                if (statusCode == HttpStatus.SC_OK) {
                    System.out.println(httpRequest.getParams().getParameter(ConnRoutePNames.DEFAULT_PROXY));
                    System.out.println(EntityUtils.toString(response.getEntity()));
                }

            }
        } catch (Exception e) {
            httpRequest.abort();
        } finally {
            httpRequest.releaseConnection();
        }
    }
}
