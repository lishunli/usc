
//测试私有方法的方法，使用反射机制
package com.test.JUnit4;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class CalculatorTest2
{
	@Test
	public void testAdd()
	{
		
		
		try
		{
			Calculator2 cal =new Calculator2();
			
			Class<Calculator2> cl =Calculator2.class;
			
			Method method =cl.getDeclaredMethod("add",new Class[]{int.class,int.class});
			
			method.setAccessible(true);//不加的话就会抛出异常
			
		    Object result =	method.invoke(cal,new Object[]{1,2});
		    
		    assertEquals(3,result);
		    
		} catch (SecurityException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
			
		} catch (NoSuchMethodException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		} catch (IllegalArgumentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		} catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		} catch (InvocationTargetException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		
		
	}

}
