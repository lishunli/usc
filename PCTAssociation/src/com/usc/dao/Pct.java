package com.usc.dao;

/**
 * Pct entity. @author MyEclipse Persistence Tools
 */

public class Pct implements java.io.Serializable
{

	// Fields

	private Integer id;
	private String pctid;
	private String pctname;

	// Constructors

	/** default constructor */
	public Pct()
	{
	}

	/** full constructor */
	public Pct(String pctid, String pctname)
	{
		this.pctid = pctid;
		this.pctname = pctname;
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

	public String getPctid()
	{
		return this.pctid;
	}

	public void setPctid(String pctid)
	{
		this.pctid = pctid;
	}

	public String getPctname()
	{
		return this.pctname;
	}

	public void setPctname(String pctname)
	{
		this.pctname = pctname;
	}

}