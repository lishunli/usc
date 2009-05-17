package com.test;

import org.hibernate.Session;


import com.pojo.Student;
import com.pojo.Teacher;

import com.sf.HibernateSessionFactory;


public class test 
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{
		Session session =HibernateSessionFactory.getSession();
		Student s1 =new Student();
		s1.setStudentName("д╬вс1");
		Student s2 =new Student();
		s2.setStudentName("mz2");
		Teacher t1 =new Teacher();
		t1.setTeacherName("li1");
		Teacher t2 =new Teacher();
		t2.setTeacherName("li2");
		
//		TeacherStudent ts1=new TeacherStudent();
//		ts1.setStudent(s1);
//		ts1.setStudent(s2);
//		ts1.setTeacher(t1);
//		ts1.setTeacher(t2);
		
		t1.getTeacherStudents().add(s1);
		t1.getTeacherStudents().add(s2);
		
		t2.getTeacherStudents().add(s1);
		t2.getTeacherStudents().add(s2);
		
		s1.getTeacherStudents().add(t1);
		s1.getTeacherStudents().add(t2);

		s2.getTeacherStudents().add(t1);
		s2.getTeacherStudents().add(t2);

		

		
		session.saveOrUpdate(t1);
		session.beginTransaction().commit();
		
		

	}
}
