package org.usc.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeyWordFilter1
{
    private static Pattern pattern = null;

    // 从words.properties初始化正则表达式字符串
    private static void initPattern()
    {
        StringBuffer patternBuf = new StringBuffer("");
        try
        {
            InputStream in = KeyWordFilter1.class.getClassLoader().getResourceAsStream("filter_word.txt");
            Properties pro = new Properties();
            pro.load(in);
            in.close();
            @SuppressWarnings("unchecked")
            Enumeration<String> enu = (Enumeration<String>) pro.propertyNames();
            patternBuf.append("(");
            while (enu.hasMoreElements())
            {
                try {
                    String dd = (String) enu.nextElement();
                    dd = new String(dd.getBytes("ISO8859-1"), "UTF-8");
                    patternBuf.append(dd + "|");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            patternBuf.deleteCharAt(patternBuf.length() - 1);
            patternBuf.append(")");
            pattern = Pattern.compile(patternBuf.toString());
        } catch (IOException ioEx)
        {
            ioEx.printStackTrace();
        }
    }
    private static String doFilter(String str)
    {
        Matcher m = pattern.matcher(str);
        str = m.replaceAll("XXX"); // 敏感词替换
        return str;
    }

    public static void main(String[] args)
    {
        String str = "需要过滤的内容";
        initPattern();
        Date d1 = new Date();
        System.out.println("共" + str.length() + "个字符，查到" + KeyWordFilter1.doFilter(str));
        Date d2 = new Date();
        float cost = d2.getTime() - d1.getTime();
        System.out.println("总共花费：" + cost + "毫秒");
    }

}
