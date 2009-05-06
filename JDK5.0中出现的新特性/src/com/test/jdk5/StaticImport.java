package com.test.jdk5;

import static com.test.common.Common.COUNTRY;
import static com.test.common.Common.add;
//æ≤Ã¨µº»Î

public class StaticImport
{
	public static void main(String[] args)
	{
		System.out.println(add(1,2));
		
		System.out.println(COUNTRY);
	}
}



//import  com.test.common.Common;
//
//public class StaticImport
//{
//	public static void main(String[] args)
//	{
//		System.out.println(Common.add(1,2));
//		
//		System.out.println(Common.COUNTRY);
//	}
//}