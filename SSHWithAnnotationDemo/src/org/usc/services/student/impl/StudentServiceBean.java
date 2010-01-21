package org.usc.services.student.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.usc.beans.Student;
import org.usc.daos.DaoSupport;
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
public class StudentServiceBean extends DaoSupport<Student> implements IStudentService
{
	/* 
	 * @see org.usc.services.student.impl.IStudentService#findAll()
	 */
	public List<Student> findAll()
	{
		return super.findAll();
	}

	/* 
	 * @see org.usc.services.student.IStudentService#delete()
	 */
	/* 
	 * @see org.usc.services.student.impl.IStudentService#save(org.usc.beans.Student)
	 */
	public void save(Student student)
	{
		super.save(student);
	}
	
	/* 
	 * @see org.usc.services.student.impl.IStudentService#delete(int)
	 */
	public void delete(int no)
	{
		super.delete(no);
	}
	
	/* 
	 * @see org.usc.services.student.impl.IStudentService#update(org.usc.beans.Student)
	 */
	public void update(Student student)
	{
		super.update(student);
	}
}
