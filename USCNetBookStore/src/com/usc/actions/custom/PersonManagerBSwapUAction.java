package com.usc.actions.custom;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Custom;
import com.usc.services.custom.IPersonManage;

public class PersonManagerBSwapUAction extends ActionSupport {
	
	private float number;
	
	private  IPersonManage personmanage;

	public float getNumber() {
		return number;
	}

	public void setNumber(float number) {
		this.number = number;
	}

	
	public IPersonManage getPersonmanage() {
		return personmanage;
	}

	public void setPersonmanage(IPersonManage personmanage) {
		this.personmanage = personmanage;
	}

	@Override
	public String execute() throws Exception {
		Custom custom = (Custom)ActionContext.getContext().getSession().get("Custom");
		personmanage.BswapU(custom, number);
		return "success";
	}
	
	
	

}
