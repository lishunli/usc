package com.usc.log;

import org.apache.log4j.Logger;

/**
 * log4j�Ĳ��Գ���
 * 
 * @author MZ
 *
 * 2009-10-17����07:19:23
 */
public class TestLog4j
{
	private static Logger logger = Logger.getLogger(TestLog4j.class);//����logger ����
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		logger.debug("this is a debug message");
		logger.info("this is a information message");
		logger.error("this is a error message");
	}

}
