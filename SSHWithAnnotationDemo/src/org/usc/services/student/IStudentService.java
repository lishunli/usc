package org.usc.services.student;

import java.util.List;

import org.usc.beans.Student;

/**
 * 
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-1-21<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
public interface IStudentService
{


	/* 
	 * @see org.usc.services.student.IStudentService#delete()
	 */
	public abstract void save(Student student);

	public abstract void delete(int no);

	public abstract void update(Student student);
	
	public abstract List<Student> findByName(Object value);
	
	public abstract long getCount();

}