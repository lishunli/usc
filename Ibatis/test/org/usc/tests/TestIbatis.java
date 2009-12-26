package org.usc.tests;

import java.util.Date;

import org.usc.beans.Student;
import org.usc.daos.IStudentDAO;
import org.usc.daos.StudentDaoImpl;


public class TestIbatis
{
	public static void main(String[] args)
	{
		IStudentDAO studentDAO = new StudentDaoImpl();
		
//		/**
//		 * 1.查询所有学生记录
//		 */
//		for(Student student:studentDAO.queryAllStudent())
//		{
//			System.out.println(student);
//		}
		
//		/**
//		 * 2.根据主键查询学生信息
//		 */
//		System.out.println(studentDAO.queryStudentById(20));
		
		
//		/*
//		 * 3.插入一条学生信息
//		 */
//		Student student = new Student();
//		student.setNo(22);
//		student.setName("HelloWorld");
//		student.setSex("女");
//		student.setAge(20);
//		student.setScore(95.5);
//		student.setEduTime(new Date());
//		studentDAO.addStudent(student);
		
		/**
		 * 4.根据no删除学生信息
		 */
		studentDAO.deleteStudentById(22);
		
		
		
	}
}
