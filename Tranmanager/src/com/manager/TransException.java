package com.manager;

import javax.ejb.ApplicationException;

@SuppressWarnings("serial")
@ApplicationException(rollback = true)
// 一旦产生异常，数据库回滚
public class TransException extends Exception
{

	public TransException(String string)
	{
		super(string);
	}

}
