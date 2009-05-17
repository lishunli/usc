package com.DAOTest;

import java.util.HashSet;
import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable
{

	// Fields

	private Integer studentid;
	private String studentName;

	// Constructors

	/** default constructor */
	public Student()
	{
	}

	/** minimal constructor */
	public Student(String studentName)
	{
		this.studentName = studentName;
	}


	// Property accessors

	public Integer getStudentid()
	{
		return this.studentid;
	}

	public void setStudentid(Integer studentid)
	{
		this.studentid = studentid;
	}

	public String getStudentName()
	{
		return this.studentName;
	}

	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
	}


}