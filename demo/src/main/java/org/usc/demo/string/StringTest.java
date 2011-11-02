package org.usc.demo.string;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author ShunLi
 */
public class StringTest {
    public static void main(String[] args) {
        String source = "java.lang.NullPointerExcetpion";
//        System.out.println(source.substring(0,200));
        System.out.println(StringUtils.substring(source, 0, 200));
    }

}
