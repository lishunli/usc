package org.benjamin.javadoc2chm.object;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListMap;

public class ApiIndexMap
{

	private Map<String, TreeSet<ApiIndexElement>> map;
	private static ApiIndexMap apiMap = null;

	private ApiIndexMap()
	{
		map = new ConcurrentSkipListMap<String, TreeSet<ApiIndexElement>>();
	}

	public void insertNode(String fieldName, String className, String packageName, String paraList, String path)
	{
		TreeSet<ApiIndexElement> set = map.get(fieldName);
		ApiIndexElement elem = new ApiIndexElement(className, packageName, paraList, path);
		if (set != null)
		{
			/**
			 * this is Class entry, insert a Class entry first
			 */
			if (fieldName.equals(className) && (paraList == null || paraList.equals("")))
			{
				ApiIndexElement cls = new ApiIndexElement(className, packageName, "", path);
				set.add(cls);
			}
			set.add(elem);
		} else
		{
			set = new TreeSet<ApiIndexElement>();
			/**
			 * this is Class entry, insert a Class entry first
			 */
			if (fieldName.equals(className) && (paraList == null || paraList.equals("")))
			{
				ApiIndexElement cls = new ApiIndexElement(className, packageName, "", path);
				set.add(cls);
			}
			set.add(elem);
			map.put(fieldName, set);
		}
	}

	public static ApiIndexMap getInstance()
	{
		if (apiMap == null)
			apiMap = new ApiIndexMap();
		return apiMap;
	}

	public void clear()
	{
		if (map != null)
			map.clear();
		map = null;
	}

	/**
	 * just for debug
	 */
	public void print()
	{
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext())
		{
			String key = it.next();
			TreeSet<ApiIndexElement> value = map.get(key);
			System.out.println(key);
			Iterator<ApiIndexElement> iterator = value.iterator();
			while (iterator.hasNext())
			{
				ApiIndexElement elem = iterator.next();
				if (key.equals(elem.getClassName()))
					System.out.println("\t" + elem.getPackageName() + "." + elem.getClassName() + elem.getParaList() + "\t" + elem.getPath());
				else
					System.out.println("\t" + elem.getPackageName() + "." + elem.getClassName() + "." + key + elem.getParaList() + "\t" + elem.getPath());
			}
		}
	}

	public Iterator<String> iterator()
	{
		return this.map.keySet().iterator();
	}

	public Set<ApiIndexElement> get(String key)
	{
		return map.get(key);
	}

}
