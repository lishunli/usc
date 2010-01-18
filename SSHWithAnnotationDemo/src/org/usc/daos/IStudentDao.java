package org.usc.daos;

import java.util.List;

import org.usc.beans.Student;

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
public interface IStudentDao
{

	/**
	 * 查询所有的学生
	 * 
	 * @return 学生List
	 */
	public abstract List<Student> findAll();

}