package org.usc.demo.string;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

/**
 *
 * @author Shunli
 */
public class ChinaWordSortTest {

	public static void main(String[] args) {
		String[] names = { "张三", "李四", "王五" };

		String[] names1 = names.clone();
		Arrays.sort(names1);
		System.out.println(Arrays.toString(names1));

		// This mthod is simple method which sort chinese word.
		String[] names2 = names.clone();
		Collator c = Collator.getInstance(Locale.CHINA);
		Arrays.sort(names2, c);
		System.out.println(Arrays.toString(names2));
	}

}
