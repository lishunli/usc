package com.usc.service;

import java.util.List;

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

}
