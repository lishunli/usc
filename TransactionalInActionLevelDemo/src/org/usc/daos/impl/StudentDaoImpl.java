package org.usc.daos.impl;

import org.springframework.stereotype.Repository;
import org.usc.beans.Student;
import org.usc.daos.StudentDao;
import org.usc.daos.base.BaseDaoSupport;

/**
 * 
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2011-5-13<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
@Repository
public class StudentDaoImpl extends BaseDaoSupport<Student> implements StudentDao {

}
