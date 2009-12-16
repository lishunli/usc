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
		
		System.out.println("XLSCONVET");
		long start = System.currentTimeMillis();
		try
		{
			// 构建Workbook对象, 只读Workbook对象
			// 直接从本地文件创建Workbook
			// 从输入流创建Workbook
			InputStream is = new FileInputStream(fileName);
			jxl.Workbook rwb = Workbook.getWorkbook(is);
			// 获取第一张Sheet表
			Sheet rs = rwb.getSheet(0);

			// 获取第一行，第一列的值
			Cell c00 = rs.getCell(0, 0);
			String strc00 = c00.getContents();
			// 获取第一行，第二列的值
			Cell c10 = rs.getCell(1, 0);
			String strc10 = c10.getContents();
			// 获取第二行，第二列的值
			// Cell c11 = rs.getCell(1, 1);
			// String strc11 = c11.getContents();
			int Columns = rs.getColumns();

			// System.out.println("Cell(0, 0)" + " value : " + strc00 +
			// "; type : " + c00.getType());
			// System.out.println("Cell(1, 0)" + " value : " + strc10 +
			// "; type : " + c10.getType());
			for (int i = 1; i < rs.getRows(); i++)
			{
				Student student = new Student();
				for (int j = 0; j < Columns; j++)
				{
					// System.out.print(rs.getCell(j,i).getContents()+"	");
					// System.out.println(rs.getCell(j, 0).getContents());
					setParm(student, rs.getCell(j, 0).getContents(), rs
							.getCell(j, i).getContents());
				}
				System.out.println(student.getNo() + ":" + student.getName()
						+ ":" + student.getSex() + ":" + student.getAge() + ":"
						+ student.getScore() + ":" + student.getEduTime());
				sDAO.save(student);
//				System.out.println();
			}
			// System.out.println("Cell(1, 1)" + " value : " + strc11 +
			// "; type : " + c11.getType());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("所用时间" + (end-start));
		return false;
	}

	private void setParm(Student student, String parm, String value)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		try
		{
			if ("no".equals(parm))
				student.setNo(value);
			else if ("name".equals(parm))
				student.setName(value);
			else if ("sex".equals(parm))
				student.setSex(value);
			else if ("age".equals(parm))
				student.setAge(Integer.parseInt(value));
			else if ("score".equals(parm))
				student.setScore(Double.parseDouble(value));
			else if ("eduTime".equals(parm))
			{
				// // Date date = sdf.parse("2005-04-22");
				java.util.Date cDate = sdf.parse(value);
				java.sql.Date dd = new java.sql.Date(cDate.getTime());

//				System.out.println(value + ":" + dd);
				student.setEduTime(dd);

			}

		} catch (Exception e)
		{
			e.printStackTrace();
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
