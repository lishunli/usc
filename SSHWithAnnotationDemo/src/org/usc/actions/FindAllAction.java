package org.usc.actions;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.usc.beans.Student;
import org.usc.services.student.IStudentService;

import com.opensymphony.xwork2.ActionSupport;

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

@Controller
@Scope("prototype")
// 声明此类为控制层的类,且为prototype模式调用
@Results(
{ @Result(name = "success", location = "/index.jsp"), @Result(name = "input", location = "/index.jsp") })
public class FindAllAction extends ActionSupport
{
	@Resource(name = "studentService")
	private IStudentService studentService;

	public String execute() throws Exception
	{
		for (Student student : studentService.findAll())
		{
			System.out.println(student);
		}
		return SUCCESS;
	}

}
