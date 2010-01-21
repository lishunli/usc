package org.usc.tests;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.usc.beans.Student;
import org.usc.daos.IStudentDao;
import org.usc.services.student.IStudentService;

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
public class StudentDaoTest
{
//	@Resource(name = "studentDao")
	@Autowired
	private IStudentDao sDao;
	
//	@Resource(name = "studentService")
	@Autowired
	private IStudentService studentService;


	@Test
	public void testFindAll()
	{
		for (Student student : studentService.findAll())
		{
			System.out.println(student);
		}
	}
}
