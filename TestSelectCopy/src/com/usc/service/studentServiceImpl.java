package com.usc.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.usc.dao.Grade;
import com.usc.dao.GradeDAO;
import com.usc.dao.Student;
import com.usc.dao.StudentDAO;

public class studentServiceImpl implements studentService
{
	private GradeDAO gdao;
	private StudentDAO sdao;

	public void setSdao(StudentDAO sdao)
	{
		this.sdao = sdao;
	}

	public void setGdao(GradeDAO gdao)
	{
		this.gdao = gdao;
	}

	public List<Grade> getAllGrade()
	{
		return gdao.findAll();
	}

	public void addStudent(Student s)
	{
		sdao.save(s);

	}

	public List<Student> getAllStudnet()
	{
		return sdao.findAll();
	}

	public void deleteStudent(String sno)
	{
		sdao.delete(sdao.findById(sno));

	}

	public boolean findbysno(String sno)
	{
		if (null == sdao.findById(sno))
			return false;
		return true;
	}

	public Student findbyid(String sno)
	{
		return sdao.findById(sno);
	}

	public void updateStudent(Student s)
	{
		sdao.merge(s);
		
	}

	public List<Student> searchbyname(String sname)
	{
		
		return sdao.findBySname(sname);
	}

	public List<Student> searchbyno(String no)
	{
		return sdao.findBySno(no);
	}

	@SuppressWarnings("deprecation")
	public void excel()
	{
		
//		HSSFWorkbook wb = new HSSFWorkbook();
//		HSSFSheet sheet = wb.createSheet("sheet1");
//
//		HSSFRow row = sheet.createRow(0);
//
//		HSSFCell cell = row.createCell((short) 0);
//		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
//		cell.setCellValue("学号");
//
//		cell = row.createCell((short) 1);
//		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
//		cell.setCellValue("姓名");
//
//		cell = row.createCell((short) 2);
//		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
//		cell.setCellValue("性别");
//
//		cell = row.createCell((short) 3);
//		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
//		cell.setCellValue("年龄");
//		
//		cell = row.createCell((short) 4);
//		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
//		cell.setCellValue("班级");
//
//		List<Student> list = this.getAllStudnet();
//
//		for (int i = 0; i < list.size(); ++i)
//		{
//			Student stu = list.get(i);
//
//			row = sheet.createRow(i + 1);
//
//			cell = row.createCell((short) 0);
//			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
//			cell.setCellValue(stu.getSno());
//
//			cell = row.createCell((short) 1);
//			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
//			cell.setCellValue(stu.getSname());
//
//			cell = row.createCell((short) 2);
//			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
//			cell.setCellValue(stu.getSex());
//
//			cell = row.createCell((short) 3);
//			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
//			cell.setCellValue(stu.getAge());
//			
//			cell = row.createCell((short) 4);
//			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
//			cell.setCellValue(stu.getGname());
//			
//			
//		}
//
//
//		// 方法二：获得xls文件，从内存中得到
//		ByteArrayOutputStream os = new ByteArrayOutputStream();
//
//		try
//		{
//			wb.write(os);
//		} catch (IOException e)
//		{
//			e.printStackTrace();
//		}
//
//		byte[] content = os.toByteArray();
//
//		InputStream is = new ByteArrayInputStream(content);
//		
//		response.setContentType("Application/msexcel");    
//		response.setHeader("Content-disposition","attachment; filename=filename.xls");    
//		wb.write(response.getOutputStream());   
//
////		return is;
	}

	public void pdf()
	{
		
	}

}
