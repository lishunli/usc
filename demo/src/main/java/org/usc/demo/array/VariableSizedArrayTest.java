package org.usc.demo.array;

import java.util.Arrays;

/**
 *
 * @author Shunli
 */
public class VariableSizedArrayTest {

	public static void main(String[] args) {
		String[] vals = new String[10];
		Arrays.fill(vals, "1");
		System.out.println(Arrays.toString(vals));
		// ...
		vals = expandCapacity(vals, 20);
		System.out.println(Arrays.toString(vals));

	}

	public static <T> T[] expandCapacity(T[] datas, int newLength) {
		// 不能是负值
		newLength = newLength < 0 ? 0 : newLength;
		// 生成一个新数组，并copy原值
		return Arrays.copyOf(datas, newLength);
	}

}
