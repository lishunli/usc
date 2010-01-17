package org.benjamin.javadoc2chm.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.benjamin.javadoc2chm.exceptions.GenerateHTMLException;
import org.benjamin.javadoc2chm.object.Config;
import org.benjamin.javadoc2chm.util.HTMLUtils;

public class GenerateProjectFile
{

	private Config config;
	private File proFile;
	private BufferedWriter bout;

	public GenerateProjectFile(Config config, File proFile)
	{
		this.config = config;
		this.proFile = proFile;
	}

	public void generate() throws GenerateHTMLException
	{
		if (!config.getRootDir().exists())
			return;

		try
		{
			if (!proFile.createNewFile() && !proFile.exists())
				throw new GenerateHTMLException("Dile '" + proFile.getAbsolutePath() + "' not existed.");
			FileWriter fileWriter = new FileWriter(this.proFile);
			this.bout = new BufferedWriter(fileWriter);

			HTMLUtils.generateProjectCompileOptionsSection(bout);
			HTMLUtils.generateProjectFileSection(bout, config.getRootDir());
			HTMLUtils.generateProjectInfoSection(bout);

		} catch (IOException e)
		{
			throw new GenerateHTMLException(e);
		} finally
		{
			if (bout != null)
				try
				{
					bout.flush();
					bout.close();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

	}

}
