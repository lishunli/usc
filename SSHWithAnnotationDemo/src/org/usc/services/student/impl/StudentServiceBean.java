package org.usc.services.student.impl;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.usc.beans.QueryResult;
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

//
//	public List<Student> findByEntity(Student student)
//	{
//		return super.findByEntity(student);
//	}
	@Override
	public List<Student> findByName(String value)
	{
		return super.findByProperty("name", value);
	}
//
//	/*
//	 * @see org.usc.services.student.IStudentService#delete()
//	 */
//	/*
//	 * @see org.usc.services.student.impl.IStudentService#save(org.usc.beans.Student)
//	 */
//	public void save(Student student)
//	{
//		super.save(student);
//	}
//
//	/*
//	 * @see org.usc.services.student.impl.IStudentService#delete(int)
//	 */
//	public void delete(int no)
//	{
//		super.delete(no);
//	}
//
//	/*
//	 * @see org.usc.services.student.impl.IStudentService#update(org.usc.beans.Student)
//	 */
//	public void update(Student student)
//	{
//		super.update(student);
//	}
	
//	public long getCount()
//	{
//		return super.getCount();
//	}
//
//	/*
//	 * @see org.usc.services.student.IStudentService#findByName(java.lang.Object)
//	 */
//
//	/*
//	 * @see org.usc.daos.DAO#findAll()
//	 */
//	public QueryResult<Student> getScrollData()
//	{
//		return super.getScrollData();
//	}
//
//	public QueryResult<Student> getScrollData(final int firstindex, final int maxresult)
//	{
//		return super.getScrollData(firstindex, maxresult);
//	}
//
//	public QueryResult<Student> getScrollData(final int firstindex, final int maxresult, final LinkedHashMap<String, String> orderby)
//	{
//		return super.getScrollData(firstindex, maxresult, orderby);
//	}
//
//	public QueryResult<Student> getScrollData(final int firstindex, final int maxresult, final String wherejpql, final Object[] queryParams)
//	{
//		return super.getScrollData();
//	}

}
