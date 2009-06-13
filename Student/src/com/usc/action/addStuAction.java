package com.usc.action;

import com.opensymphony.xwork2.ActionSupport;
import com.usc.dao.Student;
import com.usc.service.StudentManager;

public class addStuAction extends ActionSupport
{
	private Student stu;
	private StudentManager sm;
	private String gname;

	public String getGname()
	{
		return gname;
	}

	public void setGname(String gname)
	{
		this.gname = gname;
	}

	public Student getStu()
	{
		return stu;
	}

	public void setStu(Student stu)
	{
		this.stu = stu;
	}

	public StudentManager getSm()
	{
		return sm;
	}

	public void setSm(StudentManager sm)
	{
		this.sm = sm;
	}

	@Override
	public String execute() throws Exception
	{
		// stu.setGname(gname);
		if (sm.checksid(stu.getSno()))
		{
//			System.out.println("学号已存在！");
//			this.addFieldError("sno", "学号已存在！");
			return ERROR;
		} else
		{
			sm.addStu(stu);
			return SUCCESS;
		}
	}
//	@Override
//	public void validate()
//	{
//		if("1" == stu.getSno().trim())
//		{
//			System.out.println("aaa");
//			this.addFieldError("stu.sno", "sno required");
//		}
//		else{
//			System.out.println("nnn");
//			this.addFieldError("stu.sno", "sno required");
//		}
//	}

}
