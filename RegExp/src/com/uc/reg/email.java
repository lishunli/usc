package com.uc.reg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class email
{
	public static void main(String[] args)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("email.htm"));
			String line ="";
			while(null != (line=br.readLine()))//�ж��Ƿ����
			{
				parse(line);//��������
			}
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void parse(String line)
	{
		Pattern p = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+");//email��������ʽ
		Matcher m = p.matcher(line);
		while(m.find()) {
			System.out.println(m.group());
		}
		
	}

}
