package com.usc.actions.custom;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Custom;
import com.usc.services.custom.IPersonManage;

public class PersonManagerCEmailAction extends ActionSupport {

	private IPersonManage personmanage;
	
	private String newEmail;

	public IPersonManage getPersonmanage() {
		return personmanage;
	}

	public void setPersonmanage(IPersonManage personmanage) {
		this.personmanage = personmanage;
	}



	public String getNewEmail() {
		return newEmail;
	}

	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}

	@Override
	public String execute() throws Exception {
		Custom custom = (Custom)ActionContext.getContext().getSession().get("Custom");
		personmanage.changeCustomEmail(custom, newEmail);
		return "success";
	}
	
}
