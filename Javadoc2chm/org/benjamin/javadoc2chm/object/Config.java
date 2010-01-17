package org.benjamin.javadoc2chm.object;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.benjamin.javadoc2chm.exceptions.ConfigException;
import org.benjamin.javadoc2chm.util.FileUtils;

public final class Config
{

	protected File rootDir;

	private ArrayList<File> tocExcludeFiles;
	private ArrayList<File> apiDirs;

	public Config(File rootDir, File tocExcludeFile, File apiFile) throws ConfigException
	{
		this.rootDir = rootDir;
		if (!rootDir.exists())
			throw new ConfigException(new FileNotFoundException("'" + rootDir.getAbsolutePath() + "' is not exist."));

		this.initialize(tocExcludeFile, apiFile);
	}

	public Config(File rootDir) throws ConfigException
	{
		this(rootDir, null, null);
	}

	protected void initialize(File tocExcludeFile, File apiFile) throws ConfigException
	{
		this.tocExcludeFiles = FileUtils.readTocExcludeFiles(rootDir, tocExcludeFile);
		this.apiDirs = FileUtils.readApiDir(rootDir, apiFile);
	}

	public void reset(File tocExcludeFile, File apiFile) throws ConfigException
	{
		if (this.tocExcludeFiles != null)
			this.tocExcludeFiles.clear();
		if (this.apiDirs != null)
			this.apiDirs.clear();

		this.tocExcludeFiles = null;
		this.apiDirs = null;

		initialize(tocExcludeFile, apiFile);
	}

	public File getRootDir()
	{
		return rootDir;
	}

	public ArrayList<File> getTocExcludeFiles()
	{
		return tocExcludeFiles;
	}

	public ArrayList<File> getApiDirs()
	{
		return apiDirs;
	}

	public void appendTocExcludeFiles(File[] files)
	{
		if (files == null)
			return;

		if (tocExcludeFiles == null)
			tocExcludeFiles = new ArrayList<File>();
		for (File file : files)
		{
			tocExcludeFiles.add(file);
		}
	}

	public void appendApiDirs(File[] files)
	{
		if (files == null)
			return;

		if (apiDirs == null)
			apiDirs = new ArrayList<File>();
		for (File file : files)
		{
			apiDirs.add(file);
		}
	}

}
