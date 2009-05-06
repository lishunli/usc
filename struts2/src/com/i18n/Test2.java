package com.i18n;

import java.util.*;

public class Test2
{
	public static void main(String[] args)
	{
//		Locale locale = Locale.US;
//		Locale locale = Locale.CHINA;
		Locale locale = Locale.getDefault();
		
		ResourceBundle bundle = ResourceBundle.getBundle("hellofile",locale);
		
		String value = bundle.getString("hello");
		
		System.out.println(value);
		
	}
}
