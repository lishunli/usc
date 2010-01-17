package org.benjamin.javadoc2chm.file;

import java.io.File;
import java.io.FileFilter;

public final class TocFileFilter implements FileFilter
{

	private String[] acceptType;

	public TocFileFilter(String[] filter)
	{
		super();
		this.acceptType = filter;
	}

	public boolean accept(File pathname)
	{
		if (pathname.isDirectory())
			return true;
		for (String type : this.acceptType)
		{
			if (pathname.getName().endsWith(type))
				return true;
		}
		return false;
	}
}
