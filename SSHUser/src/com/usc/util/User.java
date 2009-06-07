package com.usc.util;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable
{

	// Fields

	private String usename;
	private String password;

	// Constructors

	/** default constructor */
	public User()
	{
	}

	/** full constructor */
	public User(String usename, String password)
	{
		this.usename = usename;
		this.password = password;
	}

	// Property accessors

	public String getUsename()
	{
		return this.usename;
	}

	public void setUsename(String usename)
	{
		this.usename = usename;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

}