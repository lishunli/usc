package org.usc.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.usc.action.base.BaseActionSupport;
import org.usc.bean.Teacher;
import org.usc.bean.base.PageView;
import org.usc.service.teacher.ITeacherService;

import com.opensymphony.xwork2.ActionContext;

/**
 * 列出所有的学生action，访问时action名称为teacher-list.action
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-1-17<br>
 *        Revision of last commit:$Revision: 632 $<br>
 *        Author of last commit:$Author: nhjsjmz@gmail.com $<br>
 *        Date of last commit:$Date: 2010-01-25 16:47:12 +0800 (周一, 25 一月 2010) $<br>
 *        <p>
 */

@SuppressWarnings("serial")
@Results( { @Result(name = "success", location = "teacher/teacherList.jsp"), @Result(name = "input", location = "/index.jsp") })
public class TeacherListAction extends BaseActionSupport
{
	@Autowired
	private ITeacherService teacherService;

	public String execute() throws Exception
	{
		/**
		 * 下面3句固定
		 */
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		int maxResult = 5;

		PageView<Teacher> pageView = new PageView<Teacher>(maxResult, getPage());
		/**
		 * 下面修改service即可
		 */
		pageView.setQueryResult(teacherService.getScrollData(pageView.getFirstResult(), maxResult));
		/**
		 * request.setAttribute("pageView", pageView)中key尽量为pageView，不然需要修改代码
		 */
		request.setAttribute("pageView", pageView);
		return SUCCESS;
	}

}
