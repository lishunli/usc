package org.usc.demo.guava;

import java.util.ArrayList;
import java.util.Iterator;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

/**
 *
 * @author Shunli
 */
public class GuavaTest2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        CharMatcher cm = CharMatcher.inRange('a', 'z').or(CharMatcher.inRange('A', 'Z'));
        System.out.println(cm.matches('c'));
        System.out.println(cm.matches('A'));
        System.out.println(cm.matches('1'));

        String string = CharMatcher.DIGIT.retainFrom("some text 89 x 983 and more");
        System.out.println(string);

        string = CharMatcher.DIGIT.removeFrom("some text 8x9983 and more");
        System.out.println(string);

        String[] subdirs = { "usr", "local", "lib" };
        String directory = Joiner.on("/").join(subdirs);
        System.out.println(directory);

        int[] numbers = { 1, 2, 3, 4, 5 };
        String numbersAsString = Joiner.on(";").join(Ints.asList(numbers));
        System.out.println(numbersAsString);

        String testString = "foo , what,,,more,";
        // String testString = "";
        Iterable<String> split = Splitter.on(",").omitEmptyStrings().trimResults().split(testString);

        for (String string2 : split) {
            System.out.println(string2);
        }

        Iterator<String> iterator = split.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        ArrayList<String> newArrayList = Lists.newArrayList(split);
        System.out.println(newArrayList);
        for (String string2 : newArrayList) {
            System.out.println(string2);
        }

    }
}
