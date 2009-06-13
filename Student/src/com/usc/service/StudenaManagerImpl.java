package com.usc.service;

import java.util.List;

import com.usc.dao.Grade;
import com.usc.dao.GradeDAO;
import com.usc.dao.Student;
import com.usc.dao.StudentDAO;

public class StudenaManagerImpl implements StudentManager
{
	private StudentDAO sdao;
	private GradeDAO gdao;

	public void setSdao(StudentDAO sdao)
	{
		this.sdao = sdao;
	}

	public void setGdao(GradeDAO gdao)
	{
		this.gdao = gdao;
	}

	public void addStu(Student stu)
	{
		sdao.save(stu);

	}

	public List<Grade> showgrade()
	{

		return gdao.findAll();
	}

	public boolean checksid(String id)
	{
		if (null != sdao.findById(id))
			return true;
		return false;
	}

}
