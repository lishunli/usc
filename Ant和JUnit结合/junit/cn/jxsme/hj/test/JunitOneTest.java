package cn.jxsme.hj.test;

import junit.framework.TestCase;

/*
 * autho huangjin green eat  
 *Dec 30, 2008
 */
public class JunitOneTest extends TestCase {
	
	private JunitOne one;

	protected void setUp() throws Exception {
		one = new JunitOne();
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testSayHello() {
    
//		one.setUser("黄进");
		System.out.println("tesis "+new java.util.Date());
		assertEquals("this is error","hellohj", one.sayHello("hj"));

//	    assertEquals("会相等吗","黄进", one.getUser());
	}
	

}
