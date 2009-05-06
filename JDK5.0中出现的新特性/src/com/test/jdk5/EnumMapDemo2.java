package com.test.jdk5;

import java.util.EnumMap;
import java.util.Map;

public class EnumMapDemo2
{
	public static void main(String[] args)
	{
		Map<Action, String> map = new EnumMap<Action, String>(Action.class);
		map.put(Action.SHOOT, "射击");
		map.put(Action.TURN_RIGHT, "向右转");
		map.put(Action.TURN_LEFT, "向左转");
		//打印的顺序跟put没有关系，跟Enum有关，这个跟hashmap不同
		for (String value : map.values())
		{
			System.out.println(value);
		}
	}
}
