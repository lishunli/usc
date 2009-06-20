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
	private pageModel pm;

	public void setPm(pageModel pm)
	{
		this.pm = pm;
	}

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

	public List<Student> getAllStudentbyPage(int pageNo)
	{
		pm.setPageSize();
		pm.setPageNo(pageNo);
		pm.setTotalRecords();
		pm.setTotalPages();
//		System.out.println("2+++"+pageNo+pm.getPageNo()+"*****"+pm.getPageSize());
		return sdao.findAllbyPage(pm.getPageNo(), pm.getPageSize());
	}
}
