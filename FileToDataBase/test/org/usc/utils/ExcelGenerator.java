package org.usc.utils;

import java.io.*;
import jxl.*;

public class ExcelGenerator
{
	public static void main(String[] args)
	{
		try
		{
			// 构建Workbook对象, 只读Workbook对象
			// 直接从本地文件创建Workbook
			// 从输入流创建Workbook
			InputStream is = new FileInputStream("stu.xls");
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
	}

}