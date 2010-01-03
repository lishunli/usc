package cn.itcast.day1;

import java.lang.reflect.*;

/**
 * 成员变量反射的综合案例
 * 
 * @author ShunLi
 * @Time 2010-1-3
 */
public class ChangString
{
	public static void main(String[] args)throws Exception
	{
		StringObj obj = new StringObj("ball", "baskball", "ShunLi");
		for(Field f: obj.getClass().getFields())
		{
			if(f.getType() == String.class)
			{
				String oldStr = (String) f.get(obj);
				String newStr = oldStr.replace('b', 'a');
				f.set(obj, newStr);
			}
		}
		System.out.println(obj);
	}
}
