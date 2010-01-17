/**
 * 
 */
package org.benjamin.javadoc2chm.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.benjamin.javadoc2chm.ProjectDefaultFormat;
import org.benjamin.javadoc2chm.Parameters;
import org.benjamin.javadoc2chm.exceptions.ConfigException;
import org.benjamin.javadoc2chm.exceptions.GenerateHTMLException;
import org.benjamin.javadoc2chm.object.ApiIndexElement;

/**
 * @author benjamin
 * 
 */
public final class FileUtils
{

	public static ArrayList<File> readTocExcludeFiles(File rootDir, File tocExcludeFile) throws ConfigException
	{
		if (rootDir == null || tocExcludeFile == null)
			return null;

		FileReader fileReader;
		BufferedReader bufferedReader = null;
		ArrayList<File> files = null;
		try
		{
			fileReader = new FileReader(tocExcludeFile);
			bufferedReader = new BufferedReader(fileReader);

			files = new ArrayList<File>();
			String line = bufferedReader.readLine();
			while (line != null)
			{
				files.add(new File(rootDir, line));
				line = bufferedReader.readLine();
			}
		} catch (FileNotFoundException e)
		{
			throw new ConfigException(e);
		} catch (IOException e)
		{
			throw new ConfigException(e);
		} finally
		{
			if (bufferedReader != null)
				try
				{
					bufferedReader.close();
				} catch (IOException e)
				{
					throw new ConfigException(e);
				}
		}

		return files;
	}

	public static ArrayList<File> readApiDir(File rootDir, File apiFile) throws ConfigException
	{
		if (rootDir == null || apiFile == null)
			return null;

		FileReader fileReader;
		BufferedReader bufferedReader = null;
		ArrayList<File> files = null;
		try
		{
			fileReader = new FileReader(apiFile);
			bufferedReader = new BufferedReader(fileReader);

			files = new ArrayList<File>();
			String line = bufferedReader.readLine();
			while (line != null)
			{
				files.add(new File(rootDir, line));
				line = bufferedReader.readLine();
			}

		} catch (FileNotFoundException e)
		{
			throw new ConfigException(e);
		} catch (IOException e)
		{
			throw new ConfigException(e);
		} finally
		{
			if (bufferedReader != null)
				try
				{
					bufferedReader.close();
				} catch (IOException e)
				{
					throw new ConfigException(e);
				}
		}

		return files;
	}

	/**
	 * 
	 * @param parent
	 * @param marker
	 *            a dir that contains marker file will be considered as a API dir
	 * @return
	 */
	public static ArrayList<File> getAPIRootDir(File parent, String marker)
	{
		if (!parent.exists() || !parent.isDirectory())
			return null;
		File[] files = parent.listFiles();
		if (files == null)
			return null;

		ArrayList<File> list = new ArrayList<File>();
		for (File file : files)
		{
			if (file.isDirectory())
			{
				ArrayList<File> arrayList = getAPIRootDir(file, marker);
				if (arrayList != null)
					list.addAll(arrayList);
			} else if (file.getName().endsWith(marker))
				list.add(parent);
		}

		return list;
	}

	public static String getTitle(File file)
	{
		if (file == null)
			return "";

		FileReader fin;
		BufferedReader bin = null;
		String title = file.getName();
		try
		{
			Pattern pattern = Pattern.compile(Parameters._TITLE_PATTERN, Pattern.CASE_INSENSITIVE);

			fin = new FileReader(file);
			bin = new BufferedReader(fin);

			StringBuffer buff = new StringBuffer();
			String line = bin.readLine();
			while (line != null)
			{
				buff.append(line);
				String source = buff.toString();
				Matcher matcher = pattern.matcher(source);
				if (matcher.find(0))
				{
					title = matcher.group(1);
					break;
				}
				line = bin.readLine();
			}
		} catch (FileNotFoundException e)
		{
			// TODO
		} catch (IOException e)
		{
			// TODO
		} finally
		{
			if (bin != null)
				try
				{
					bin.close();
				} catch (IOException e)
				{
					// e.printStackTrace();
					// TODO
				}
		}

		return title;
	}

