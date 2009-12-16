package org.usc.services.impl;

import java.io.FileInputStream;
import java.io.InputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.usc.daos.Student;
import org.usc.services.FileConvert;

public class FileConvertImpl implements FileConvert
{

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
		Student student = new Student();
		try
		{
			// 构建Workbook对象, 只读Workbook对象
			// 直接从本地文件创建Workbook
			// 从输入流创建Workbook
			InputStream is = new FileInputStream(fileName);
			jxl.Workbook rwb = Workbook.getWorkbook(is);
			// 获取第一张Sheet表
			Sheet rs = rwb.getSheet(0);
			
			//获取第一行，第一列的值
			Cell c00 = rs.getCell(0, 0);
			String strc00 = c00.getContents();
			//获取第一行，第二列的值
			Cell c10 = rs.getCell(1, 0);
			String strc10 = c10.getContents();
			//获取第二行，第二列的值
//			Cell c11 = rs.getCell(1, 1);
//			String strc11 = c11.getContents();
			int Columns = rs.getColumns();
			
			System.out.println("Cell(0, 0)" + " value : " + strc00 + "; type : " + c00.getType());
			System.out.println("Cell(1, 0)" + " value : " + strc10 + "; type : " + c10.getType());
			for(int i = 1;i<rs.getRows();i++)
			{
				for(int j =0 ;j<Columns;j++)
					System.out.print(rs.getCell(j,i).getContents()+":"+rs.getCell(j,i).getType()+"	");
				System.out.println();
			}
//			System.out.println("Cell(1, 1)" + " value : " + strc11 + "; type : " + c11.getType());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	/**
	 * DBF处理
	 * @param fileName
	 * @return
	 */
	private boolean DBFConvert(String fileName)
	{
		System.out.println("DBFConvert");
		return false;
	}
}
