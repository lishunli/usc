package com.test.junit4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({CalculatorTest.class,CalculatorTest2.class,ParameterTest.class,LargestTest.class})
public class TestAll 
{
	
	
}
