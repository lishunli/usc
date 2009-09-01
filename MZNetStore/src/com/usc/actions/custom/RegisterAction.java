package com.usc.actions.custom;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Custom;
import com.usc.services.custom.Impl.BeforeMainImpl;

public class RegisterAction extends ActionSupport {

	private Custom custom;
	private BeforeMainImpl beforemainimpl; 
	private String recustomPass;
	
	@Override
	public String execute() throws Exception {
		String customPassword = custom.getCustomPass();
		custom.setConsumption(0f);
		custom.setUcurrency(0f);
		custom.setBenefits(0f);
		custom.setVipFlag(0);
		custom.setVipDate(new Date());
		custom.setActiveFlag(1);		
		if(custom.getCustomName()!=null && !custom.getCustomName().equals("") && custom.getCustomPass().trim().equals(recustomPass.trim()))
		{
			//HttpServletRequest request = ServletActionContext.getRequest();
			//request.setAttribute("costomname", custom.getCustomName());

			custom.setCustomPass(beforemainimpl.encoderByMd5(custom.getCustomPass().trim()));
			beforemainimpl.saveCustom(custom);
               return "success";
         }
		else return "error";
	}

	public Custom getCustom() {
		return custom;
	}

	public void setCustom(Custom custom) {
		this.custom = custom;
	}

	public BeforeMainImpl getBeforemainimpl() {
		return beforemainimpl;
	}

	public void setBeforemainimpl(BeforeMainImpl beforemainimpl) {
		this.beforemainimpl = beforemainimpl;
	}

	public String getRecustomPass() {
		return recustomPass;
	}

	public void setRecustomPass(String recustomPass) {
		this.recustomPass = recustomPass;
	}



}
