package com.usc.actions.back;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Operator;
import com.usc.services.back.IManger;

/**
 * 修改密码
 * @author MZ
 *
 */
public class UpdatePassAction extends ActionSupport
{
	private Operator operator;// 管理员对象，通过Struts2传过来
	private IManger manger;// 接口实现对象，通过Spring注入
	//	private String oldPass;//原密码
	private String newPass;//新密码
	private String reNewPass;//重复密码

	public Operator getOperator()
	{
		return operator;
	}

	public void setOperator(Operator operator)
	{
		this.operator = operator;
		this.operator.setOperatorName(ActionContext.getContext().getSession()
				.get("manger").toString());
	}

	public void setManger(IManger manger)
	{
		this.manger = manger;
	}

	public String getNewPass()
	{
		return newPass;
	}

	public void setNewPass(String newPass)
	{
		this.newPass = newPass;
	}

	public String getReNewPass()
	{
		return reNewPass;
	}

	public void setReNewPass(String reNewPass)
	{
		this.reNewPass = reNewPass;
	}

	@Override
	public void validate()
	{
		if (null == operator)
		{
		} else
		{
			if (null == operator.getOperatorPass()
					|| "".equals(operator.getOperatorPass().trim()))// 密码空
			{
				this.addFieldError("operator.operatorPass", "原密码不能为空");
			}
			if(null == newPass || "".equals(newPass))// 新密码空
			{
				this.addFieldError("newPass", "新密码不能为空");
			}
			else if(!newPass.equals(reNewPass))//重复新密码和新密码不一样
			{
				this.addFieldError("reNewPass", "重复新密码和新密码不一样");
			}
			//			System.out.println(operator.getOperatorName() + "  " + operator.getOperatorPass() + "  " + newPass);
		}

	}

	@Override
	public String execute() throws Exception
	{
		if (null != operator)
		{
			if (manger.updatePass(operator, newPass))//修改成功
				return SUCCESS;
			else//修改失败，请重新修改
			{
				this.addFieldError("operator.operatorPass", "修改失败，请重新修改");
			}
		}
		return INPUT;

	}

}
