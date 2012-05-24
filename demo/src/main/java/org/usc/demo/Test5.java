package org.usc.demo;

/**
 *
 * @author Shunli
 */
public class Test5 {
	public static void t1() {
		System.out.println("t1 start");
		throw new RuntimeException("t1 exception");
//		System.out.println("t1 end");
	}

	public static void main(String[] args) {
			t1();
		System.out.println("hello world");
	}

}
