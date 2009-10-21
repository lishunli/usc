package org.usc.cnm;

import java.util.Scanner;



/**
 * 递归实现组合算法
 * 
 * @author MZ
 * 
 * @2009-10-21下午12:18:48
 */
public class MyCombination
{

	private static int count = 0;
	private static int buff[] = new int[20];
	private static String str[];
	public static void main(String[] args)
	{
		
		try
		{
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();//获得数组长度
			str = new String[num];//实例化str数组
			for (int i = 0; i < num; i++)
			{
				str[i]=sc.next();//获得下一个字符串
			}
			
			MyCombination comb = new MyCombination();
			for (int i = num; i > 0; i--)
			{
				comb.combination(num, i);//调用组合算法

			}
		} catch (Exception e)
		{
			System.out.println("输入错误");
			System.exit(0);
		}
	}

	public void combination(int n, int m)
	{
		if (m == 0)
		{// 递归退出条件,打印回车
			for (int i = 0; i < count; ++i)
				System.out.print(str[buff[i]-1]+" ");
			System.out.println();
			return;
		}
		for (int i = 0; i <= n - m; ++i)
		{
			buff[count++] = n - i;
			combination(n - i - 1, m - 1);
			--count;
		}
	}

}
