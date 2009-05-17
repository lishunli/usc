package com.pojo;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable
{

	// Fields

	private Integer uid;
	private String uname;
	private String upass;

	// Constructors

	/** default constructor */
	public Users()
	{
	}

	/** full constructor */
	public Users(String uname, String upass)
	{
		this.uname = uname;
		this.upass = upass;
	}

	// Property accessors

	public Integer getUid()
	{
		return this.uid;
	}

	public void setUid(Integer uid)
	{
		this.uid = uid;
	}

	public String getUname()
	{
		return this.uname;
	}

	public void setUname(String uname)
	{
		this.uname = uname;
	}

	public String getUpass()
	{
		return this.upass;
	}

	public void setUpass(String upass)
	{
		this.upass = upass;
	}

}