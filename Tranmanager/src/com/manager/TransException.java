package com.manager;

import javax.ejb.ApplicationException;

@SuppressWarnings("serial")
@ApplicationException(rollback = true)
// һ�������쳣�����ݿ�ع�
public class TransException extends Exception
{

	public TransException(String string)
	{
		super(string);
	}

}
