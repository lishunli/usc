package org.usc.daos;

import java.util.Date;

/**
 * AbstractStudent entity provides the base persistence definition of the
 * Student entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractStudent implements java.io.Serializable
{

	// Fields

	private String no;
	private String name;
	private String sex;
	private Integer age;
	private Double score;
	private Date eduTime;

	// Constructors

	/** default constructor */
	public AbstractStudent()
	{
	}

	/** minimal constructor */
	public AbstractStudent(String no, String name, String sex)
	{
		this.no = no;
		this.name = name;
		this.sex = sex;
	}

	/** full constructor */
	public AbstractStudent(String no, String name, String sex, Integer age,
			Double score, Date eduTime)
	{
		this.no = no;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.score = score;
		this.eduTime = eduTime;
	}

	// Property accessors

	public String getNo()
	{
		return this.no;
	}

	public void setNo(String no)
	{
		this.no = no;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
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

	public Double getScore()
	{
		return this.score;
	}


	public void setScore(Double score)
	{
		this.score = score;
	}

	public Date getEduTime()
	{
		return this.eduTime;
	}

	public void setEduTime(Date eduTime)
	{
		this.eduTime = eduTime;
	}

	

}