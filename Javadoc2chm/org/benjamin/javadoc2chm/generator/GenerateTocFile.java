package org.benjamin.javadoc2chm.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

import org.benjamin.javadoc2chm.exceptions.GenerateHTMLException;
import org.benjamin.javadoc2chm.exceptions.ProcessException;
import org.benjamin.javadoc2chm.module.ProcessApiDir;
import org.benjamin.javadoc2chm.object.ApiIndexMap;
import org.benjamin.javadoc2chm.object.Config;
import org.benjamin.javadoc2chm.util.FileUtils;
import org.benjamin.javadoc2chm.util.HTMLUtils;

public class GenerateTocFile
{

	private String title;
	private Pattern pattern;
	private Config config;
	private File contentFile;
	private BufferedWriter bout;
	private FileFilter tocFileFilter;
	private ApiIndexMap apiMap;

	public GenerateTocFile(Config config, Pattern pattern, String title, File tocFile, FileFilter tocFileFilter, ApiIndexMap apiMap)
	{
		this.title = title;
		this.pattern = pattern;
		this.config = config;
		this.tocFileFilter = tocFileFilter;
		this.contentFile = tocFile;
		this.apiMap = apiMap;
	}

	private boolean isApiDir(File file)
	{
		for (File dir : config.getApiDirs())
		{
			if (file.equals(dir))
				return true;
		}
		return false;
	}

	private boolean isExcluded(File file)
	{
		for (File dir : config.getTocExcludeFiles())
		{
			if (file.equals(dir))
				return true;
		}
		return false;
	}

	private void find(File parent) throws GenerateHTMLException
	{
		if (parent.isDirectory())
		{
			if (this.isApiDir(parent))
			{

				HTMLUtils.generateTocEntry(bout, parent.getName(), 1);
				HTMLUtils.generateULBegin(bout);

				// System.out.println("API dir: " + parent.getAbsolutePath());

				File[] indexfiles = FileUtils.getIndexFileList(parent);
				boolean isAddEntry = (indexfiles == null) ? true : false;

				try
				{
					new ProcessApiDir(bout, config.getRootDir(), parent, indexfiles, pattern, isAddEntry, apiMap).process();
				} catch (ProcessException e)
				{
					System.err.println("Processing file '" + parent.getAbsolutePath() + "' error:" + e.getMessage());
				}

				HTMLUtils.generateULEnd(bout, 1);
			} else if (!this.isExcluded(parent))
			{
				// System.out.println("accessing dir: " + parent.getAbsolutePath());

				File[] files = parent.listFiles(tocFileFilter);
				if (files == null || files.length == 0)
					return;

				HTMLUtils.generateTocEntry(bout, parent.getName(), 1);
				HTMLUtils.generateULBegin(bout);

				for (File file : files)
					this.find(file);

				HTMLUtils.generateULEnd(bout, 1);
			} else
			{
				// DO Nothing
				// System.out.println("exclude dir: " + parent.getAbsolutePath());
			}
		} else
		{
			if (!isExcluded(parent))
			{
				// System.out.println("accessing file: " + parent.getAbsolutePath());
				String title = FileUtils.getTitle(parent);
				if (title == null || title.equals(""))
					title = parent.getName();
				HTMLUtils.generateTocLocalEntry(bout, title, FileUtils.getRelativePath(config.getRootDir(), parent), 11);
			} else
			{
				// DO Nothing
				// System.out.println("exclude file: " + parent.getAbsolutePath());
			}
		}
	}

	public void generate() throws GenerateHTMLException
	{
		try
		{
			if (!contentFile.createNewFile() && !contentFile.exists())
				throw new GenerateHTMLException("File '" + contentFile.getAbsolutePath() + "' not existed.");

			this.bout = new BufferedWriter(new FileWriter(contentFile));

			HTMLUtils.generateTocHeader(this.bout);
			HTMLUtils.generateTocEntry(this.bout, title, 1);
			HTMLUtils.generateULBegin(this.bout);

			File[] files = config.getRootDir().listFiles(tocFileFilter);
			if (files != null)
				for (File file : files)
				{
					this.find(file);
				}
			HTMLUtils.generateULEnd(this.bout, 1);
			HTMLUtils.generateTocFooter(this.bout);

		} catch (IOException e)
		{
			throw new GenerateHTMLException(e);
		} finally
		{
			if (this.bout != null)
			{
				try
				{
					this.bout.flush();
					this.bout.close();
				} catch (IOException e)
				{
					throw new GenerateHTMLException(e);
				}
			}
		}
	}
}
