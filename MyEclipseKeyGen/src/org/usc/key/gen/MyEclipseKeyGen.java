package org.usc.key.gen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * MyEclipse(8.0,7.5,7.0,6.5,6.0...)的注册码生成代码
 * 
 * 
 * @author ShunLi
 * @Time 2009-12-25
 */
public class MyEclipseKeyGen
{

	private static final String LL = "Decompiling this copyrighted software is a violation of both your license agreement and the Digital Millenium Copyright Act of 1998 (http://www.loc.gov/copyright/legislation/dmca.pdf). Under section 1204 of the DMCA, penalties range up to a $500,000 fine or up to five years imprisonment for a first offense. Think about it; pay for a license, avoid prosecution, and feel better about yourself.";

	public MyEclipseKeyGen()
	{
	}

	/**
	 * 具体的Subscription Code生成算法
	 * 
	 * @param userId
	 *            (Subscriber)
	 * @param licenseNum
	 * @return Subscription Code
	 */
	public String getSerial(String subscriber, String licenseNum)
	{
		java.util.Calendar cal = java.util.Calendar.getInstance();// 获得当前日期
		cal.add(1, 3);// +3年
		cal.add(6, -1);// 当前日-1
		java.text.NumberFormat nf = new java.text.DecimalFormat("000");
		licenseNum = nf.format(Integer.valueOf(licenseNum));// licenseNum格式化成三位数字
		String verTime = new StringBuilder("-").append(
				new java.text.SimpleDateFormat("yyMMdd").format(cal.getTime()))
				.append("0").toString();// 日期
		String type = "YE3MP-";
		String need = new StringBuilder(subscriber.substring(0, 1))
				.append(type).append("300").append(licenseNum).append(verTime)
				.toString();// 初步注册信息
		String dx = new StringBuilder(need).append(LL).append(subscriber)
				.toString();
		int suf = this.decode(dx);// 编码初步注册信息
		String code = new StringBuilder(need).append(String.valueOf(suf))
				.toString();
		return this.change(code);
	}

	private int decode(String s)
	{
		int i;
		char[] ac;
		int j;
		int k;
		i = 0;
		ac = s.toCharArray();// 把s转化为单个字符数组
		j = 0;
		k = ac.length;
		while (j < k)
		{
			i = (31 * i) + ac[j];//加密算法，不理解为什么这样子？有可能就是这样子定义的
			j++;
		}
		return Math.abs(i);//取绝对值
	}

	/**
	 * 变化原则是
	 * 把数字（10个）或者字母表（大小写个26个）折半对调（两个相互改变），也即
	 * 0与5对调（0变5，5变0）
	 * A与N，a与n对调
	 * @param 原字符串
	 * @return 变化后的字符串
	 */
	private String change(String s)
	{
		byte[] abyte0;
		char[] ac = null;
		int i;
		int k;
		int j;
		abyte0 = s.getBytes();
		ac = new char[abyte0.length];
		i = 0;
		k = abyte0.length;
		while (i < k)
		{
			j = abyte0[i];
			if ((j >= 48) && (j <= 57))// 0-9,实现01234和56789相应的相互对调，也即0与5对调，1与6对调
			{
				j = (((j - 48) + 5) % 10) + 48;
			} else if ((j >= 65) && (j <= 90))// A-Z
			{
				j = (((j - 65) + 13) % 26) + 65;
			} else if ((j >= 97) && (j <= 122))// a-z
			{
				j = (((j - 97) + 13) % 26) + 97;
			}
			ac[i] = (char) j;   
			i++;   
		}
		return String.valueOf(ac);
	}

	/**
	 * 主方法，首先调用，产生注册码(Subscription Code)
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		// 输入中文会出现一些中文乱码问题
		// 输入中文，一个是由于工程设置的字符集有可能会出现乱码，第二个是后面的getBytes对不同的字符会出现不同的处理形式而导致的中文乱码
		// 所以大家也就没有办法设置中文用户名了，如果有高手解决了，请通知我（QQ：506817493，E：leeshunli@qq.com），谢谢
		
		System.out.print("请输入注册的用户名(不支持中文):");
		Scanner scanner = new Scanner(System.in);//输入流
		String subscriber = scanner.nextLine();//读下一行字符串
		MyEclipseKeyGen myeclipseKeyGen = new MyEclipseKeyGen();//实例化
		String subscription_Code = myeclipseKeyGen.getSerial(subscriber, "1");// 后面的参数是一个数字类型的字符串,数字范围为0-999
		System.out.println("\n" + "MyEclipse注册码生成的结果如下" + "\n");
		System.out.println("Subscriber:" + subscriber);
		System.out.println("Subscription Code:" + subscription_Code);

		/**
		 * 下面的是JDK1.5以前的写法，JDK1.5及以上版本的请看上面更好的写法
		 */

		/*
		 * BufferedReader reader = null; try {
		 * System.out.println("请输入注册的用户名(不支持中文):"); reader = new
		 * BufferedReader(new InputStreamReader(System.in)); String subscriber =
		 * null; subscriber = reader.readLine(); System.out.println(subscriber);
		 * 
		 * MyEclipseKeyGen myeclipseKeyGen = new MyEclipseKeyGen(); String
		 * subscription_Code = myeclipseKeyGen.getSerial(subscriber, "1");//
		 * 后面的参数是一个数字类型的字符串,数字范围为0-999 // System.out.println("注册生成的结果如下");
		 * System.out.println("Subscriber:" + subscriber);
		 * System.out.println("Subscription Code:" + subscription_Code);
		 * reader.readLine();
		 * 
		 * } catch (IOException ex) { ex.printStackTrace(); } finally { if
		 * (reader != null) { try { reader.close(); } catch (IOException e) {
		 * e.printStackTrace(); } reader = null; } }
		 */
	}
}
