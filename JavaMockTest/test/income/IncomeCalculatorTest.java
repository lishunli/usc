package income;

import static org.junit.Assert.*;
import income.exceptions.CalcMethodException;
import income.exceptions.PositionException;
import income.method.ICalcMethod;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


//EasyMock :记录 + 回放 + 测试 + 检查
public class IncomeCalculatorTest
{
		private ICalcMethod calcMethodMock;
		private IncomeCalculator incomeCalc;


	@Before
	public void setUp() throws Exception
	{
		calcMethodMock =EasyMock.createMock(ICalcMethod.class);
		incomeCalc =new IncomeCalculator();
		
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testCalc1()
	{

		EasyMock.expect(calcMethodMock.calc(Position.BOSS)).andReturn(7000.0).times(2);
		
		EasyMock.expect(calcMethodMock.calc(Position.PROGRAMMER)).andReturn(5000.0);
		
		EasyMock.replay(calcMethodMock);//回放
		
		
		incomeCalc.setCalcMethod(calcMethodMock);
		
		try
		{
			incomeCalc.calc();
			fail("Exception did not occur");
		} catch (Exception e)
		{
			// TODO: handle exception
		}
		
		incomeCalc.setPosition(Position.BOSS);
		assertEquals(7000.0,incomeCalc.calc());
		assertEquals(7000.0,incomeCalc.calc());
		
		incomeCalc.setPosition(Position.PROGRAMMER);
		assertEquals(5000.0, incomeCalc.calc());
		
		incomeCalc.setPosition(Position.MANAGER);
		
		EasyMock.verify(calcMethodMock);//确认操作
		
	}
	
	@Test(expected = CalcMethodException.class)
	public void testNoCalc()
	{
		incomeCalc.setPosition(Position.MANAGER);
		incomeCalc.calc();
	}
	
	@Test(expected = PositionException.class)
	public void testNoPosition()
	{
		EasyMock.expect(calcMethodMock.calc(Position.BOSS)).andReturn(7000.0);
		EasyMock.replay(calcMethodMock);
		incomeCalc.setCalcMethod(calcMethodMock);
		incomeCalc.calc();
	}
	
	@Test(expected = PositionException.class)
	public void testCalc2()
	{
		EasyMock.expect(calcMethodMock.calc(Position.MANAGER)).andThrow(
				new PositionException("Don't know this guy")).times(1);
		
		EasyMock.replay(calcMethodMock);
		
		incomeCalc.setPosition(Position.MANAGER);
		
		incomeCalc.setCalcMethod(calcMethodMock);
		
		incomeCalc.calc();
	}
	
	

}
