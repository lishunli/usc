package org.benjamin.javadoc2chm.module;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.benjamin.javadoc2chm.exceptions.ProcessException;
import org.benjamin.javadoc2chm.object.ApiIndexMap;
import org.benjamin.javadoc2chm.util.FileUtils;

public class ProcessIndexFile
{

	/*
	 * define reference final variables
	 */
	private Pattern pattern;
	private File root;
	private File currApiDir;
	private File[] indexFileList;
	private ApiIndexMap apiMap;

	public ProcessIndexFile(File root, File currApiDir, File[] indexFileList, Pattern pattern, ApiIndexMap apiMap)
	{
		this.root = root;
		this.currApiDir = currApiDir;
		this.indexFileList = indexFileList;
		this.pattern = pattern;
		this.apiMap = apiMap;
	}

	public void process() throws ProcessException
	{
		if (this.indexFileList == null)
			return;
		for (int i = 0; i < this.indexFileList.length; i++)
			this.findIndexMarkers(this.indexFileList[i], this.currApiDir);
	}

	private void findIndexMarkers(File indexFile, File apiDir) throws ProcessException
	{
		if (!indexFile.exists())
			return;

		FileReader fread = null;
		BufferedReader bread = null;
		try
		{
			/**
			 * get index files' content
			 */

			fread = new FileReader(indexFile);
			bread = new BufferedReader(fread);

			StringBuffer sbuff = new StringBuffer();
			String line = bread.readLine();
			while (line != null)
			{
				sbuff.append(line);
				line = bread.readLine();
			}
			String context = sbuff.toString();

			/**
			 * begin analysis
			 */
			Matcher matcher = pattern.matcher(context);
			while (matcher.find())
			{
				String g3 = matcher.group(3);
				String g1 = matcher.group(1);

				File actualFile = new File(indexFile.getParent(), g1);
				String normalPath = FileUtils.getRelativePath(apiDir, actualFile);
				int end = normalPath.indexOf('#');

				String cpackage = null;
				if (end < 0)
					cpackage = normalPath;
				else
					cpackage = normalPath.substring(0, end);

				String fullName = cpackage.substring(0, cpackage.lastIndexOf(".htm")).replace('/', '.');

				int mark = fullName.lastIndexOf('.');
				if (mark < 0)
					continue;
				String packageName = fullName.substring(0, mark);
				String className = fullName.substring(mark + 1);
				String paraList = "";
				String fieldName = null;
				mark = g3.indexOf('(');
				if (mark < 0)
					fieldName = g3;
				else
				{
					fieldName = g3.substring(0, mark);
					paraList = g3.substring(mark);
				}

				String path = FileUtils.getRelativePath(root, actualFile);
				apiMap.insertNode(fieldName, className, packageName, paraList, path);
			}
		} catch (FileNotFoundException e)
		{
			throw new ProcessException(e);
		} catch (IOException e)
		{
			throw new ProcessException(e);
		} finally
		{
			if (bread != null)
				try
				{
					bread.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
		}

	}

}
