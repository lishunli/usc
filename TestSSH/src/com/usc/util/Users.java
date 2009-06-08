package com.usc.util;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable
{

	// Fields

	private Integer id;
	private String firstname;
	private String lastname;
	private Integer age;

	// Constructors

	/** default constructor */
	public Users()
	{
	}

	/** minimal constructor */
	public Users(String firstname, String lastname)
	{
		this.firstname = firstname;
		this.lastname = lastname;
	}

	/** full constructor */
	public Users(String firstname, String lastname, Integer age)
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}

	// Property accessors

	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getFirstname()
	{
		return this.firstname;
	}

	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	public String getLastname()
	{
		return this.lastname;
	}

	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}

	public Integer getAge()
	{
		return this.age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

}