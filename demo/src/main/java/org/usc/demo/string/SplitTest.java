package org.usc.demo.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author ShunLi
 */
public class SplitTest {
    private static final String DEFAULT_VALUE = null;

    public static void main(String[] args) {
        String source = "[Type=UPC-A][Final=10][Nnmber=9][Test";

        System.out.println("Method1" + splitMethod1(source));
        System.out.println("Method2" + splitMethod2(source));

    }

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
}

