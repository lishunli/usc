package org.usc.javautils.file;

import java.io.*;

import java.util.zip.*;

/** */
/**
 * 
 * 对文件或者目录操作的类
 * file and directory 创建 拷贝 删除 剪切 压缩还有解压缩(java.util.zip.*;)等常用操作 
 * 
 * @version 1.0
 * 
 * @author leno
 */

public class FileUtil
{

	private static void copy(File source, File target) throws IOException
	{

		File tar = new File(target, source.getName());

		if (source.isDirectory())
		{

			System.out.println("开始创建目录：" + tar.getPath());

			tar.mkdir();

			File[] fs = source.listFiles();

			for (int i = 0; i < fs.length; i++)
			{

				copy(fs[i], tar);

			}

		} else
		{

			System.out.println("开始从" + source + "拷贝文件到" + tar.getPath());

			InputStream is = new FileInputStream(source);

			OutputStream os = new FileOutputStream(tar);

			byte[] buf = new byte[1024];

			int len = 0;

			while ((len = is.read(buf)) != -1)
			{

				os.write(buf, 0, len);

			}

			is.close();

			os.close();

		}

	}

	/** */
	/**
	 * 
	 * 拷贝文件或者目录到某个指定的路径
	 * 
	 * 
	 * 
	 * @param source
	 * 
	 *            源文件或者目录
	 * 
	 * @param target
	 * 
	 *            目标路径
	 * 
	 * @throws IOException
	 */

	public static void copy(String source, String target)
	{

		File sour = new File(source);

		File tar = new File(target);

		try
		{

			copy(sour, tar);

		} catch (IOException e)
		{

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

	private static void delete(File file)
	{

		if (file.isDirectory())
		{

			File[] fs = file.listFiles();

			for (int i = 0; i < fs.length; i++)
			{

				delete(fs[i]);

			}

			file.delete();

		} else
		{

			file.delete();

		}

	}

	/** */
	/**
	 * 
	 * 删除一个文件或者目录
	 * 
	 * 
	 * 
	 * @param file
	 */

	public static void delete(String path)
	{

		File file = new File(path);

		delete(file);

	}

	/** */
	/**
	 * 
	 * 压缩文件或者目录到指定的路径
	 * 
	 * 
	 * 
	 * @param zipFileName
	 * 
	 *            目标路径
	 * 
	 * @param inputPath
	 * 
	 *            被压缩的文件或者目录
	 */

	public static void zip(String zipFileName, String inputPath)
	{

		File inputFile = new File(inputPath);

		ZipOutputStream out;

		try
		{

			out = new ZipOutputStream(new FileOutputStream(zipFileName));

			zip(out, inputFile, inputFile.getName());

			System.out.println("压缩完成！");

			out.close();

		} catch (Exception e)
		{

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

	private static void zip(ZipOutputStream out, File f, String base)

	throws Exception
	{

		System.out.println("正在压缩：" + f.getName() + " ");

		if (f.isDirectory())
		{

			File[] fs = f.listFiles();

			base += "/";

			System.out.println("新建目录条目：" + f.getName());

			out.putNextEntry(new ZipEntry(base)); // 生成相应的目录

			for (int i = 0; i < fs.length; i++)
			{

				// 对本目录下的所有文件对象递归调用本方法

				zip(out, fs[i], base + fs[i].getName());

			}

		} else
		{

			System.out.println("新增文件条目：" + f.getName());

			out.putNextEntry(new ZipEntry(base));

			InputStream is = new FileInputStream(f);

			byte[] buf = new byte[1024];

			int len = 0;

			while ((len = is.read(buf)) != -1)
			{

				out.write(buf, 0, len);

			}

			is.close();

		}

	}

	/** */
	/**
	 * 
	 * 解压缩zip文件到指定的路径
	 * 
	 * 
	 * 
	 * @param zipfile
	 * 
	 *            zip格式压缩文件
	 * 
	 * @param desPath
	 * 
	 *            目标路径
	 */

	public static void unzip(String zipFile, String desPath)
	{

		// 建立输出流，用于将从压缩文件中读出的文件流写入到磁盘

		OutputStream out = null;

		// 建立输入流，用于从压缩文件中读出文件

		ZipInputStream is;

		try
		{

			is = new ZipInputStream(new FileInputStream(zipFile));

			ZipEntry entry = null;

			while ((entry = is.getNextEntry()) != null)
			{

				System.out.println("正在解压缩：" + entry.getName() + " ");

				File f = new File(desPath + "\\" + entry.getName());

				if (entry.isDirectory())
				{

					System.out.println("新建目录：" + f.getName());

					f.mkdir();

				} else
				{

					System.out.println("新增文件：" + f.getName());

					// 根据压缩文件中读出的文件名称新建文件

					out = new FileOutputStream(f);

					byte[] buf = new byte[1024];

					int len = 0;

					while ((len = is.read(buf)) != -1)
					{

						out.write(buf, 0, len);

					}

					out.close();

				}

			}

			is.close();

		} catch (Exception e)
		{

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

	/** */
	/**
	 * 
	 * 创建新文件
	 * 
	 * 
	 * 
	 * @param path
	 */

	public static void createFile(String path)
	{

		File file = new File(path);

		try
		{

			file.createNewFile();

		} catch (IOException e)
		{

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

	/** */
	/**
	 * 
	 * 创建新目录
	 * 
	 * 
	 * 
	 * @param path
	 */

	public static void createDir(String path)
	{

		File file = new File(path);

		file.mkdirs();

	}

	/** */
	/**
	 * 
	 * 剪切文件或者目录到某个指定的路径
	 * 
	 * 
	 * 
	 * @param source
	 * 
	 *            源文件或者目录
	 * 
	 * @param target
	 * 
	 *            目标路径
	 * 
	 * 
	 */

	public static void cutTo(String source, String target)
	{

		File sourFile = new File(source);

		File tarFile = new File(target);

		if (sourFile.isFile())
		{

			if (tarFile.isDirectory())
			{

				sourFile.renameTo(tarFile);

			}

		} else
		{

			copy(source, target);

			delete(source);

		}

	}

	public static void main(String[] args)
	{

		// copy("E:\\w.txt", "E:\\a");

		// delete("E:\\a");

		// zip("E:\\a.zip", "E:\\b");

		// unzip("E:\\a.zip", "E:\\b");

//		 createFile("E:\\a.txt");

		// createDir("E:\\bb");

		// cutTo("E:\\b", "D:\\");

	}

}