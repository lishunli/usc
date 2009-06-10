package com.usc.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.usc.dao.Grade;
import com.usc.service.StudentManager;

public class gradeNameAction extends ActionSupport
{
	private List gradeName;
	private StudentManager sm;

	public List getGradeName()
	{
		return gradeName;
	}
	
	public void setSm(StudentManager sm)
	{
		this.sm = sm;
	}

	public String getAllGradeName() { 
		for(Grade grade : sm.showgrade())
		{
			
			System.out.println(grade.getGname());
//			gradeName.add((Object)grade.getGname());
		}
//		String s = new String("2");
//		gradeName.add("1");
//		gradeName.add(s);
		gradeName = sm.showgrade();
        return null;   
    }  	
	
}
