package org.usc.daos;

import java.util.List;

import org.springframework.stereotype.Repository;
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
@Repository("studentDao")
// 声明此类为数据持久层的类
public class StudentDaoImpl extends MyHibernateDaoSupport implements IStudentDao
{
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.usc.daos.IStudentDao#query()
	 */
	@SuppressWarnings("unchecked")
	public List<Student> findAll()
	{
		return super.getHibernateTemplate().find("from Student");
	}
}
