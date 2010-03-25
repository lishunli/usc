package org.usc.services.teacher.impl;

import java.util.List;

import org.usc.beans.Teacher;
import org.usc.daos.base.BaseDaoSupport;
import org.usc.services.teacher.ITeacherService;

/**
 * 老师服务实现类
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-3-9<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
// 业务逻辑层的类
public class TeacherServiceBean extends BaseDaoSupport<Teacher> implements ITeacherService
{

	/*
	 * @see org.usc.services.student.IStudentService#findByName(java.lang.String)
	 */
	public List<Teacher> findByPositional(String value)
	{
		return super.findByProperty("positional", value);
	}

}
