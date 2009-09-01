package com.usc.daos;

import java.util.Date;

/**
 * Orderstate entity. @author MyEclipse Persistence Tools
 */

public class Orderstate implements java.io.Serializable
{

	// Fields

	private Integer orderStateId;
	private Orderform orderform;
	private String lastState;
	private String currentState;
	private String changer;
	private Date changeTime;

	// Constructors

	/** default constructor */
	public Orderstate()
	{
	}

	/** minimal constructor */
	public Orderstate(Date changeTime)
	{
		this.changeTime = changeTime;
	}

	/** full constructor */
	public Orderstate(Orderform orderform, String lastState,
			String currentState, String changer, Date changeTime)
	{
		this.orderform = orderform;
		this.lastState = lastState;
		this.currentState = currentState;
		this.changer = changer;
		this.changeTime = changeTime;
	}

	// Property accessors

	public Integer getOrderStateId()
	{
		return this.orderStateId;
	}

	public void setOrderStateId(Integer orderStateId)
	{
		this.orderStateId = orderStateId;
	}

	public Orderform getOrderform()
	{
		return this.orderform;
	}

	public void setOrderform(Orderform orderform)
	{
		this.orderform = orderform;
	}

	public String getLastState()
	{
		return this.lastState;
	}

	public void setLastState(String lastState)
	{
		this.lastState = lastState;
	}

	public String getCurrentState()
	{
		return this.currentState;
	}

	public void setCurrentState(String currentState)
	{
		this.currentState = currentState;
	}

	public String getChanger()
	{
		return this.changer;
	}

	public void setChanger(String changer)
	{
		this.changer = changer;
	}

	public Date getChangeTime()
	{
		return this.changeTime;
	}

	public void setChangeTime(Date changeTime)
	{
		this.changeTime = changeTime;
	}

}