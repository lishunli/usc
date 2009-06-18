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
	public boolean findbysno(String sno);
	public Student findbyid(String sno);
	public void updateStudent(Student s);
	public List<Student> searchbyno(String no);
	public List<Student> searchbyname(String sname);
	public void excel();
	public void pdf();
}
