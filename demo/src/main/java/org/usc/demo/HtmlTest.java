package org.usc.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * JAVA抓取网页内容
 *
 * @author sunlightcs 2011-3-29 http://hi.juziku.com/sunlightcs/
 */
public class HtmlTest {

    public static void main(String[] args) throws Exception {
        System.out.println(getURLContent());
    }
    /**
     * 获取网页内容
     */
    private static String getURLContent() throws MalformedURLException, IOException, UnsupportedEncodingException {
        URL urlmy = new URL("http://10.10.32.27:8081/dazu/food2.jsp");

        HttpURLConnection con = (HttpURLConnection) urlmy.openConnection();
        HttpURLConnection.setFollowRedirects(true);
        con.setInstanceFollowRedirects(false);
        con.connect();

        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

        String s = "";

        StringBuffer sb = new StringBuffer();

        while ((s = br.readLine()) != null) {
            sb.append(s + "\r\n");
        }

        return sb.toString();
    }

}
