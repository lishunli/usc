package com.usc.actions.back;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Operator;
import com.usc.services.back.IManger;

/**
 * ��ӹ���Ա
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
	private Operator operator;// ����Ա����ͨ��Struts2������
	private IManger manger;// �ӿ�ʵ�ֶ���ͨ��Springע��

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
		if (null == operator)// ����Ϊ�գ����أ������ָ���쳣
		{
			return;
		}
		else
		{
			if (null == operator.getOperatorName() || "".equals(operator.getOperatorName().trim()))// ������
			{
				this.addFieldError("operator.operatorName", "��������Ϊ��");
			}
		}
	}
	
	@Override
	public String execute() throws Exception
	{
		if (null != operator)// ����Ϊ�գ����أ������ָ���쳣
		{
			if (manger.checkMangerIsExist(operator))
			{
				this.addFieldError("operator.operatorName", "����Ա�����Ѿ�����");
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
