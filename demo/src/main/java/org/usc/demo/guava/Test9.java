package org.usc.demo.guava;

import com.google.common.base.Splitter;

/**
 * 
 * @author Shunli
 */
public class Test9 {
    private static final Splitter COMMA_SPLITTER = Splitter.on(",").omitEmptyStrings().trimResults();
    private static final Splitter EQUAL_MARK_SPLITTER = Splitter.on("=").omitEmptyStrings().trimResults();
    private static final Splitter UPRIGHT_SLASH_SPLITTER = Splitter.on("|").omitEmptyStrings().trimResults();

    public static void main(String[] args) {
        System.out.println(COMMA_SPLITTER.withKeyValueSeparator(EQUAL_MARK_SPLITTER).split("key1=value1,key2=value2,key3=value3"));
        System.out.println(COMMA_SPLITTER.withKeyValueSeparator(UPRIGHT_SLASH_SPLITTER).split("key1|value1,key2|value2,key3|value3"));
    }

}
