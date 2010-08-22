package org.usc.test;

import java.util.LinkedHashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.usc.bean.Teacher;
import org.usc.service.teacher.ITeacherService;

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
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })
public class TeacherServiceTest
{
	// @Resource(name = "studentDao")

	// @Resource(name = "studentService")
	@Autowired
	private ITeacherService teacherService;

	@Test
	public void testSave()
	{
		for (int i = 40; i < 80; i++)
		{
			Teacher teacher = new Teacher();
			teacher.setName("老师" + i);
			teacher.setSex("男");
			teacher.setPositional("讲师");
			teacherService.save(teacher);
		}
	}

	@Test
	public void testGetScrollDate()
	{
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("id", "asc");
		String name = "老师3";
		for (Teacher teacher : teacherService.getScrollData(0, 5, "o.name like ?", new Object[] { "%" + name + "%" }, orderby).getResultList())
		{
			System.out.println(teacher);
		}
	}

	@Test
	public void testGetCount()
	{
		System.out.println(teacherService.getCount());
	}
}
