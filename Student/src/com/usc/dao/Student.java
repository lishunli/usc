package com.usc.dao;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable
{

	// Fields

	private Integer sid;
	private String sno;
	private String sname;
	private String sex;
	private Integer age;
	private String gname;

	// Constructors

	/** default constructor */
	public Student()
	{
	}

	/** full constructor */
	public Student(String sno, String sname, String sex, Integer age,
			String gname)
	{
		this.sno = sno;
		this.sname = sname;
		this.sex = sex;
		this.age = age;
		this.gname = gname;
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

	public String getSno()
	{
		return this.sno;
	}

	public void setSno(String sno)
	{
		this.sno = sno;
	}

	public String getSname()
	{
		return this.sname;
	}

	public void setSname(String sname)
	{
		this.sname = sname;
	}

	public String getSex()
	{
		return this.sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public Integer getAge()
	{
		return this.age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	public String getGname()
	{
		return this.gname;
	}

	public void setGname(String gname)
	{
		this.gname = gname;
	}

}