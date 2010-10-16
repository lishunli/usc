package org.usc.actions;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 *
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-9-3<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
public class DisplayErrorInfoAction extends ActionSupport
{
	private static final long serialVersionUID = -2690064846056775963L;

	@Override
	public String execute() throws Exception
	{
		/**
		 * 添加一些FieldError供测试，如果需要请自写validater方法
		 */
		this.addFieldError("displayErrorInfo", "error!Please check it.");
		this.addFieldError("user.username", "名字有错误啦");
		return INPUT;
	}
}
