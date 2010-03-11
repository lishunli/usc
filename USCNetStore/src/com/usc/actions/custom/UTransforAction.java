package com.usc.actions.custom;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Custom;
import com.usc.services.custom.Impl.IPersonManageImpl;

public class UTransforAction extends ActionSupport {
	
	private IPersonManageImpl personmanage;

	private String Customname;
	
	private float  Unumber;

	public IPersonManageImpl getPersonmanage() {
		return personmanage;
	}

	public void setPersonmanage(IPersonManageImpl personmanage) {
		this.personmanage = personmanage;
	}

	public String getCustomname() {
		return Customname;
	}

	public void setCustomname(String customname) {
		Customname = customname;
	}

	public float getUnumber() {
		return Unumber;
	}

	public void setUnumber(float unumber) {
		Unumber = unumber;
	}

	@Override
	public String execute() throws Exception {
		Custom custom = (Custom)ActionContext.getContext().getSession().get("Custom");
		personmanage.UTransfor(custom, Customname, Unumber);
		return "success";
	}
	
	
}
