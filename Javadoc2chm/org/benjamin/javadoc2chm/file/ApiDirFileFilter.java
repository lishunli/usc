package org.benjamin.javadoc2chm.file;

import java.io.File;
import java.io.FileFilter;

import org.benjamin.javadoc2chm.Parameters;

public class ApiDirFileFilter implements FileFilter
{

	private boolean isRoot = true;

	private boolean rootAccept(File filename)
	{
		if (filename.isDirectory())
		{
			for (String dirName : Parameters._API_DIR_FILEFILTER)
			{
				if (filename.getName().equals(dirName))
					return false;
			}
			return true;
		} else
		{
			String name = filename.getName();
			for (String type : Parameters._API_FILETYPE)
			{
				if (name.endsWith(type))
				{
					for (String rootFile : Parameters._API_ROOT_FILEFILTER)
					{
						if (name.equals(rootFile))
							return false;
					}
					return true;
				}
			}
			return false;
		}
	}

	private boolean notRootAccept(File filename)
	{
		if (filename.isDirectory())
		{
			for (String dirName : Parameters._API_DIR_FILEFILTER)
			{
				if (filename.getName().equals(dirName))
					return false;
			}
			return true;
		} else
		{
			String name = filename.getName();
			for (String type : Parameters._API_FILETYPE)
			{
				if (name.endsWith(type))
				{
					for (String specFile : Parameters._API_CLASS_FILEFILTER)
					{
						if (name.equals(specFile))
							return false;
					}
					return true;
				}
			}
			return false;
		}
	}

	public void setIsRoot(boolean isRoot)
	{
		this.isRoot = isRoot;
	}

	public boolean accept(File pathname)
	{
		if (this.isRoot)
			return this.rootAccept(pathname);
		return this.notRootAccept(pathname);
	}
}
