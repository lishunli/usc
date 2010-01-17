package org.benjamin.javadoc2chm.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.benjamin.javadoc2chm.ProjectDefaultFormat;
import org.benjamin.javadoc2chm.Parameters;
import org.benjamin.javadoc2chm.exceptions.GenerateHTMLException;

public final class HTMLUtils
{

	/**
	 * generate .hhc file content element: \
	 * <UL\>
	 * 
	 * @param bout
	 * @throws GenerateHTMLException
	 */
	public static void generateULBegin(BufferedWriter bout) throws GenerateHTMLException
	{
		try
		{
			bout.write(ProjectDefaultFormat.HTMLFormat._UL_HEAD + Parameters._NEWLINE);
		} catch (IOException e)
		{
			throw new GenerateHTMLException(e);
		}
	}

	/**
	 * generate .hhc file content element: \</UL\>
	 * 
	 * @param bout
	 * @param count
	 * @throws GenerateHTMLException
	 */
	public static void generateULEnd(BufferedWriter bout, int count) throws GenerateHTMLException
	{
		String content = "";
		if (count == 0)
			return;
		while (count-- != 0)
			content += ProjectDefaultFormat.HTMLFormat._UL_TAIL;
		try
		{
			bout.write(content + Parameters._NEWLINE);
		} catch (IOException e)
		{
			throw new GenerateHTMLException(e);
		}
	}

	/**
	 * generate .hhc file header
	 * 
	 * @param bout
	 * @throws GenerateHTMLException
	 */
	public static void generateTocHeader(BufferedWriter bout) throws GenerateHTMLException
	{
		try
		{
			bout.write("<!DOCTYPE HTML PUBLIC \"-//IETF//DTD HTML//EN\">" + Parameters._NEWLINE);
			bout.write("<HTML><BODY>" + Parameters._NEWLINE);
			bout.write("<OBJECT type=\"text/site properties\">" + Parameters._NEWLINE);
			bout.write("<param name=\"FrameName\" value=\"right\">" + Parameters._NEWLINE);
			bout.write("<param name=\"Background\" value=\"0xffffff\">" + Parameters._NEWLINE);
			bout.write("<param name=\"Foreground\" value=\"0x80000008\">" + Parameters._NEWLINE);
			bout.write("<param name=\"Window Styles\" value=\"0x627\">" + Parameters._NEWLINE);
			bout.write("<param name=\"ImageType\" value=\"Folder\">" + Parameters._NEWLINE);
			bout.write("<param name=\"Font\" value=\"MS Sans Serif,9,0\">" + Parameters._NEWLINE);
			bout.write("</OBJECT>" + Parameters._NEWLINE);
			generateULBegin(bout);
		} catch (Exception e)
		{
			throw new GenerateHTMLException(e);
		}
	}

	/**
	 * generate .hhc file tailer
	 * 
	 * @param bout
	 * @throws GenerateHTMLException
	 */
	public static void generateTocFooter(BufferedWriter bout) throws GenerateHTMLException
	{
		try
		{
			generateULEnd(bout, 1);
			bout.write("</BODY></HTML>" + Parameters._NEWLINE);
		} catch (Exception e)
		{
			throw new GenerateHTMLException(e);
		}
	}

	/**
	 * generate .hhc file content element: \<LI>\<OBJECT type="text/sitemap"\> \<param name="Name" value="name"\> \<param name="ImageNumber" value="value"\>
	 * \</OBJECT\>
	 * 
	 * @param bout
	 *            BufferedWriter Object
	 * @param name
	 *            name value
	 * @param i
	 *            image number value
	 * @throws GenerateHTMLException
	 */
	public static void generateTocEntry(BufferedWriter bout, String name, int i) throws GenerateHTMLException
	{
		try
		{
			bout.write(ProjectDefaultFormat.HTMLFormat._LI_HEAD + Parameters._NEWLINE);
			bout.write(String.format(ProjectDefaultFormat.HTMLFormat._PARAM_NAME, name) + Parameters._NEWLINE);
			bout.write(String.format(ProjectDefaultFormat.HTMLFormat._PARAM_IMAGE_NUMBER, i) + Parameters._NEWLINE);
			bout.write(ProjectDefaultFormat.HTMLFormat._LI_TAIL + Parameters._NEWLINE);
		} catch (IOException e)
		{
			throw new GenerateHTMLException(e);
		}
	}

