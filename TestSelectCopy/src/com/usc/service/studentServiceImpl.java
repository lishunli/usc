package com.usc.service;

import java.util.List;

import com.usc.dao.Grade;
import com.usc.dao.GradeDAO;

public class studentServiceImpl implements studentService
{
	private GradeDAO gdao;
	
	public void setGdao(GradeDAO gdao)
	{
		this.gdao = gdao;
	}

	public List<Grade> getAllGrade()
	{
		return gdao.findAll();
	}

}
