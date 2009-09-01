package com.usc.actions.custom;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Custom;
import com.usc.services.custom.IPersonManage;

public class PersonManagerCPasswordAction extends ActionSupport {

	private IPersonManage personmanage;
	
	private String oldPassword;
	
	private String newPassword;
	
	private String newPasswordOk;

	public IPersonManage getPersonmanage() {
		return personmanage;
	}

	public void setPersonmanage(IPersonManage personmanage) {
		this.personmanage = personmanage;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewPasswordOk() {
		return newPasswordOk;
	}

	public void setNewPasswordOk(String newPasswordOk) {
		this.newPasswordOk = newPasswordOk;
	}

	@Override
	public String execute() throws Exception {
		Custom custom = (Custom)ActionContext.getContext().getSession().get("Custom");
       if(custom.getCustomPass().equals(encoderByMd5(oldPassword)) && !newPassword.equals("") &&!newPasswordOk.equals("") &&newPassword.trim().equals(newPasswordOk.trim()) )
		{
    	   newPassword  = encoderByMd5(newPassword);
    	   personmanage.changeCustomPassword(custom, newPassword);
		   return "success";
		}
       else return "error";
		
	}
	
	public String encoderByMd5(String password)
	{
		String resultString = null;
		resultString = new String(password);
		MessageDigest md;// ��ϢժҪ
		try
		{
			md = MessageDigest.getInstance("MD5");// ʵ��
			md.update(password.getBytes());
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < digest.length; i++)
			{
				sb.append(Integer.toHexString(((int) digest[i]) & 0xFF));
			}
			resultString = sb.toString();
		} catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		return resultString;
	}
}
