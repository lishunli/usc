package org.webejb;

import javax.ejb.Remote;

@Remote
public interface Sum
{
	public int GetSum(int a,int b);
}
