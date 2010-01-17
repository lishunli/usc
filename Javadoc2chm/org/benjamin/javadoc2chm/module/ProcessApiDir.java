package org.benjamin.javadoc2chm.module;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.benjamin.javadoc2chm.exceptions.GenerateHTMLException;
import org.benjamin.javadoc2chm.exceptions.ProcessException;
import org.benjamin.javadoc2chm.file.ApiDirFileFilter;
import org.benjamin.javadoc2chm.object.ApiIndexMap;
import org.benjamin.javadoc2chm.util.FileUtils;
import org.benjamin.javadoc2chm.util.HTMLUtils;

public class ProcessApiDir
{

	private BufferedWriter bout;
	private ApiDirFileFilter filefilter;
	private File root;
	private File parent;
	private File[] indexFileList;
	private Pattern pattern;
	private boolean isAddIndexEntry;
	private ApiIndexMap apiMap;

	public ProcessApiDir(BufferedWriter bout, File root, File parent, File[] indexFileList, Pattern pattern, boolean isAddIndexEntry, ApiIndexMap apiMap)
	{
		this.root = root;
		this.parent = parent;
		this.bout = bout;
		this.filefilter = new ApiDirFileFilter();
		this.indexFileList = indexFileList;
		this.pattern = pattern;
		this.isAddIndexEntry = isAddIndexEntry;
		this.apiMap = apiMap;
	}

	public void process() throws GenerateHTMLException, ProcessException
	{
		if (!parent.isDirectory())
			return;

		/**
		 * begin to analyze and generate files
		 */
		HTMLUtils.generateTocApiDefaultSection(bout, parent, root);
		HTMLUtils.generateTocApiIndexFileSection(bout, indexFileList, root);

		boolean isClassUse = false;
		boolean isSpecEntry = false;
		File[] files = parent.listFiles(new ApiDirFileFilter());
		Vector<File> dir = new Vector<File>();
		for (File subfile : files)
		{
			if (subfile.isDirectory())
			{
				if (FileUtils.isClassUseDir(subfile))
					isClassUse = true;
				else
					dir.add(subfile);
				continue;
			}

			if (!isSpecEntry)
			{
				isSpecEntry = true;
				HTMLUtils.generateTocApiPackageDefaultSection(bout, parent, parent, root);
			}
			analyzeClassFile(subfile);
		}

		if (isClassUse)
			HTMLUtils.generateTocApiPackageClassUseSection(bout, parent, parent, root, filefilter);

		Iterator<File> it = dir.iterator();
		while (it.hasNext())
		{
			File element = (File) it.next();
			process(element);
		}
	}

	private void process(File file) throws GenerateHTMLException, ProcessException
	{
		boolean isClassUse = false;
		boolean isSpecEntry = false;
		HTMLUtils.generateTocEntry(bout, file.getName(), 1);
		HTMLUtils.generateULBegin(bout);

		this.filefilter.setIsRoot(false);
		File[] files = file.listFiles(this.filefilter);
		Vector<File> dir = new Vector<File>();
		for (File subfile : files)
		{
			if (subfile.isDirectory())
			{
				if (FileUtils.isClassUseDir(subfile))
					isClassUse = true;
				else
					dir.add(subfile);
				continue;
			}
			if (!isSpecEntry)
			{
				isSpecEntry = true;
				HTMLUtils.generateTocApiPackageDefaultSection(bout, file, parent, root);
			}
			analyzeClassFile(subfile);
		}

		if (isClassUse)
			HTMLUtils.generateTocApiPackageClassUseSection(bout, file, parent, root, filefilter);

		Iterator<File> it = dir.iterator();
		while (it.hasNext())
		{
			File element = (File) it.next();
			process(element);
		}

		HTMLUtils.generateULEnd(bout, 1);
	}

	private void analyzeClassFile(File file) throws GenerateHTMLException, ProcessException
	{
		String fileName = file.getName();
		String className = fileName.substring(0, fileName.lastIndexOf("."));
		String location = FileUtils.getRelativePath(root, file);

		StringBuffer buff = null;
		FileReader fin = null;
		BufferedReader br = null;

		try
		{
			HTMLUtils.generateTocLocalEntry(bout, className, location, 1);
			HTMLUtils.generateULBegin(bout);

			fin = new FileReader(file);
			br = new BufferedReader(fin);
			buff = new StringBuffer();
			String line = br.readLine();
			while (line != null)
			{
				buff.append(line);
				line = br.readLine();
			}
		} catch (IOException e)
		{
			throw new ProcessException(e);
		} finally
		{
			if (br != null)
				try
				{
					br.close();
				} catch (IOException e)
				{
					// e.printStackTrace();
				}
		}

		String source = buff.toString();
		Matcher m = pattern.matcher(source);
		while (m.find())
		{
			String method = m.group(3);
			String path = location + "#" + method;
			HTMLUtils.generateTocLocalEntry(bout, method, path, 11);

			/**
			 * if add to index as an entry
			 */
			if (this.isAddIndexEntry)
			{
				String url = m.group(2).replaceAll("/", ".");
				int start = 0;
				while (url.charAt(start) == '.')
					start++;
				String fullName = url.substring(start, url.lastIndexOf('.'));
				String fieldName = method, paraList = "";
				int mark = method.indexOf('(');
				if (mark >= 0)
				{
					fieldName = method.substring(0, mark);
					paraList = method.substring(mark);
				}
				mark = fullName.lastIndexOf('.');
				String packageName = fullName.substring(0, mark);
				apiMap.insertNode(fieldName, className, packageName, paraList, path);
			}
		}
		HTMLUtils.generateULEnd(bout, 1);
	}
}
