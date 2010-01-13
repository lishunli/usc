package org.usc.javautils.string;

import java.util.Scanner;

/**
 * 把GBK的字符串转换为UTF-8格式的字符串，不使用方法
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-1-13<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
public class GBKToUTF8
{

	private static GBKToUTF8 instance = new GBKToUTF8();

	private GBKToUTF8()
	{

	}

	public static GBKToUTF8 getInstance()
	{
		return instance;
	}

	public static String GBKToUtf8(String content)
	{
		String hexStr = "";
		try
		{
			char contentBuffer[] = content.toCharArray();
			for (int i = 0; i < content.length(); i++)
			{
				int n = contentBuffer[i];
				String s = Integer.toHexString(n);
				if (s.length() > 4)
					s = s.substring(0, 4);
				else
					s = "0000".substring(0, 4 - s.length()) + s;
				hexStr = hexStr + "&#x" + s + ";";
			}

		}
		catch (Exception ex)
		{
			hexStr = "";
		}
		return hexStr;
	}

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);// 获取键盘流
		System.out.print("请输入内容：");
		String content = scan.nextLine();// 获取键盘输入的字符串
		System.out.println(GBKToUtf8(content));
	}

}
