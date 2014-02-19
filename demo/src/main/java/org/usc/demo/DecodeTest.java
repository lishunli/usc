package org.usc.demo;

import java.net.URLDecoder;

public class DecodeTest {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // String source = "中文测试，hello+world i'm lishunli%中文";
        // String encode = URLEncoder.encode(source, "utf8");
        // System.out.println(encode);

        // String encodeStr = "测试%test";
        String encoding = "UTF-8";
//        String encodeStr = "%E6%B5%8B%E8%AF%95%25test";
        String encodeStr = "中文test";
        encodeStr = URLDecoder.decode(encodeStr, encoding);
        System.out.println(encodeStr);
        // System.out.println(URLDecoder.decode(encodeStr, "utf8"));

        // System.out.println(new String(encodeStr.getBytes("ISO-8859-1")));
        String x = new String(encodeStr.getBytes("UTF-8"), "ISO-8859-1");
        System.out.println(x);
        // System.out.println(new String(x.getBytes("ISO-8859-1"), "UTF-8"));
        // System.out.println(URLDecoder.decode(new String(x.getBytes("ISO-8859-1"), "UTF-8"), encoding));
        System.out.println(new String(x.getBytes("ISO-8859-1"), "UTF-8"));
        // System.out.println(URLDecoder.decode(new String(encodeStr.getBytes("ISO-8859-1")), encoding));
        // System.out.println(URLDecoder.decode(encodeStr, encoding));

    }
}
