package com.usc.service;

import java.util.List;

import com.usc.dao.Grade;
import com.usc.dao.Student;

public interface StudentManager
{
	public void addStu(Student stu);
	public List<Grade> showgrade();
	public boolean checksid(String id);
}
