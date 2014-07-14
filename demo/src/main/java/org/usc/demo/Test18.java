package org.usc.demo;

/**
 *
 * @author Shunli
 */
public class Test18 {

    public static void main(String[] args) throws Exception {
        String str = "中文";
        System.out.println(new String(str.getBytes("ISO-8859-1"), "UTF-8"));

        // String encodeStr = "%E5%86%85%E9%83%A8%E6%B5%8B%E8%AF%95%E6%9C%8D1";
        // System.out.println(URLDecoder.decode(encodeStr, "ISO-8859-1"));
        // System.out.println(URLDecoder.decode(encodeStr, "UTF-8"));
        // // String decode = URLDecoder.decode(encodeStr, "ISO-8859-1");
        // String decode = URLEncoder.encode("内部测试服1", "ISO-8859-1");
        // // System.out.println(decode);
        // System.out.println(URLDecoder.decode(new String(decode.getBytes("ISO-8859-1"), "UTF-8"), "UTF-8"));
        // System.out.println(URLDecoder.decode(new String(encodeStr.getBytes("ISO-8859-1"), "UTF-8"), "UTF-8"));

        // // String source = "中文测试，hello+world i'm lishunli%中文";
        // // String encode = URLEncoder.encode(source, "utf8");
        // // System.out.println(encode);
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
