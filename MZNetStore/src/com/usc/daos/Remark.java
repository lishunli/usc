package com.usc.daos;

import java.util.Date;

/**
 * Remark entity. @author MyEclipse Persistence Tools
 */

public class Remark implements java.io.Serializable
{

	// Fields

	private Integer remarkId;
	private Custom custom;
	private Commodity commodity;
	private String remarkContents;
	private Date remarkTime;
	private Integer remarkFlag;

	// Constructors

	/** default constructor */
	public Remark()
	{
	}

	/** minimal constructor */
	public Remark(String remarkContents, Date remarkTime, Integer remarkFlag)
	{
		this.remarkContents = remarkContents;
		this.remarkTime = remarkTime;
		this.remarkFlag = remarkFlag;
	}

	/** full constructor */
	public Remark(Custom custom, Commodity commodity, String remarkContents,
			Date remarkTime, Integer remarkFlag)
	{
		this.custom = custom;
		this.commodity = commodity;
		this.remarkContents = remarkContents;
		this.remarkTime = remarkTime;
		this.remarkFlag = remarkFlag;
	}

	// Property accessors

	public Integer getRemarkId()
	{
		return this.remarkId;
	}

	public void setRemarkId(Integer remarkId)
	{
		this.remarkId = remarkId;
	}

	public Custom getCustom()
	{
		return this.custom;
	}

	public void setCustom(Custom custom)
	{
		this.custom = custom;
	}

	public Commodity getCommodity()
	{
		return this.commodity;
	}

	public void setCommodity(Commodity commodity)
	{
		this.commodity = commodity;
	}

	public String getRemarkContents()
	{
		return this.remarkContents;
	}

	public void setRemarkContents(String remarkContents)
	{
		this.remarkContents = remarkContents;
	}

	public Date getRemarkTime()
	{
		return this.remarkTime;
	}

	public void setRemarkTime(Date remarkTime)
	{
		this.remarkTime = remarkTime;
	}

	public Integer getRemarkFlag()
	{
		return this.remarkFlag;
	}

	public void setRemarkFlag(Integer remarkFlag)
	{
		this.remarkFlag = remarkFlag;
	}

}