package org.usc.junit4;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class CalculatorTest
{

	@Test
	public void testAdd()
	{
		int result = new Calculator().add(1, 2);
		assertEquals(3, result);
		assertTrue("result is too big",result < 6);
		assertThat(result,is(3));
	}
	
	@Test(expected=java.lang.ArithmeticException.class)
	public void testDivide()
	{
		int result = new Calculator().divide(8, 0);
	}
}
