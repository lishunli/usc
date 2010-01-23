package org.usc.services.student;

import java.util.LinkedHashMap;
import java.util.List;

import org.usc.beans.QueryResult;
import org.usc.beans.Student;
import org.usc.daos.DAO;

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
public interface IStudentService extends DAO<Student>
{

	/*
	 * @see org.usc.services.student.IStudentService#delete()
	 */
//	public abstract void save(Student student);
//
//	public abstract void delete(int no);
//
//	public abstract void update(Student student);
//
	public abstract List<Student> findByName(String value);
//	
//	public abstract List<Student> findByEntity(Student student);

//	public abstract long getCount();

//	public abstract QueryResult<Student> getScrollData();
//
//	public abstract QueryResult<Student> getScrollData(final int firstindex, final int maxresult);
//
//	public abstract QueryResult<Student> getScrollData(final int firstindex, final int maxresult, final LinkedHashMap<String, String> orderby);
//
//	public abstract QueryResult<Student> getScrollData(final int firstindex, final int maxresult, final String wherejpql, final Object[] queryParams,
//			final LinkedHashMap<String, String> orderby);
//	
//	public abstract QueryResult<Student> getScrollData(final int firstindex, final int maxresult, final String wherejpql, final Object[] queryParams);
}