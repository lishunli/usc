package org.usc.tests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.usc.beans.Student;
import org.usc.daos.IStudentDAO;
import org.usc.daos.StudentDaoImpl;

/**
 * 学生测试类
 * 
 * @author ShunLi
 * @Time 2010-1-1
 */
public class TestIbatis
{
	IStudentDAO studentDAO = null;

	@Before
	public void setUp() throws Exception
	{
		studentDAO = new StudentDaoImpl();
	}

	@After
	public void tearDown() throws Exception
	{
		if (null != studentDAO)
			studentDAO = null;
	}

	/**
	 * 测试查询所有学生记录
	 */
	@Test
	public void testSelectAll()
	{
		for (Student student : studentDAO.queryAllStudent())
		{
			System.out.println(student);
		}
	}

	/**
	 * 测试根据主键查询学生信息
	 */
	@Test
	public void testQueryStudentById()
	{
		System.out.println(studentDAO.queryStudentById(20));
	}

	/**
	 * 测试插入一条学生信息
	 */
	@Test
	public void testAddStudent()
	{
		Student student = new Student();
		// student.setNo(24);//注释掉此句的话，就有MySQL自动生成主键（自动增长）
		student.setName("HelloWorld235");
		student.setSex("女");
		student.setAge(20);
		student.setScore(95.5);
		student.setEduTime(new Date());
		studentDAO.addStudent(student);
	}

	/**
	 * 测试根据no删除学生信息
	 */
	@Test
	public void testDeleteStudentById()
	{
		studentDAO.deleteStudentById(27);
	}

	/**
	 * 测试根据no更新学生信息
	 */
	@Test
	public void testUpdateStudentById()
	{
		Student student = new Student();
		student.setNo(27);
		student.setName("呵呵");
		student.setSex("女");
		student.setAge(18);
		student.setScore(100.0);
		student.setEduTime(new Date());
		studentDAO.updateStudentById(student);
	}

	/**
	 * 测试根据姓名模糊查询学生信息
	 */
	@Test
	public void testQueryStudentByName()
	{
		String name = "H";
		for (Student student : studentDAO.queryStudentByName("%" + name + "%"))
		{
			System.out.println(student);
		}
	}

}
