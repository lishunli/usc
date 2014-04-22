package org.usc.demo;

import org.apache.commons.lang3.math.NumberUtils;

/**
 *
 * @author Shunli
 */
public class Test12 {
    public static void main(String[] args) throws Exception {
        // String content = FileUtils.readFileToString(new File("D:\\test.txt"));
        //
        // System.out.println(content.matches("[.\\s\\S]*test[.\\s\\S]*"));


        System.out.println(NumberUtils.createLong("12"));
        System.out.println(NumberUtils.toLong("12.2"));

    }
}
