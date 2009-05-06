package com.test.jdk5;

import java.util.EnumSet;
import java.util.Iterator;

public class EnumSetDemo2
{
	public static void main(String[] args)
	{
		// noneOf() 创建一个具有指定元素类型的空枚举 set
		EnumSet<FontConstant> enumSet = EnumSet.noneOf(FontConstant.class);
		enumSet.add(FontConstant.Bold);
		enumSet.add(FontConstant.Italic);
		showEnumSet(enumSet);
	}

	public static void showEnumSet(EnumSet<FontConstant> enumSet)
	{
		Iterator<FontConstant> iterator = enumSet.iterator();
		while (iterator.hasNext())
		{
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}
}
