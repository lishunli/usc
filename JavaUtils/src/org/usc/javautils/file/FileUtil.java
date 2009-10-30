package org.usc.javautils.file;

import java.io.*;

import java.util.zip.*;

/** */
/**
 * 
 * ���ļ�����Ŀ¼��������
 * file and directory ���� ���� ɾ�� ���� ѹ�����н�ѹ��(java.util.zip.*;)�ȳ��ò��� 
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

			System.out.println("��ʼ����Ŀ¼��" + tar.getPath());

			tar.mkdir();

			File[] fs = source.listFiles();

			for (int i = 0; i < fs.length; i++)
			{

				copy(fs[i], tar);

			}

		} else
		{

			System.out.println("��ʼ��" + source + "�����ļ���" + tar.getPath());

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
	 * �����ļ�����Ŀ¼��ĳ��ָ����·��
	 * 
	 * 
	 * 
	 * @param source
	 * 
	 *            Դ�ļ�����Ŀ¼
	 * 
	 * @param target
	 * 
	 *            Ŀ��·��
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
	 * ɾ��һ���ļ�����Ŀ¼
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
	 * ѹ���ļ�����Ŀ¼��ָ����·��
	 * 
	 * 
	 * 
	 * @param zipFileName
	 * 
	 *            Ŀ��·��
	 * 
	 * @param inputPath
	 * 
	 *            ��ѹ�����ļ�����Ŀ¼
	 */

	public static void zip(String zipFileName, String inputPath)
	{

		File inputFile = new File(inputPath);

		ZipOutputStream out;

		try
		{

			out = new ZipOutputStream(new FileOutputStream(zipFileName));

			zip(out, inputFile, inputFile.getName());

			System.out.println("ѹ����ɣ�");

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

		System.out.println("����ѹ����" + f.getName() + " ");

		if (f.isDirectory())
		{

			File[] fs = f.listFiles();

			base += "/";

			System.out.println("�½�Ŀ¼��Ŀ��" + f.getName());

			out.putNextEntry(new ZipEntry(base)); // ������Ӧ��Ŀ¼

			for (int i = 0; i < fs.length; i++)
			{

				// �Ա�Ŀ¼�µ������ļ�����ݹ���ñ�����

				zip(out, fs[i], base + fs[i].getName());

			}

		} else
		{

			System.out.println("�����ļ���Ŀ��" + f.getName());

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
	 * ��ѹ��zip�ļ���ָ����·��
	 * 
	 * 
	 * 
	 * @param zipfile
	 * 
	 *            zip��ʽѹ���ļ�
	 * 
	 * @param desPath
	 * 
	 *            Ŀ��·��
	 */

	public static void unzip(String zipFile, String desPath)
	{

		// ��������������ڽ���ѹ���ļ��ж������ļ���д�뵽����

		OutputStream out = null;

		// ���������������ڴ�ѹ���ļ��ж����ļ�

		ZipInputStream is;

		try
		{

			is = new ZipInputStream(new FileInputStream(zipFile));

			ZipEntry entry = null;

			while ((entry = is.getNextEntry()) != null)
			{

				System.out.println("���ڽ�ѹ����" + entry.getName() + " ");

				File f = new File(desPath + "\\" + entry.getName());

				if (entry.isDirectory())
				{

					System.out.println("�½�Ŀ¼��" + f.getName());

					f.mkdir();

				} else
				{

					System.out.println("�����ļ���" + f.getName());

					// ����ѹ���ļ��ж������ļ������½��ļ�

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
	 * �������ļ�
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
	 * ������Ŀ¼
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
	 * �����ļ�����Ŀ¼��ĳ��ָ����·��
	 * 
	 * 
	 * 
	 * @param source
	 * 
	 *            Դ�ļ�����Ŀ¼
	 * 
	 * @param target
	 * 
	 *            Ŀ��·��
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