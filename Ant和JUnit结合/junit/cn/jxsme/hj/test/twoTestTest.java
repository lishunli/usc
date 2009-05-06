package cn.jxsme.hj.test;

import junit.framework.TestCase;

/*
 * autho huangjin green eat  
 *Dec 30, 2008
 */
public class twoTestTest extends TestCase {

	private twoTest two;
	
	protected void setUp() throws Exception {

		two = new twoTest();
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testSum() {
		assertEquals("this is method sum",2, two.sum(1, 1));
	}

	public void testMinu() {

	   assertEquals("this is method minu",2,two.minu(5, 3));
	}

	public void testRide() {
		
		assertEquals("this is method ride",12,two.ride(3, 4));
	}

	public void testEx() {
		assertEquals("this is method Ex",2,two.ex(6, 0));
	}

}
