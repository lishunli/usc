package com.usc.daos;

import java.util.Date;

/**
 * Benefitsdetail entity. @author MyEclipse Persistence Tools
 */

public class Benefitsdetail implements java.io.Serializable
{

	// Fields

	private Integer benefitsId;
	private Custom custom;
	private Float last;
	private Float current;
	private String explanation;
	private String type;
	private Date benefitsDate;

	// Constructors

	/** default constructor */
	public Benefitsdetail()
	{
	}

	/** minimal constructor */
	public Benefitsdetail(Float last, Float current, String explanation,
			String type, Date benefitsDate)
	{
		this.last = last;
		this.current = current;
		this.explanation = explanation;
		this.type = type;
		this.benefitsDate = benefitsDate;
	}

	/** full constructor */
	public Benefitsdetail(Custom custom, Float last, Float current,
			String explanation, String type, Date benefitsDate)
	{
		this.custom = custom;
		this.last = last;
		this.current = current;
		this.explanation = explanation;
		this.type = type;
		this.benefitsDate = benefitsDate;
	}

	// Property accessors

	public Integer getBenefitsId()
	{
		return this.benefitsId;
	}

	public void setBenefitsId(Integer benefitsId)
	{
		this.benefitsId = benefitsId;
	}

	public Custom getCustom()
	{
		return this.custom;
	}

	public void setCustom(Custom custom)
	{
		this.custom = custom;
	}

	public Float getLast()
	{
		return this.last;
	}

	public void setLast(Float last)
	{
		this.last = last;
	}

	public Float getCurrent()
	{
		return this.current;
	}

	public void setCurrent(Float current)
	{
		this.current = current;
	}

	public String getExplanation()
	{
		return this.explanation;
	}

	public void setExplanation(String explanation)
	{
		this.explanation = explanation;
	}

	public String getType()
	{
		return this.type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public Date getBenefitsDate()
	{
		return this.benefitsDate;
	}

	public void setBenefitsDate(Date benefitsDate)
	{
		this.benefitsDate = benefitsDate;
	}

}