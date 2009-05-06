package com.test.jdk5;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

public class EnumSetDemo3
{
	public static void main(String[] args)
	{
		List<FontConstant> list = new ArrayList<FontConstant>();
		list.add(FontConstant.Bold);
		list.add(FontConstant.Italic);
		list.add(FontConstant.Plain);

		showEnumSet(EnumSet.copyOf(list));

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
