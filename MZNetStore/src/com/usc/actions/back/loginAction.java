package com.usc.actions.back;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Operator;
import com.usc.services.back.IManger;

/**
 * 后台登陆
 * @author MZ
 *
 */
public class loginAction extends ActionSupport
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
		} else
		{

			if (null == operator.getOperatorName()
					|| "".equals(operator.getOperatorName().trim()))// 姓名空
			{
				this.addFieldError("operator.operatorName", "姓名不能为空");
			}
			if (null == operator.getOperatorPass()
					|| "".equals(operator.getOperatorPass().trim()))// 密码空
			{
				this.addFieldError("operator.operatorPass", "密码不能为空");
			}
		}
		// System.out.println("validate");
		// System.out.println(operator.getOperatorName());
		// TODO Auto-generated method stub
		// super.validate();
	}

	@Override
	public String execute() throws Exception
	{
		if (null != operator)// 对象为空，返回，避免空指针异常
		{
			if (!manger.checkManger(operator))
			{
				this.addFieldError("operator.operatorName", "管理员登录失败，姓名或密码错误");
			} else
			{
				ActionContext.getContext().getSession().put("manger",
						operator.getOperatorName());
				return SUCCESS;
			}
		}
		return INPUT;
		// System.out.println("execute");
		// TODO Auto-generated method stub

		// ActionContext.getContext().getSession();
		// Map request = (Map) ActionContext.getContext().get("request");

		// request.put("list", service.findAll());
		// return super.execute();
	}
}
