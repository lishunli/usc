package com.usc.daos;

import java.util.Date;

/**
 * Ucurrencydetail entity. @author MyEclipse Persistence Tools
 */

public class Ucurrencydetail implements java.io.Serializable
{

	// Fields

	private Integer ucurrencyId;
	private Custom custom;
	private Float last;
	private Float current;
	private String source;
	private String destination;
	private Date ucurrencyDate;

	// Constructors

	/** default constructor */
	public Ucurrencydetail()
	{
	}

	/** minimal constructor */
	public Ucurrencydetail(Float last, Float current, String source,
			String destination, Date ucurrencyDate)
	{
		this.last = last;
		this.current = current;
		this.source = source;
		this.destination = destination;
		this.ucurrencyDate = ucurrencyDate;
	}

	/** full constructor */
	public Ucurrencydetail(Custom custom, Float last, Float current,
			String source, String destination, Date ucurrencyDate)
	{
		this.custom = custom;
		this.last = last;
		this.current = current;
		this.source = source;
		this.destination = destination;
		this.ucurrencyDate = ucurrencyDate;
	}

	// Property accessors

	public Integer getUcurrencyId()
	{
		return this.ucurrencyId;
	}

	public void setUcurrencyId(Integer ucurrencyId)
	{
		this.ucurrencyId = ucurrencyId;
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

	public String getSource()
	{
		return this.source;
	}

	public void setSource(String source)
	{
		this.source = source;
	}

	public String getDestination()
	{
		return this.destination;
	}

	public void setDestination(String destination)
	{
		this.destination = destination;
	}

	public Date getUcurrencyDate()
	{
		return this.ucurrencyDate;
	}

	public void setUcurrencyDate(Date ucurrencyDate)
	{
		this.ucurrencyDate = ucurrencyDate;
	}

}