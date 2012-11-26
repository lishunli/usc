package org.usc.demo.httpclient;

import java.io.IOException;
import java.net.URI;

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

/**
 *
 * @author Shunli
 */
public class HttpUtil {
    private final static int MAX_TOTAL_CONNECTIONS = 200; // 最大连接数
    private final static int MAX_ROUTE_CONNECTIONS = 20; // 每个路由最大连接数
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

    public static void httpGet(URI uri) throws IOException {
        HttpGet httpget = new HttpGet(uri);
        httpget.getParams().removeParameter(ConnRoutePNames.DEFAULT_PROXY);

        HttpResponse response = null;
        try {
            response = httpclient.execute(httpget);

            if (response != null) {
                System.out.println(response.getStatusLine().getStatusCode());
                System.out.println(EntityUtils.toString(response.getEntity()));
            }
        } catch (Exception e) {
            httpget.abort();
        } finally {
            httpget.releaseConnection();
        }
    }

    public static void httpGet(URI uri, HttpHost proxyHost) {
        HttpGet httpget = new HttpGet(uri);
        httpget.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxyHost);
        HttpResponse response = null;
        try {
            response = httpclient.execute(httpget);

            if (response != null) {
                System.out.println(response.getStatusLine().getStatusCode());
                System.out.println(EntityUtils.toString(response.getEntity()));
            }
        } catch (Exception e) {
            httpget.abort();
        } finally {
            httpget.releaseConnection();
        }
    }

    public static void httpGet(HttpGet httpget, HttpHost proxyHost) {
        httpget.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxyHost);
        HttpResponse response = null;
        try {
            response = httpclient.execute(httpget);

            if (response != null) {
                int statusCode = response.getStatusLine().getStatusCode();

                if (statusCode == HttpStatus.SC_OK) {
                    System.out.println(httpget.getParams().getParameter(ConnRoutePNames.DEFAULT_PROXY));
                    System.out.println(EntityUtils.toString(response.getEntity()));
                }

            }
        } catch (Exception e) {
            httpget.abort();
        } finally {
            httpget.releaseConnection();
        }
    }
}
