package org.usc.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.usc.beans.Student;
import org.usc.beans.base.PageView;
import org.usc.services.student.IStudentService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 列出所有的学生action，访问时action名称为student-list.action
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
	// @Resource(name = "studentServiceBean")
	@Autowired
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

	public String execute() throws Exception
	{
		/**
		 * 下面4句固定
		 */
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		int maxResult = 5;
		PageView<Student> pageView = new PageView<Student>(maxResult, getPage());
		/**
		 * 下面修改service即可
		 */
		pageView.setQueryResult(studentService.getScrollData(pageView.getFirstResult(), maxResult));
		/**
		 * request.setAttribute("pageView", pageView)中key尽量为pageView，不然需要修改代码
		 */
		request.setAttribute("pageView", pageView);
		return SUCCESS;
	}

}
