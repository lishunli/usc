package org.usc.cnm;

import java.util.Scanner;



/**
 * �ݹ�ʵ������㷨
 * 
 * @author MZ
 * 
 * @2009-10-21����12:18:48
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
			int num = sc.nextInt();//������鳤��
			str = new String[num];//ʵ����str����
			for (int i = 0; i < num; i++)
			{
				str[i]=sc.next();//�����һ���ַ���
			}
			
			MyCombination comb = new MyCombination();
			for (int i = num; i > 0; i--)
			{
				comb.combination(num, i);//��������㷨

			}
		} catch (Exception e)
		{
			System.out.println("�������");
			System.exit(0);
		}
	}

	public void combination(int n, int m)
	{
		if (m == 0)
		{// �ݹ��˳�����,��ӡ�س�
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
