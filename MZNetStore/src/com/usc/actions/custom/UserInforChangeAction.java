package com.usc.actions.custom;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Custom;
import com.usc.daos.CustomDAO;
import com.usc.services.custom.IPersonManage;


public class UserInforChangeAction  extends ActionSupport {
	
	private  IPersonManage personmanage;

	private String realName;
	
	private String  sex; 
	
	private String address; 
	
	private String postCode;
	
	private String mobile;
	
	private String phone;

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String execute() throws Exception {
		Custom custom = (Custom)ActionContext.getContext().getSession().get("Custom");
		personmanage.changeCustomInfo(custom, realName, sex, address, postCode, mobile, phone);
		return "success";
	}



	public IPersonManage getPersonmanage() {
		return personmanage;
	}

	public void setPersonmanage(IPersonManage personmanage) {
		this.personmanage = personmanage;
	}
}
