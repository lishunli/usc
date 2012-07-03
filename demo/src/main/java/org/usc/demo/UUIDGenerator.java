package org.usc.demo;

import java.util.UUID;

/**
 *
 * @author Shunli
 */
public class UUIDGenerator {

	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
	}

}
