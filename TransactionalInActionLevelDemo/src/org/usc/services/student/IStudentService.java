package org.usc.services.student;

import java.util.List;

import org.usc.beans.Student;
import org.usc.beans.base.QueryResult;

/**
 * 学生服务类接口
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-1-21<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
public interface IStudentService {
	/**
	 * 根据姓名查找学生
	 * 
	 * @param value
	 *            姓名
	 * @return 该姓名的学生集
	 */
	List<Student> findByName(String value);
	
	void save(Student student);

	QueryResult<Student> getScrollData(int firstindex, int maxresult, String wherejpql, Object[] queryParams);

	void deleteStudents();
	/**
	 * 
	 */
	void saveStudents();
}