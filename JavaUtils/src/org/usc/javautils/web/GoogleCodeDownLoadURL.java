package org.usc.javautils.web;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Scanner;

/**
 * 获取Google Code 下载地址
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-1-12<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
public class GoogleCodeDownLoadURL
{

	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);//获取键盘流
		System.out.print("请输入Google Code 下载的文件名：");
		String filename = scan.nextLine();//获取键盘输入的字符串
		System.out.println(filename+" URLEncode为：");
		System.out.println(googleCodeDownLoadURL(filename));
		
	}

	/**
	 * 字符串URL编码
	 * @param filename 文件名
	 * @return URL编码后的文件名
	 */
	private static String stringToURL(String filename)
	{
		String retVal = null;
		try
		{
			retVal = URLEncoder.encode(filename, "UTF-8");//URL编码，GBK 到 UTF-8格式
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		return retVal;
	}
	/**
	 * 获取Google Code 下载地址
	 * @param filename 文件名
	 * @return Google Code 下载地址
	 */
	private static String googleCodeDownLoadURL(String filename)
	{
		final String prefixURL = "http://usc.googlecode.com/files/";//前缀
		String retVal = prefixURL + stringToURL(filename);//Google Code 下载地址
		return retVal;
	}

}
