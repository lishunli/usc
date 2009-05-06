
//≤Œ ˝ªØ≤‚ ‘

package com.test.JUnit4;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterTest
{
	
	private int input1;
	private int input2;
	private int expected;
	
	@Parameters
	public static  Collection<Object[]>  PrepareData()
	{
		//input1,input2,expected
		Object[][] object ={{1,2,3},{4,2,6},{0,0,0},{-2,4,2},{-6,-1,-7},{8,-10,-2}};
		
		return Arrays.asList(object);

	}
	
	public ParameterTest(int input1,int input2,int expected)
	{
		
		this.input1=input1;
		this.input2=input2;
		this.expected=expected;
		
	}
	
	@Test
	public void testAdd()
	{
		Calculator cal=new Calculator();
		assertEquals(expected, cal.add(input1, input2));
	}
	

}
