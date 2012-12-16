package org.usc.demo;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class DecodeTest {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String source = "中文测试，hello+world i'm lishunli%中文";
        String encode = URLEncoder.encode(source, "utf8");
        System.out.println(encode);

        String encodeStr = "%E4%B8%AD%E6%96%87%E6%B5%8B%E8%AF%95%EF%BC%8C%E8%BF%98%E6%9C%89%E7%89%B9%E6%AE%8A%E5%AD%97%E7%AC%A6%25%E6%B5%8B%E8%AF%95";
        System.out.println(URLDecoder.decode(encodeStr, "utf8"));

        String encoding = "utf8";

        System.out.println(new String(encodeStr.getBytes("ISO-8859-1")));
        System.out.println(URLDecoder.decode(new String(encodeStr.getBytes("ISO-8859-1")), encoding));
        System.out.println(URLDecoder.decode(encodeStr, encoding));

    }
}
