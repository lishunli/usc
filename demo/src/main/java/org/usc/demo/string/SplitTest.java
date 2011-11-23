package org.usc.demo.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ShunLi
 */
public class SplitTest {
    private static final String DEFAULT_VALUE = null;

    public static void main(String[] args) {
        String source = "[Type=UPC-A][Final=10][Nnmber=9][Test";

        System.out.println("Method1: " + splitMethod1(source));
        System.out.println("Method2: " + splitMethod2(source));
        System.out.println("Method3: " + splitMethod3(source));

    }

    // String.split()用法的一点经验
    // 在java.lang包中有String.split()方法，返回是一个数组
    // 1、如果用“.”作为分隔的话，必须是如下写法：String.split("\\."),这样才能正确的分隔开，不能用String.split(".");
    // 2、如果用“|”作为分隔的话，必须是如下写法：String.split("\\|"),这样才能正确的分隔开，不能用String.split("|");
    // (“.”和“|”都是转义字符，必须得加"\\")
    // 3、如果在一个字符串中有多个分隔符，可以用“|”作为连字符，比如：“acount=? and uu =? or n=?”,把三个都分隔出来，可以用String.split("and|or");
    private static Map<String, String> splitMethod1(String source) {
        Map<String, String> properties = new LinkedHashMap<String, String>();
        String[] temp = source.split("\\[|]");
        for (String subString : temp) {
            if (subString.length() > 0) {
                String[] property = subString.split("=");
                properties.put(property[0], property.length > 1 ? property[1] : DEFAULT_VALUE);
            }
        }
        return properties;
    }

    private static Map<String, String> splitMethod2(String source) {
        Map<String, String> properties = new LinkedHashMap<String, String>();
        StringTokenizer s = new StringTokenizer(source, "[=]");
        String key = null;
        String value = null;
        while (s.hasMoreTokens()) {
            key = s.nextToken();
            value = DEFAULT_VALUE;
            if (s.hasMoreTokens()) {
                value = s.nextToken();
            }
            properties.put(key, value);
        }

        return properties;
    }

    // 当正则表达式中包含能接受重复的限定符时，通常的行为是（在使整个表达式能得到匹配的前提下）匹配尽可能多的字符。
    // 以这个表达式为例：a.*b，它将会匹配最长的以a开始，以b结束的字符串。如果用它来搜索aabab的话，它会匹配整个字符串aabab。这被称为贪婪匹配。
    // 有时，我们更需要懒惰匹配，也就是匹配尽可能少的字符。前面给出的限定符都可以被转化为懒惰匹配模式，只要在它后面加上一个问号?。
    // 这样.*?就意味着匹配任意数量的重复，但是在能使整个匹配成功的前提下使用最少的重复
    private static Map<String, String> splitMethod3(String source) {
        Map<String, String> properties = new LinkedHashMap<String, String>();

        Pattern p = Pattern.compile("\\[(.*?)=(.*?)\\]");
        Matcher m = p.matcher(source);

        while (m.find()) {
            properties.put(m.group(1), m.group(2));
        }

        return properties;
    }
}
