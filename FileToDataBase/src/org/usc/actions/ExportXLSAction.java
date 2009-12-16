package org.usc.actions;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.usc.daos.Student;
import org.usc.daos.StudentDAO;

import com.opensymphony.xwork2.ActionSupport;

public class ExportXLSAction extends ActionSupport
{
	private StudentDAO sDAO;
	
	public void setsDAO(StudentDAO sDAO)
	{
		this.sDAO = sDAO;
	}
	/**
	 * @return
	 */
	public String execute()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet1");

		HSSFRow row = sheet.createRow(0);

		HSSFCell cell = row.createCell((short) 0);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("学号");

		cell = row.createCell((short) 1);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("姓名");

		cell = row.createCell((short) 2);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("性别");

		cell = row.createCell((short) 3);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("年龄");

		cell = row.createCell((short) 4);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("分数");
		
		cell = row.createCell((short) 5);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("入学时间");
		

		List<Student> list = sDAO.findAll();

		for (int i = 0; i < list.size(); ++i)
		{
			Student stu = list.get(i);

			row = sheet.createRow(i + 1);

			cell = row.createCell((short) 0);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(stu.getNo());

			cell = row.createCell((short) 1);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(stu.getName());

			cell = row.createCell((short) 2);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(stu.getSex());

			cell = row.createCell((short) 3);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(stu.getAge());

			cell = row.createCell((short) 4);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(stu.getScore());
			
			cell = row.createCell((short) 5);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(sdf.format(stu.getEduTime()));

		}
		
		try
		{
			
			OutputStream os = ServletActionContext.getResponse().getOutputStream();
			ServletActionContext.getResponse().setContentType("application/vnd.xls");
			ServletActionContext.getResponse().setHeader("Content-disposition",
					"attachment;filename=student.xls");
			wb.write(os);
			os.flush();
			os.close();
			

		} catch (IOException e)
		{
			//e.printStackTrace();
		}

		
		return null;
	}
}