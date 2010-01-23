package org.usc.services.student;

import java.util.LinkedHashMap;
import java.util.List;

import org.usc.beans.Student;
import org.usc.beans.base.QueryResult;
import org.usc.daos.IBaseDao;

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
public interface IStudentService extends IBaseDao<Student>
{
	public abstract List<Student> findByName(String value);
}