package com.test.jdk5;

public enum Color
{
	Red, White, Blue;
	
	public static void main(String[] args)
	{
//		Color myColor =Color.Blue;
//		System.out.println(myColor);
		
		for(Color color : Color.values())
		{
			System.out.println(color);
		}
	}
}



