package org.usc.services.impl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import jxl.Sheet;
import jxl.Workbook;
import org.usc.daos.Student;
import org.usc.daos.StudentDAO;
import org.usc.services.FileConvert;
import com.linuxense.javadbf.DBFReader;

public class FileConvertImpl implements FileConvert
{
	private StudentDAO sDAO;
	private boolean convertFlag = true;
	private int correctCount = 0;
	private int errorCount = 0;

	public void setsDAO(StudentDAO sDAO)
	{
		this.sDAO = sDAO;
	}

	public boolean fileConvert(String fileName)
	{
		String fileType = null;
		fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
		// System.out.println("fileType:"+fileType);
		// System.out.println("chuli"+fileName);
		if ("xls".equals(fileType) && XLSConvert(fileName))
			return true;
		else if ("dbf".equals(fileType) && DBFConvert(fileName))
			return true;

		return false;
	}

	/**
	 * xls处理
	 * 
	 * @param fileName
	 * @return
	 */
	private boolean XLSConvert(String fileName)
	{
		boolean result = false;
		// long start = System.currentTimeMillis();
		// System.out.println("开始时间"+start);
		try
		{
			// 构建Workbook对象, 只读Workbook对象
			// 直接从本地文件创建Workbook
			// 从输入流创建Workbook
			InputStream is = new FileInputStream(fileName);
			jxl.Workbook rwb = Workbook.getWorkbook(is);
			// 获取第一张Sheet表
			Sheet rs = rwb.getSheet(0);
			int Columns = rs.getColumns();// 获取行数
			for (int i = 1; i < rs.getRows(); i++)
			{
				Student student = new Student();
				for (int j = 0; j < Columns; j++)
				{
					setParm(student, rs.getCell(j, 0).getContents(), rs
							.getCell(j, i).getContents());
				}
				if (convertFlag)
				{
					sDAO.save(student);
					correctCount++;
				} else
				{
					System.out.println("此条记录有错误，请修正后重新导入，错误记录信息如下：");
					System.out.println(student.getNo() + ":"
							+ student.getName() + ":" + student.getSex() + ":"
							+ student.getAge() + ":" + student.getScore() + ":"
							+ student.getEduTime());
					convertFlag = true;
					errorCount++;
				}
			}
			System.out.println();
			System.out.println("导入完毕");
			System.out.println("正确导入记录条数：" + correctCount);
			System.out.println("错误记录条数：" + errorCount);
			System.out.println();
			if (correctCount > 0)
				result = true;

			errorCount = 0;
			correctCount = 0;
			convertFlag = true;

		} catch (Exception e)
		{
			//e.printStackTrace();
		}
		// long end = System.currentTimeMillis();
		// System.out.println("结束时间"+end);
		// System.out.println("所用时间" + (end-start));
		return result;
	}

	/**
	 * DBF处理
	 * 
	 * @param fileName
	 * @return
	 */
	private boolean DBFConvert(String fileName)
	{
		boolean result = false;
		InputStream fis = null;
		try
		{
			// 读取文件的输入流
			fis = new FileInputStream(fileName);
			// 根据输入流初始化一个DBFReader实例，用来读取DBF文件信息
			DBFReader reader = new DBFReader(fis);
			reader.setCharactersetName("GB2312");
			// 调用DBFReader对实例方法得到path文件中字段的个数
			int fieldsCount = reader.getFieldCount();
			// 取出字段信息
			// for (int i = 0; i < fieldsCount; i++)
			// {
			// DBFField field = reader.getField(i);
			// System.out.println(field.getName());
			// }
			Object[] rowValues;
			// 一条条取出path文件中记录
			while ((rowValues = reader.nextRecord()) != null)
			{
				Student student = new Student();
				for (int i = 0; i < rowValues.length; i++)
				{
					setParm(student, reader.getField(i).getName().toString().trim(),
							rowValues[i].toString().trim());
				}
				if (convertFlag)
				{
					sDAO.save(student);
					correctCount++;
				} else
				{
					System.out.println("此条记录有错误，请修正后重新导入，错误记录信息如下：");
					System.out.println(student.getNo() + ":"
							+ student.getName() + ":" + student.getSex() + ":"
							+ student.getAge() + ":" + student.getScore() + ":"
							+ student.getEduTime());
					convertFlag = true;
					errorCount++;
				}
			}
			System.out.println();
			System.out.println("导入完毕");
			System.out.println("正确导入记录条数：" + correctCount);
			System.out.println("错误记录条数：" + errorCount);
			System.out.println();
			if (correctCount > 0)
				result = true;

			errorCount = 0;
			correctCount = 0;
			convertFlag = true;
			
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{

				fis.close();

			} catch (Exception e)
			{
			}

		}

		return result;
	}

	/**
	 * 设置属性
	 * @param student
	 * @param parm
	 * @param value
	 */
	private void setParm(Student student, String parm, String value)
	{
		// System.out.println(parm);
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		try
		{
			if ("no".equals(parm))
			{
				student.setNo(value);

				if (value == null || "".equals(value.trim())
						|| value.length() != 11 || sDAO.findById(value) != null)
				{
					convertFlag = false;
				}
			} else if ("name".equals(parm))
			{
				student.setName(value);

				if (value == null || "".equals(value.trim()))
				{
					convertFlag = false;
				}

			} else if ("sex".equals(parm))
			{
				student.setSex(value);

				if (value == null || "".equals(value.trim()))
				{
					convertFlag = false;
				}

			} else if ("age".equals(parm))
			{
				value = ageMng(value);
				student.setAge(Integer.parseInt(value));

			} else if ("score".equals(parm))
			{
				student.setScore(Double.parseDouble(value));
			} else if ("eduTime".equals(parm))
			{
				if (value.contains("CST"))
				{
					SimpleDateFormat sdfCST = new SimpleDateFormat(
							"EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
					Date d = sdfCST.parse(value);
					Calendar c = Calendar.getInstance();
					c.setTime(d);
					value = new SimpleDateFormat("yyyy-MM-dd").format(c
							.getTime());
				}

				java.util.Date cDate = sdf.parse(value);
				java.sql.Date dd = new java.sql.Date(cDate.getTime());
				student.setEduTime(dd);

			}

		} catch (Exception e)
		{
			convertFlag = false;
			//e.printStackTrace();
		}
	}

	private String ageMng(String age)
	{
		if (".0".equals(age.substring(age.length() - 2, age.length())))
			return age.substring(0, age.length() - 2);
		else
			return age;

	}
}
