package com.test.jdk5;

import java.util.EnumSet;
import java.util.Iterator;

enum FontConstant
{
	Plain, Bold, Italic,Hello
}

public class EnumSetDemo
{
	public static void main(String[] args)
	{
		EnumSet<FontConstant> enumSet = EnumSet.of(FontConstant.Plain,
				FontConstant.Bold);
		showEnumSet(enumSet);
		showEnumSet(EnumSet.complementOf(enumSet));//complement������
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