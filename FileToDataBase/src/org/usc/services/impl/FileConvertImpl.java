package org.usc.services.impl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.usc.daos.Student;
import org.usc.daos.StudentDAO;
import org.usc.services.FileConvert;

public class FileConvertImpl implements FileConvert
{
	private StudentDAO sDAO;
	private  boolean convertFlag = true;
	private  int correctCount = 0;
	private  int errorCount = 0;

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
			int Columns = rs.getColumns();//获取行数
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
			System.out.println("正确导入记录条数："+correctCount);
			System.out.println("错误记录条数："+errorCount);
			System.out.println();
			
			errorCount=0;
			correctCount=0;
			convertFlag = true;
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		// long end = System.currentTimeMillis();
		// System.out.println("结束时间"+end);
		// System.out.println("所用时间" + (end-start));
		return false;
	}

	private void setParm(Student student, String parm, String value)
	{
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
				student.setAge(Integer.parseInt(value));
			} else if ("score".equals(parm))
			{
				student.setScore(Double.parseDouble(value));
			} else if ("eduTime".equals(parm))
			{

				// // Date date = sdf.parse("2005-04-22");
				java.util.Date cDate = sdf.parse(value);
				java.sql.Date dd = new java.sql.Date(cDate.getTime());

				// System.out.println(value + ":" + dd);
				student.setEduTime(dd);

			}

		} catch (Exception e)
		{
			convertFlag = false;
		}
	}

	/**
	 * DBF处理
	 * 
	 * @param fileName
	 * @return
	 */
	private boolean DBFConvert(String fileName)
	{
		System.out.println("DBFConvert");
		return false;
	}
}
