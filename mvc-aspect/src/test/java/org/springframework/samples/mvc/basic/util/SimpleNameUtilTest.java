package org.springframework.samples.mvc.basic.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Simple Name Util Test
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2011-7-7<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        <p>
 */
public class SimpleNameUtilTest {
	private String className = "org.springframework.samples.mvc.basic.controller.UserController";

	@Test
	public void testchompClassNameWithNoParams() {
		assertEquals("UserController", SimpleNameUtil.chompClassName(className));
	}

	@Test
	public void testchompClassNameWithChompSizeParams() {
		int chompSize = 3;
		assertEquals("basic.controller.UserController", SimpleNameUtil.chompClassName(className, chompSize));
	}

	@Test
	public void testchompClassNameWithSeparatorCharsParams() {
		String separatorChars = "s";
		assertEquals("erController", SimpleNameUtil.chompClassName(className, separatorChars));
	}

	@Test
	public void testchompClassNameNormal() {
		int chompSize = 3;
		String separatorChars = ".";
		assertEquals("mvc.basic.controller.UserController", SimpleNameUtil.chompClassName(className, separatorChars, chompSize));
	}

	@Test
	public void testchompClassNameE1() {
		int chompSize = 4;
		String separatorChars = null;
		assertEquals(className, SimpleNameUtil.chompClassName(className, separatorChars, chompSize));
	}

	@Test
	public void testchompClassNameE2() {
		int chompSize = 4;
		String separatorChars = "/";
		assertEquals(className, SimpleNameUtil.chompClassName(className, separatorChars, chompSize));
	}

	@Test
	public void testchompClassNameE3() {
		int chompSize = -3;
		String separatorChars = ".";
		assertEquals(className, SimpleNameUtil.chompClassName(className, separatorChars, chompSize));// ignore
	}

	@Test
	public void testchompClassNameE4() {
		int chompSize = 0;
		String separatorChars = ".";
		assertEquals(className, SimpleNameUtil.chompClassName(className, separatorChars, chompSize));// ignore
	}

	@Test
	public void testchompClassNameE5() {
		int chompSize = 0;
		String separatorChars = "/";
		assertEquals(className, SimpleNameUtil.chompClassName(className, separatorChars, chompSize));
	}

	@Test
	public void testchompClassNameE6() {
		int chompSize = 30;// > . counts
		String separatorChars = ".";
		assertEquals(className, SimpleNameUtil.chompClassName(className, separatorChars, chompSize));
	}
}
