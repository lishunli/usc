package com.test.jdk5;

public class ShowEnum3
{
	public static void main(String[] args)
	{
		for (OpConstants c : OpConstants.values())
		{
			System.out.printf("%s%n\t%s%n", c, c.getDescription());
		}
	}

}

enum OpConstants
{
	TURN_LEFT, TURN_RIGHT, SHOOT;

	public String getDescription()
	{
		switch (this.ordinal()) {
		case 0:
			return "����ת";
		case 1:
			return "����ת";
		case 2:
			return "���";
		default:
			return null;
		}
	}
}