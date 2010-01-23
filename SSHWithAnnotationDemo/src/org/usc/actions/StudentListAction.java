package org.usc.actions;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.usc.beans.PageView;
import org.usc.beans.Student;
import org.usc.services.student.IStudentService;

import com.opensymphony.xwork2.ActionContext;
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

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
// 声明此类为控制层的类,且为prototype模式调用
@Results(
{ @Result(name = "success", location = "student/studentList.jsp"), @Result(name = "input", location = "/index.jsp") })
public class StudentListAction extends ActionSupport
{
	@Resource(name = "studentService")
	private IStudentService studentService;
	private int page;
	
	public int getPage()
	{
		return page;
	}


	public void setPage(int page)
	{
		this.page = page;
	}


	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
//		System.out.println((getPage()<=0?1:getPage())-1);
//		System.err.println(getPage());
		
		ActionContext ctx = ActionContext.getContext();       
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);   
		int maxResult = 7;
//		Map request1 = (Map) ActionContext.getContext().get("request");
		PageView<Student> pageView = new PageView<Student>(maxResult, getPage()<=0?1:getPage());
		pageView.setQueryResult(studentService.getScrollData(((getPage()<=0?1:getPage())-1)*maxResult,maxResult));
//		for(Student student:studentService.getScrollData(0,5).getResultlist())
//		{
//			System.out.println(student);
//		}
		request.setAttribute("pageView", pageView);
//		request1.put("studentList",studentService.getScrollData().getResultlist());
		return SUCCESS;
	}

}
