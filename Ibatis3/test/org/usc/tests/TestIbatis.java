package org.usc.tests;

import static org.junit.Assert.*;
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
		if(null != studentDAO)
			studentDAO = null;
	}

	/**
	 * 测试查询所有学生记录
	 */
	@Test
	public void testSelectAll()
	{
		for(Student student:studentDAO.queryAllStudent())
		{
			System.out.println(student);
		}
	}
	
	/**
	 * 
	 */
	@Test
	public void testAddStudent()
	{
		
	}
	
	
	
	
}
