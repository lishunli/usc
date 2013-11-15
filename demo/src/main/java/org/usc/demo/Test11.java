package org.usc.demo;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Shunli
 */
public class Test11 {
    public static void main(String[] args) {
        String template = "你好 %s";
        System.out.println(String.format(template, "lishunli", "19:00:00"));

        String time = "2013-06-22 10:15:58";
        System.out.println(StringUtils.substring(time, 11));

    }
}
