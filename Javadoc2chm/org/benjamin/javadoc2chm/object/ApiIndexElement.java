package org.benjamin.javadoc2chm.object;

public class ApiIndexElement implements Comparable<ApiIndexElement>
{

	/**
	 * The method name is stored in the key of Map There's something to do with the Class and Method
	 * 
	 * The Class must generate redir-file like this: "java.util.TreeMap" "java.util.TreeMap()"
	 * 
	 * method may be like this: "java.util.TreeMap.toString()" "java.lang.Object.toString()"
	 * 
	 * field may be like this: "java.lang.Object.A" "java.util.Map.A"
	 */
	private String className; // e.g. "TreeMap"
	private String packageName; // e.g. "java.util"
	private String paraList; // e.g. "(String name)", "", "()"
	private String path; // e.g. "java/util/TreeMap.html"

	public ApiIndexElement(String className, String packageName, String paraList, String path)
	{
		this.className = className;
		this.packageName = packageName;
		this.paraList = paraList;
		this.path = path;
	}

	public String getClassName()
	{
		return className;
	}

	public String getPackageName()
	{
		return packageName;
	}

	public String getParaList()
	{
		return paraList;
	}

	public String getPath()
	{
		return path;
	}

	@Override
	public int compareTo(ApiIndexElement o)
	{
		int cmp = this.className.compareTo(o.getClassName());
		if (cmp == 0)
		{
			if (this.path.equals(o.getPath()))
				return 0;
			return 1;
		}
		return cmp;
	}
}
