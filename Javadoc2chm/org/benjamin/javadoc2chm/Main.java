package org.benjamin.javadoc2chm;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.regex.Pattern;

import org.benjamin.javadoc2chm.exceptions.ConfigException;
import org.benjamin.javadoc2chm.exceptions.GenerateHTMLException;

import org.benjamin.javadoc2chm.file.TocFileFilter;
import org.benjamin.javadoc2chm.generator.GenerateIndexFile;
import org.benjamin.javadoc2chm.generator.GenerateProjectFile;
import org.benjamin.javadoc2chm.generator.GenerateTocFile;
import org.benjamin.javadoc2chm.object.ApiIndexMap;
import org.benjamin.javadoc2chm.object.Config;
import org.benjamin.javadoc2chm.util.FileUtils;

public class Main
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		try
		{
			File root = new File(Parameters._ROOT);
			File projectFile = new File(root, Parameters.Project + ProjectDefaultFormat._PROJECT_TYPE);
			File tocFile = new File(root, Parameters.Project + ProjectDefaultFormat._CONTENT_TYPE);
			File indexFile = new File(root, Parameters.Project + ProjectDefaultFormat._INDEX_TYPE);

			Pattern indexPattern = Pattern.compile(Parameters._INDEX_PATTERN, Pattern.CASE_INSENSITIVE);
			Pattern tocPattern = Pattern.compile(Parameters._CONTEXT_PATTERN, Pattern.CASE_INSENSITIVE);
			/*
			 * 
			 */
			System.out.println("Reading Config...");
			Config config = new Config(root, new File(Parameters.SysFile._FORBIDDEN_FILE), new File(Parameters.SysFile._APIDIR_FILE));

			/*
			 * 
			 */
			if (config.getApiDirs() == null)
			{
				ArrayList<File> files = FileUtils.getAPIRootDir(root, Parameters.APIFile._OVERVIEW_TREE);
				config.getApiDirs().addAll(files);
			}

			config.appendTocExcludeFiles(Parameters._TOC_EXCLUDE_SYS_FILES);

			// File projectFile = new File(JavaDocModel.Project + ChmProjectFormat._PROJECT_TYPE);
			// File contentFile = new File();
			// File indexFile = new File(root, JavaDocModel.Project + ChmProjectFormat._INDEX_TYPE);
			FileFilter tocFileFilter = new TocFileFilter(Parameters._ACCEPT_FILETYPE);
			System.out.println("Generating '" + tocFile.getName() + "'");
			GenerateTocFile generateTocFile = new GenerateTocFile(config, tocPattern, Parameters.Title, tocFile, tocFileFilter, ApiIndexMap.getInstance());
			generateTocFile.generate();

			System.out.println("Generating '" + indexFile.getName() + "'");
			GenerateIndexFile generateIndexFile = new GenerateIndexFile(config, indexFile, indexPattern, ApiIndexMap.getInstance());
			generateIndexFile.generate();

			System.out.println("Generating '" + projectFile.getName() + "'");
			GenerateProjectFile generateProject = new GenerateProjectFile(config, projectFile);
			generateProject.generate();

			/**
			 * finialize
			 */
			System.out.print("Clean...");
			ApiIndexMap.getInstance().clear();
			System.out.println("All Done");
		} catch (ConfigException e)
		{
			e.printStackTrace();
		} catch (GenerateHTMLException e)
		{
			e.printStackTrace();
		}
	}
}