	/**
	 * generate .hhc file content element: \<LI>\<OBJECT type="text/sitemap"\> \<param name="Name" value="name"\> \<param name="Local" value="value"\> \<param
	 * name="ImageNumber" value="value"\> \</OBJECT\>
	 * 
	 * @param bout
	 * @param name
	 * @param local
	 * @param i
	 * @throws GenerateHTMLException
	 */
	public static void generateTocLocalEntry(BufferedWriter bout, String name, String local, int i) throws GenerateHTMLException
	{
		try
		{
			bout.write(ProjectDefaultFormat.HTMLFormat._LI_HEAD + Parameters._NEWLINE);
			bout.write(String.format(ProjectDefaultFormat.HTMLFormat._PARAM_NAME, name) + Parameters._NEWLINE);
			bout.write(String.format(ProjectDefaultFormat.HTMLFormat._PARAM_LOCAL, local) + Parameters._NEWLINE);
			bout.write(String.format(ProjectDefaultFormat.HTMLFormat._PARAM_IMAGE_NUMBER, i) + Parameters._NEWLINE);
			bout.write(ProjectDefaultFormat.HTMLFormat._LI_TAIL + Parameters._NEWLINE);
		} catch (IOException e)
		{
			throw new GenerateHTMLException(e);
		}
	}

	/**
	 * Generate "Index", "Overview", "All Classes", "API Help", "Constant Field Values", "Deprecated List", "Class Hierarchy", "Serialized Form"
	 * 
	 * @param bout
	 * @param parent
	 * @param root
	 * @throws GenerateHTMLException
	 */
	public static void generateTocApiDefaultSection(BufferedWriter bout, File parent, File root) throws GenerateHTMLException
	{
		for (int i = 0; i < Parameters.APIFile._defaultList.length; i++)
		{
			File file = new File(parent, Parameters.APIFile._defaultList[i]);
			if (file.exists())
				generateTocLocalEntry(bout, Parameters.APIFile._defaultName[i], FileUtils.getRelativePath(root, file), 11);
		}
	}

	/**
	 * generate "index-files" etc. Index Section
	 * 
	 * @param bout
	 * @param indexFiles
	 * @param root
	 * @throws GenerateHTMLException
	 */
	public static void generateTocApiIndexFileSection(BufferedWriter bout, File[] indexFiles, File root) throws GenerateHTMLException
	{
		if (indexFiles != null)
		{
			generateTocEntry(bout, "index-files", 1);
			generateULBegin(bout);

			int count = 0;
			for (File index_file : indexFiles)
			{

				String title = FileUtils.getTitle(index_file);
				if (title == null || title.equals(""))
					title = (++count) + "-Index";

				generateTocLocalEntry(bout, title, FileUtils.getRelativePath(root, index_file), 11);
			}
			generateULEnd(bout, 1);
		}
	}

	/**
	 * generate such as "java.utils", "java.utils Class Hierarchy", "Uses of Package java.utils"
	 * 
	 * @param bout
	 * @param currDir
	 * @param parent
	 * @param root
	 * @throws GenerateHTMLException
	 */
	public static void generateTocApiPackageDefaultSection(BufferedWriter bout, File currDir, File parent, File root) throws GenerateHTMLException
	{
		String packageName = null;

		/*
		 * formate package name
		 */
		if (currDir == parent)
			packageName = "default package";
		else
		{
			// packageName = parent.getCanonicalPath().substring(
			// this.parent.getCanonicalPath().length() + 1).replace(
			// '\\', '.');
			packageName = FileUtils.getRelativePath(parent, currDir);
			if (packageName.indexOf("\\") > 0)
				packageName = packageName.replace('\\', '.');
			else
				packageName = packageName.replace('/', '.');
		}

		if (packageName.endsWith("."))
			packageName = packageName.substring(0, packageName.length() - 1);

		/*
		 * generate HTML section
		 */
		File file = new File(currDir, Parameters.APIFile._PACKAGE_SUMMARY);
		if (file.exists())
			generateTocLocalEntry(bout, packageName, FileUtils.getRelativePath(root, file), 11);

		file = new File(currDir, Parameters.APIFile._PACKAGE_TREE);
		if (file.exists())
			generateTocLocalEntry(bout, packageName + " Class Hierarchy", FileUtils.getRelativePath(root, file), 11);

		file = new File(currDir, Parameters.APIFile._PACKAGE_USE);
		if (file.exists())
			generateTocLocalEntry(bout, "Uses of Package " + packageName, FileUtils.getRelativePath(root, file), 11);
	}

