package org.usc.services.student.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.usc.beans.Student;
import org.usc.beans.base.QueryResult;
import org.usc.daos.StudentDao;
import org.usc.services.student.IStudentService;

/**
 * 学生服务实现类
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-1-17<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
// 声明此类为业务逻辑层的类
//@Service("org.usc.services.studentService")
@Service
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private StudentDao studentDao;

	public List<Student> findByName(String value) {
		return this.studentDao.findByProperty("name", value);
	}

	public QueryResult<Student> getScrollData(int firstindex, int maxresult, String wherejpql, Object[] queryParams) {
		return this.studentDao.getScrollData(firstindex, maxresult, wherejpql, queryParams);
	}

	public void save(Student student) {
		this.studentDao.save(student);
	}

	public void saveStudents() {
		for (int i = 0; i < 100; i++) {
			Student student = new Student("lishunl_" + i, "M", i % 20, 90.0, new Date());
			save(student);
			
			if(i == 10){
				throw new RuntimeException();
			}
		}
	}

	public void deleteStudents() {
		for(Student stu : studentDao.getScrollData().getResultList()){
			studentDao.delete(stu.getNo());
		}
	}

}
