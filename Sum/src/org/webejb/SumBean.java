package org.webejb;

import javax.ejb.Stateless;

@Stateless
public class SumBean implements Sum
{

	public int GetSum(int a, int b)
	{
		return a+b;
	}

}
