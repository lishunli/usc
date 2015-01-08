package org.usc.demo;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 *
 * @author Shunli
 */
public class Test18 {

    public static void main(String[] args) throws Exception {
        // String str = "中文";
        // System.out.println(new String(str.getBytes("ISO-8859-1"), "UTF-8"));

        String encodeStr = "%2Fupload%2F000045%2Ffck%2Fimage%2F%E8%8A%82%E6%97%A5%2F";
        // System.out.println(URLDecoder.decode(encodeStr, "ISO-8859-1"));
        // System.out.println(URLDecoder.decode(encodeStr, "UTF-8"));
        // // String decode = URLDecoder.decode(encodeStr, "ISO-8859-1");
        String decode = URLEncoder.encode(encodeStr, "ISO-8859-1");
        System.out.println(decode);
        System.out.println(URLDecoder.decode(encodeStr, "UTF-8"));
        System.out.println(new String(encodeStr.getBytes("ISO-8859-1"), "UTF-8"));
        System.out.println(URLDecoder.decode(new String(encodeStr.getBytes("ISO-8859-1"), "UTF-8"), "UTF-8"));
        // System.out.println(URLDecoder.decode(new String(encodeStr.getBytes("ISO-8859-1"), "UTF-8"), "UTF-8"));

        // // String source = "中文测试，hello+world i'm lishunli%中文";
        // String encode = URLEncoder.encode("http://10.11.200.33:76/youxi-emqy/druid/weburi-detail.html?uri=/youxi-emqy/qianghao?action=getUserInfoForWeb",
        // "utf8");
        // System.out.println(encode);
        //
        // // String encodeStr = "测试%test";
        // // String encoding = "UTF-8";
        // // String encodeStr = "中文test";
        // // encodeStr = URLDecoder.decode(encodeStr, encoding);
        // // System.out.println(encodeStr);
        // // System.out.println(URLDecoder.decode(encodeStr, "utf8"));
        //
        // // System.out.println(new String(encodeStr.getBytes("ISO-8859-1")));
        // String x = new String(encodeStr.getBytes("UTF-8"), "ISO-8859-1");
        // System.out.println(x);
        // // System.out.println(new String(x.getBytes("ISO-8859-1"), "UTF-8"));
        // System.out.println(new String(x.getBytes("ISO-8859-1"), "UTF-8"));
        // // System.out.println(URLDecoder.decode(new String(encodeStr.getBytes("ISO-8859-1")), encoding));
        // // System.out.println(URLDecoder.decode(encodeStr, encoding));

    }
}
