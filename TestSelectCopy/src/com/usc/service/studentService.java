package com.usc.service;

import java.util.List;

import com.usc.dao.Grade;
import com.usc.dao.Student;



public interface studentService
{
	public List<Grade> getAllGrade();
	public void addStudent(Student s);
	public List<Student> getAllStudnet();
	public void deleteStudent(String sno);
	
	
}
