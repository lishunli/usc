package com.bjsxt.drp.web.usermgr.forms;

import java.util.Date;

import org.apache.struts.action.ActionForm;

/**
 * �û�����ActionForm
 *
 */
public class UserActionForm extends ActionForm {
	
	//�û�����
	private String userId;
	
	//�û�����
	private String userName;
	
	//����
	private String password;
	
	//��ϵ�绰
	private String contactTel;
	
	//email
	private String email;
	
	//��������
	private Date createDate;
	
	//���ս����е�ѡ�б�ǵļ���
	private String[] selectFlag;
	
	public String getContactTel() {
		return contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String[] getSelectFlag() {
		return selectFlag;
	}

	public void setSelectFlag(String[] selectFlag) {
		this.selectFlag = selectFlag;
	}
}