	/**
	 * 
	 * @param index_root
	 * @return null, if index root is not a directory
	 */
	public static File[] getIndexFileList(File parent)
	{
		if (!parent.isDirectory())
			return null;

		File indexDir = new File(parent, Parameters.APIDirectory._INDEX_DIR);
		if (indexDir.exists() && indexDir.isDirectory())
		{
			int count = 0;
			Vector<File> collect = new Vector<File>();
			while (true)
			{
				count++;
				String filename = "index-" + count + Parameters._FILE_TYPE;
				File index_file = new File(indexDir, filename);
				if (index_file.exists() && index_file.canRead())
				{
					collect.add(index_file);
					continue;
				}
				break;
			}
			File[] result = new File[collect.size()];
			collect.toArray(result);
			return result;
		} else
		{
			File file = new File(parent, "index-all.html");
			if (file.exists())
				return new File[] { file };
			else
				return null;
		}
	}

	/**
	 * 
	 * @param root
	 * @param file
	 * @return
	 */
	public static String getRelativePath(File root, File file)
	{
		try
		{
			String rootPath = root.getCanonicalPath().replace('\\', '/');
			String filePath = file.getCanonicalPath().replace('\\', '/');
			if (filePath.startsWith(rootPath))
				return filePath.substring(rootPath.length() + 1);
			else
				return filePath;
		} catch (IOException e)
		{
			/*
			 * thrown when the path is TOO long
			 */
			String filePath = file.getAbsolutePath();
			int mark = filePath.indexOf('#');
			if (mark < 0)
			{
				/*
				 * oops! I cannot handle this either
				 */
				e.printStackTrace();
				return null;
			} else
			{
				try
				{
					String rootPath = root.getCanonicalPath().replace('\\', '/');
					String newFilePath = new File(filePath.substring(0, mark)).getCanonicalPath().replace('\\', '/');

					if (newFilePath.startsWith(rootPath))
						return newFilePath.substring(rootPath.length() + 1) + filePath.substring(mark);
					else
						return newFilePath + filePath.substring(mark);
				} catch (IOException e2)
				{
					/*
					 * thrown when the path is STILL TOO long but we could not meet this situation
					 */
					e2.printStackTrace();
					return null;
				}
			}
		}
		// return root.toURI().relativize(file.toURI()).normalize().toString();
	}

	/**
	 * 
	 * @param file
	 * @return
	 */
	public static boolean isClassUseDir(File file)
	{
		return file.getName().contains(Parameters.APIDirectory._CLASS_USE);
	}

	public static boolean isGeneratedFile(String filename)
	{
		return filename.equals(Parameters.Project + ProjectDefaultFormat._CONTENT_TYPE)
				|| filename.equals(Parameters.Project + ProjectDefaultFormat._INDEX_TYPE)
				|| filename.equals(Parameters.Project + ProjectDefaultFormat._PROJECT_TYPE);
	}

	/**
	 * 
	 * @param file
	 * @param root
	 * @param fieldName
	 * @param set
	 * @throws GenerateHTMLException
	 */
	public static void generateRedirFile(File file, File root, String fieldName, Set<ApiIndexElement> set) throws GenerateHTMLException
	{
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try
		{
			fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);

			HTMLUtils.generateRedirFileHeader(bufferedWriter, fieldName);
			Iterator<ApiIndexElement> it = set.iterator();

			while (it.hasNext())
			{
				ApiIndexElement elem = it.next();
				String path = elem.getPath();

				if (fieldName.equals(elem.getClassName()))
					HTMLUtils.generateRedirFileEntry(bufferedWriter, path, elem.getPackageName(), fieldName, elem.getParaList());
				else
					HTMLUtils.generateRedirFileEntry(bufferedWriter, path, elem.getPackageName() + "." + elem.getClassName(), fieldName, elem.getParaList());
			}

			HTMLUtils.generateRedirFileFooter(bufferedWriter);

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
					// TODO
				}
		}
	}
}
