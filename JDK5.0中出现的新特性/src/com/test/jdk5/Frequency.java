package com.test.jdk5;

import java.util.Map;
import java.util.TreeMap;

public class Frequency
{
	//≤‚ ‘ ˝æ›
	//if it is to be it is up to me to do the with
	
	public static void main(String[] args)
	{
		Map<String, Integer> m = new TreeMap<String, Integer>();
		for (String word : args)
		{
			Integer freq = m.get(word);
			m.put(word, (freq == null ? 1 : freq + 1));
		}
		System.out.println(m);
	}

}
