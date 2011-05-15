package org.usc.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.usc.services.student.IStudentService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2011-5-14<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
// @Controller("org.usc.actions.addStudentAction")
// @Scope("prototype")
// @Action(value = "addStudent", results = { @Result(name = "success", location = "student/studentList.jsp"), @Result(name = "input", location = "/index.jsp")
// })
//@Results({ @Result(name = "success", location = "student/studentList.jsp"), @Result(name = "input", location = "/index.jsp") })
public class AddStudentAction extends ActionSupport {

	private static final long serialVersionUID = -1724866613703052972L;

	public AddStudentAction() {
		System.out.println("Hello World");
	}

	@Autowired
	private IStudentService studentService;

	@Transactional
	public String execute() throws Exception {
		studentService.deleteStudents();
		studentService.saveStudents();

		return SUCCESS;
	}

}