	/**
	 * generate package "class-use" section
	 * 
	 * @param bout
	 * @param currDir
	 * @param parent
	 * @param root
	 * @throws GenerateHTMLException
	 */
	public static void generateTocApiPackageClassUseSection(BufferedWriter bout, File currDir, File parent, File root, FileFilter fileFilter)
			throws GenerateHTMLException
	{
		File clsUseDir = new File(currDir, Parameters.APIDirectory._CLASS_USE);
		if (!clsUseDir.exists())
			return;

		generateTocEntry(bout, Parameters.APIDirectory._CLASS_USE, 1);
		generateULBegin(bout);

		String preName = "";
		if (currDir != parent)
			// preName = parent.getCanonicalPath().substring(
			// this.parent.getCanonicalPath().length() + 1).replace(
			// '\\', '.');
			preName = FileUtils.getRelativePath(parent, currDir).replace('\\', '.');
		if (preName.endsWith("."))
			preName = preName.substring(0, preName.length() - 1);

		File[] files = clsUseDir.listFiles(fileFilter);
		for (File subfile : files)
		{
			String filename = subfile.getName();
			String className = preName + "." + filename.substring(0, filename.lastIndexOf("."));
			generateTocLocalEntry(bout, "Use of Class " + className, FileUtils.getRelativePath(root, subfile), 11);
		}
		generateULEnd(bout, 1);
	}

	/**
	 * generate .hhk file content element: \<LI>\<OBJECT type="text/sitemap"\> \<param name="Name" value="name"\> \<param name="Local" value="value"\>
	 * \</OBJECT\>
	 * 
	 * @param bout
	 * @param name
	 * @param local
	 */
	public static void generateIndexEntry(BufferedWriter bout, String[] name, String local) throws GenerateHTMLException
	{
		try
		{
			bout.write("\t" + ProjectDefaultFormat.HTMLFormat._LI_HEAD + Parameters._NEWLINE);
			if (name != null)
				for (String value : name)
					bout.write("\t" + String.format(ProjectDefaultFormat.HTMLFormat._PARAM_NAME, value) + Parameters._NEWLINE);
			bout.write("\t" + String.format(ProjectDefaultFormat.HTMLFormat._PARAM_LOCAL, local) + Parameters._NEWLINE);
			bout.write("\t" + ProjectDefaultFormat.HTMLFormat._LI_TAIL + Parameters._NEWLINE);
		} catch (IOException e)
		{
			throw new GenerateHTMLException(e);
		}
	}

	/**
	 * generate .hhk file header
	 * 
	 * @param bout
	 */
	public static void generateIndexHeader(BufferedWriter bout) throws GenerateHTMLException
	{
		try
		{
			bout.write("<!DOCTYPE HTML PUBLIC \"-//IETF//DTD HTML//EN\">" + Parameters._NEWLINE);
			bout.write("<HTML><BODY>" + Parameters._NEWLINE);
		} catch (IOException e)
		{
			throw new GenerateHTMLException(e);
		}
	}

	/**
	 * generate .hhk file tailer
	 * 
	 * @param bout
	 */
	public static void generateIndexFooter(BufferedWriter bout) throws GenerateHTMLException
	{
		try
		{
			bout.write("</BODY></HTML>" + Parameters._NEWLINE);
		} catch (IOException e)
		{
			throw new GenerateHTMLException(e);
		}
	}

	/**
	 * 
	 * @param bout
	 * @param name
	 * @throws GenerateHTMLException
	 */
	public static void generateRedirFileHeader(BufferedWriter bout, String name) throws GenerateHTMLException
	{
		try
		{
			bout.write("<html><head>" + Parameters._NEWLINE);
			bout.write("<title>Occurences of " + name + "</title>" + Parameters._NEWLINE);
			bout.write("</head><body style='{font-family:Verdana,Arial; font-size:10pt; }'>" + Parameters._NEWLINE);
			bout.write("<dl>" + Parameters._NEWLINE);
			bout.write("<dt><b>" + name + "</b> found in:" + Parameters._NEWLINE);
		} catch (IOException e)
		{
			throw new GenerateHTMLException(e);
		}
	}

	/**
	 * 
	 * @param bout
	 * @throws GenerateHTMLException
	 */
	public static void generateRedirFileFooter(BufferedWriter bout) throws GenerateHTMLException
	{
		try
		{
			bout.write("</dl></body></html>" + Parameters._NEWLINE);
		} catch (IOException e)
		{
			throw new GenerateHTMLException(e);
		}
	}

	/**
	 * 
	 * @param bout
	 * @param path
	 * @param pg
	 * @param name
	 * @param paralist
	 * @throws GenerateHTMLException
	 */
	public static void generateRedirFileEntry(BufferedWriter bout, String path, String pg, String name, String paralist) throws GenerateHTMLException
	{
		try
		{
			String format = "<dd><a href=\"../" + path + "\">" + pg + ".<b>" + name + "</b>" + paralist + "</a></dd>";
			bout.write(format + Parameters._NEWLINE);
		} catch (IOException e)
		{
			throw new GenerateHTMLException(e);
		}
	}

