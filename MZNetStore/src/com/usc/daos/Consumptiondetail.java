package com.usc.daos;

import java.util.Date;

/**
 * Consumptiondetail entity. @author MyEclipse Persistence Tools
 */

public class Consumptiondetail implements java.io.Serializable
{

	// Fields

	private Integer consumptionId;
	private Custom custom;
	private Orderform orderform;
	private Float last;
	private Float current;
	private Date consumptionDate;

	// Constructors

	/** default constructor */
	public Consumptiondetail()
	{
	}

	/** minimal constructor */
	public Consumptiondetail(Float last, Float current, Date consumptionDate)
	{
		this.last = last;
		this.current = current;
		this.consumptionDate = consumptionDate;
	}

	/** full constructor */
	public Consumptiondetail(Custom custom, Orderform orderform, Float last,
			Float current, Date consumptionDate)
	{
		this.custom = custom;
		this.orderform = orderform;
		this.last = last;
		this.current = current;
		this.consumptionDate = consumptionDate;
	}

	// Property accessors

	public Integer getConsumptionId()
	{
		return this.consumptionId;
	}

	public void setConsumptionId(Integer consumptionId)
	{
		this.consumptionId = consumptionId;
	}

	public Custom getCustom()
	{
		return this.custom;
	}

	public void setCustom(Custom custom)
	{
		this.custom = custom;
	}

	public Orderform getOrderform()
	{
		return this.orderform;
	}

	public void setOrderform(Orderform orderform)
	{
		this.orderform = orderform;
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

	public Date getConsumptionDate()
	{
		return this.consumptionDate;
	}

	public void setConsumptionDate(Date consumptionDate)
	{
		this.consumptionDate = consumptionDate;
	}

}