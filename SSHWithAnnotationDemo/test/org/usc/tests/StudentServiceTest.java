package org.usc.tests;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.usc.beans.QueryResult;
import org.usc.beans.Student;
import org.usc.services.student.IStudentService;
import static org.junit.Assert.*;

/**
 * 
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-1-17<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
public class StudentServiceTest
{
//	@Resource(name = "studentDao")
	
//	@Resource(name = "studentService")
	@Autowired
	private IStudentService studentService;


	@Test
	public void testGetScrollData1()
	{
		QueryResult<Student> scrollData = studentService.getScrollData();
		for (Student student : scrollData.getResultlist())
		{
			System.out.println(student);
		}
		System.out.println(scrollData.getTotalrecord());
	}
	
	
	@Test
	public void testGetScrollData2()
	{
		QueryResult<Student> scrollData = studentService.getScrollData(0,5);
		for (Student student : scrollData.getResultlist())
		{
			System.out.println(student);
		}
		System.out.println(scrollData.getTotalrecord());
	}
	
	@Test
	public void testGetScrollData3()
	{
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
//		orderby.put("no", "asc");
		orderby.put("age", "desc");
		orderby.put("score", "desc");
		QueryResult<Student> scrollData = studentService.getScrollData(0,5,orderby);
		for (Student student : scrollData.getResultlist())
		{
			System.out.println(student);
		}
		System.out.println(scrollData.getTotalrecord());
	}
	
	@Test
	public void testGetScrollData4()
	{
		QueryResult<Student> scrollData = studentService.getScrollData(0,5,"o.sex=? and o.age=?",new Object[]{"男",20});
		for (Student student : scrollData.getResultlist())
		{
			System.out.println(student);
		}
		System.out.println(scrollData.getTotalrecord());
	}
	
	@Test
	public void testGetScrollData5()
	{
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("no", "asc");
		QueryResult<Student> scrollData = studentService.getScrollData(0,5,"o.sex=? and o.age=?",new Object[]{"男",20},orderby);
		for (Student student : scrollData.getResultlist())
		{
			System.out.println(student);
		}
		System.out.println(scrollData.getTotalrecord());
	}
	
	@Test
	public void testDelete()
	{
		studentService.delete(20);
	}
	
	@Test
	public void testFindByName()
	{
		String name = "李顺利";
		for(Student student : studentService.findByName(name))
		{
			System.out.println(student);
			assertTrue(name.equals(student.getName()));
		}
		
	}
	@Test
	public void testSave()
	{
		Student student = new Student("李顺利", "男", 20, 90.0, new Date());
		studentService.save(student);
	}
	
	@Test
	public void testFindEntiey()
	{
		Student student = new Student("李顺利", "男", 20, 90.0, new Date());
		for(Student stu: studentService.findByEntity(student))
		{
			System.out.println(stu);
		}
		
		
	}
	
	@Test
	public void testGetCount()
	{
		System.out.println(studentService.getCount());
	}
}