	/**
	 * 
	 * @param bout
	 * @throws GenerateHTMLException
	 */
	public static void generateProjectCompileOptionsSection(BufferedWriter bout) throws GenerateHTMLException
	{
		try
		{
			bout.write(ProjectDefaultFormat._OPTION_SECTION + Parameters._NEWLINE);
			bout.write(ProjectDefaultFormat.OptionSection.Compatibility + Parameters._NEWLINE);
			bout.write(String.format(ProjectDefaultFormat.OptionSection.Compiled_File, Parameters.Project + ProjectDefaultFormat._CHM_TYPE)
					+ Parameters._NEWLINE);
			bout.write(String.format(ProjectDefaultFormat.OptionSection.Contents_File, Parameters.Project + ProjectDefaultFormat._CONTENT_TYPE)
					+ Parameters._NEWLINE);
			bout.write(ProjectDefaultFormat.OptionSection.Default_Window + Parameters._NEWLINE);
			bout.write(String.format(ProjectDefaultFormat.OptionSection.Default_topic, Parameters.Default_topic) + Parameters._NEWLINE);
			bout.write(String.format(ProjectDefaultFormat.OptionSection.Display_Compile_Progress, Parameters.Display_Compile_Progress) + Parameters._NEWLINE);
			bout.write(String.format(ProjectDefaultFormat.OptionSection.Full_Text_Search, Parameters.Full_Text_Search) + Parameters._NEWLINE);
			bout.write(String.format(ProjectDefaultFormat.OptionSection.Index_File, Parameters.Project + ProjectDefaultFormat._INDEX_TYPE)
					+ Parameters._NEWLINE);
			bout.write(String.format(ProjectDefaultFormat.OptionSection.Language, Parameters.Language) + Parameters._NEWLINE);
			bout.write(String.format(ProjectDefaultFormat.OptionSection.Title, Parameters.Title) + Parameters._NEWLINE);
			bout.write(String.format(ProjectDefaultFormat.OptionSection.CHI, Parameters.Create_CHI) + Parameters._NEWLINE);
			bout.newLine();
			/*
			 * generating windows-section context In this method, main-topic is defined the same as default-topic
			 */
			bout.write(ProjectDefaultFormat._WINDOWS_SECTION + Parameters._NEWLINE);
			bout.write(String.format(ProjectDefaultFormat.WindowsSection.Windows, new Object[] { Parameters.Title,
					Parameters.Project + ProjectDefaultFormat._CONTENT_TYPE, Parameters.Project + ProjectDefaultFormat._INDEX_TYPE, Parameters.Default_topic,
					Parameters.Default_topic })
					+ Parameters._NEWLINE);
			bout.newLine();
		} catch (FileNotFoundException e)
		{
			throw new GenerateHTMLException(e);
		} catch (IOException e)
		{
			throw new GenerateHTMLException(e);
		}
	}

	/**
	 * 
	 * @param bout
	 * @throws GenerateHTMLException
	 */
	public static void generateProjectInfoSection(BufferedWriter bout) throws GenerateHTMLException
	{
		try
		{
			bout.write(ProjectDefaultFormat._INFOTYPES_SECTION + Parameters._NEWLINE);
			bout.newLine();
		} catch (FileNotFoundException e)
		{
			throw new GenerateHTMLException(e);
		} catch (IOException e)
		{
			throw new GenerateHTMLException(e);
		}
	}

	public static void generateProjectFileSection(BufferedWriter bout, File root) throws GenerateHTMLException
	{
		try
		{
			bout.write(ProjectDefaultFormat._FILES_SECTION + Parameters._NEWLINE);
			bout.newLine();
		} catch (IOException e)
		{
			throw new GenerateHTMLException(e);
		}

		File[] files = root.listFiles();
		if (files == null || files.length == 0)
			return;

		for (File file : files)
		{
			if (file.isDirectory())
				generateProjectFileSection(root, file, bout);
			else
			{
				if (!FileUtils.isGeneratedFile(file.getName()))
				{
					try
					{
						bout.write(FileUtils.getRelativePath(root, file));
						bout.newLine();
					} catch (IOException e)
					{
						throw new GenerateHTMLException(e);
					}
				}
			}
		}
	}

	public static void generateProjectFileSection(File root, File parent, BufferedWriter bout) throws GenerateHTMLException
	{
		File[] files = parent.listFiles();
		if (files == null || files.length == 0)
			return;

		for (File file : files)
		{
			if (file.isDirectory())
				generateProjectFileSection(root, file, bout);
			else
			{
				try
				{
					bout.write(FileUtils.getRelativePath(root, file));
					bout.newLine();
				} catch (IOException e)
				{
					throw new GenerateHTMLException(e);
				}
			}
		}
	}
}
