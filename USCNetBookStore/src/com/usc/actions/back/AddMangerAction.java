package com.usc.actions.back;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Operator;
import com.usc.services.back.IManger;

/**
 * 添加管理员
 *
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-5-9<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
public class AddMangerAction extends ActionSupport
{
	private Operator operator;// 管理员对象，通过Struts2传过来
	private IManger manger;// 接口实现对象，通过Spring注入

	public Operator getOperator()
	{
		return operator;
	}

	public void setOperator(Operator operator)
	{
		this.operator = operator;
	}

	public void setManger(IManger manger)
	{
		this.manger = manger;
	}
	
	
	@Override
	public void validate()
	{
		if (null == operator)// 对象为空，返回，避免空指针异常
		{
			return;
		}
		else
		{
			if (null == operator.getOperatorName() || "".equals(operator.getOperatorName().trim()))// 姓名空
			{
				this.addFieldError("operator.operatorName", "姓名不能为空");
			}
		}
	}
	
	@Override
	public String execute() throws Exception
	{
		if (null != operator)// 对象为空，返回，避免空指针异常
		{
			if (manger.checkMangerIsExist(operator))
			{
				this.addFieldError("operator.operatorName", "管理员姓名已经存在");
			}
			else
			{
				manger.saveOperator(operator);
				return SUCCESS;
			}
		}
		return INPUT;
	}
}
