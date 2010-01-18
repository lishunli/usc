package org.usc.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Struts2.16+Annotation实现零配置
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-1-18<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
// 全局Results
@Results(
{ @Result(name = "success", location = "/index.jsp", type = "dispatcher"),// WebRoot/index.jsp
		@Result(name = "input", location = "hello.jsp", type = "dispatcher") // WebRoot/WEB-INF/content/hello.jsp
})
public class DemoAction extends ActionSupport
{
	public String execute() throws Exception
	{
		System.out.println("Test Demo");
		return SUCCESS;
	}

	/**
	 * 局部的Action可以通过test,test.action,demo!test,demo!test,demo!test.action访问
	 * @return
	 * @throws Exception
	 */
	@Action(value = "test", results =
	{ @Result(name = "success", location = "http://www.blogjava.net/lishunli", type = "redirect") })
	public String test() throws Exception
	{
		System.out.println("test ! ");
		return SUCCESS;
	}
}
