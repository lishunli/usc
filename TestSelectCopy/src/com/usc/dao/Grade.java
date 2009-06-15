package com.usc.dao;

/**
 * Grade entity. @author MyEclipse Persistence Tools
 */

public class Grade implements java.io.Serializable
{

	// Fields

	private Integer gno;
	private String gname;

	// Constructors

	/** default constructor */
	public Grade()
	{
	}

	/** full constructor */
	public Grade(String gname)
	{
		this.gname = gname;
	}

	// Property accessors

	public Integer getGno()
	{
		return this.gno;
	}

	public void setGno(Integer gno)
	{
		this.gno = gno;
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