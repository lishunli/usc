package com.pojo;

/**
 * Stu entity. @author MyEclipse Persistence Tools
 */

public class Stu implements java.io.Serializable
{

	// Fields

	private Integer sid;
	private Classes classes;
	private String sname;

	// Constructors

	/** default constructor */
	public Stu()
	{
	}

	/** full constructor */
	public Stu(Classes classes, String sname)
	{
		this.classes = classes;
		this.sname = sname;
	}

	// Property accessors

	public Integer getSid()
	{
		return this.sid;
	}

	public void setSid(Integer sid)
	{
		this.sid = sid;
	}

	public Classes getClasses()
	{
		return this.classes;
	}

	public void setClasses(Classes classes)
	{
		this.classes = classes;
	}

	public String getSname()
	{
		return this.sname;
	}

	public void setSname(String sname)
	{
		this.sname = sname;
	}

}