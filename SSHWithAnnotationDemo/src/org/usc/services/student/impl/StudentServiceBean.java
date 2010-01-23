package org.usc.services.student.impl;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.usc.beans.QueryResult;
import org.usc.beans.Student;
import org.usc.daos.BaseDaoSupport;
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
@Service("studentService")
// 声明此类为业务逻辑层的类
public class StudentServiceBean extends BaseDaoSupport<Student> implements IStudentService
{
	@Override
	public List<Student> findByName(String value)
	{
		return super.findByProperty("name", value);
	}
}
