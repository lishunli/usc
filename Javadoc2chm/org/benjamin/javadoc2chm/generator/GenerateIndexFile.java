package org.benjamin.javadoc2chm.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;

import org.benjamin.javadoc2chm.exceptions.GenerateHTMLException;
import org.benjamin.javadoc2chm.exceptions.ProcessException;
import org.benjamin.javadoc2chm.module.ProcessIndexFile;
import org.benjamin.javadoc2chm.object.ApiIndexMap;
import org.benjamin.javadoc2chm.object.ApiIndexElement;
import org.benjamin.javadoc2chm.object.Config;
import org.benjamin.javadoc2chm.util.FileUtils;
import org.benjamin.javadoc2chm.util.HTMLUtils;

public class GenerateIndexFile
{

	private Config config;
	private Pattern pattern;
	private File indexFile;
	private ApiIndexMap apiMap;

	public GenerateIndexFile(Config config, File indexFile, Pattern pattern, ApiIndexMap apiMap)
	{
		this.config = config;
		this.indexFile = indexFile;
		this.pattern = pattern;
		this.apiMap = apiMap;
	}

	public void generate() throws GenerateHTMLException
	{
		ArrayList<File> apiDir = config.getApiDirs();
		for (int i = 0; i < apiDir.size(); i++)
		{
			File curr = apiDir.get(i);
			File[] files = FileUtils.getIndexFileList(curr);
			try
			{
				new ProcessIndexFile(config.getRootDir(), curr, files, pattern, apiMap).process();
			} catch (ProcessException e)
			{
				System.err.println("Processing api dir '" + curr.getAbsolutePath() + "' error:" + e.getMessage());
			}
		}

		generateIndexAndRedirFiles(config.getRootDir(), indexFile);
	}

	public void generateIndexAndRedirFiles(File root, File indexFile) throws GenerateHTMLException
	{
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try
		{
			// indexFile.createNewFile();
			if (!indexFile.createNewFile() && !indexFile.exists())
				throw new GenerateHTMLException("File '" + indexFile.getAbsolutePath() + "' not existed.");
			File redirRoot = new File(root, "h2hh-redir");
			if (!redirRoot.mkdir() && !redirRoot.exists())
				throw new GenerateHTMLException("Dir '" + redirRoot.getAbsolutePath() + "' not exist.");

			// System.out.println("generating index and redir files.");

			fileWriter = new FileWriter(indexFile);
			bufferedWriter = new BufferedWriter(fileWriter);
			int count = 0;

			HTMLUtils.generateIndexHeader(bufferedWriter);
			HTMLUtils.generateULBegin(bufferedWriter);

			Iterator<String> it = apiMap.iterator();
			while (it.hasNext())
			{
				String key = it.next();
				Set<ApiIndexElement> set = apiMap.get(key);
				if (set == null)
					continue;
				if (set.size() == 1)
				{
					ApiIndexElement elem = set.iterator().next();
					String[] name = { key };
					HTMLUtils.generateIndexEntry(bufferedWriter, name, elem.getPath());
				} else
				{
					File file = new File(redirRoot, (++count) + ".html");
					// file.createNewFile();
					if (!file.createNewFile() && !file.exists())
						throw new GenerateHTMLException("Dir '" + file.getAbsolutePath() + "' not exist.");
					FileUtils.generateRedirFile(file, root, key, set);
					HTMLUtils.generateIndexEntry(bufferedWriter, new String[] { key }, FileUtils.getRelativePath(root, file));
				}
			}

			HTMLUtils.generateULEnd(bufferedWriter, 1);
			HTMLUtils.generateIndexFooter(bufferedWriter);

			System.out.println(count + " redir files generated.");
		} catch (IOException e)
		{
			throw new GenerateHTMLException(e);
		} finally
		{
			if (bufferedWriter != null)
				try
				{
					bufferedWriter.flush();
					bufferedWriter.close();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
