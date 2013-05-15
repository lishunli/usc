package org.usc.demo;

import java.util.regex.Pattern;

/**
 *
 * @author Shunli
 */
public class Test10 {
    // private final static String FULL_TEXT_MATCH_FORMAT = "%s";
    private final static String NON_FULL_TEXT_MATCH_FORMAT = ".*%s.*";
    private final static String MATCH_ALL_FORMAT = "[\\s\\S]*";

    public static void main(String[] args) {
        String key = "test中文";

        String regex = String.format(NON_FULL_TEXT_MATCH_FORMAT, key);
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
        System.out.println(pattern.matcher("122TESxx\r\nsxxTest\r\n").matches());

        pattern = Pattern.compile(key, Pattern.CASE_INSENSITIVE);
        System.out.println(pattern.matcher("tEst中文").matches());

        pattern = Pattern.compile(MATCH_ALL_FORMAT);
        System.out.println(pattern.matcher("1 中文321s\r\ndf\t@sdas12中文aa\r\nfsds2").matches());

        // System.out.println("122TESxx\r\nsxxTest".matches(regex));
        // System.out.println("tEst".matches(String.format(FULL_TEXT_MATCH_FORMAT, key)));
        // System.out.println("1 中文321s\r\ndfaa\r\nfsds2".matches(MATCH_ALL_FORMAT));

    }
}
