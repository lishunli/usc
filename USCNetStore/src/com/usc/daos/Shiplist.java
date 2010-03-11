package com.usc.daos;

import java.util.Date;

/**
 * Shiplist entity. @author MyEclipse Persistence Tools
 */

public class Shiplist implements java.io.Serializable
{

	// Fields

	private Integer shipListId;
	private String shipperManager;
	private Date shipTime;
	private String shipListState;

	// Constructors

	/** default constructor */
	public Shiplist()
	{
	}

	/** full constructor */
	public Shiplist(String shipperManager, Date shipTime, String shipListState)
	{
		this.shipperManager = shipperManager;
		this.shipTime = shipTime;
		this.shipListState = shipListState;
	}

	// Property accessors

	public Integer getShipListId()
	{
		return this.shipListId;
	}

	public void setShipListId(Integer shipListId)
	{
		this.shipListId = shipListId;
	}

	public String getShipperManager()
	{
		return this.shipperManager;
	}

	public void setShipperManager(String shipperManager)
	{
		this.shipperManager = shipperManager;
	}

	public Date getShipTime()
	{
		return this.shipTime;
	}

	public void setShipTime(Date shipTime)
	{
		this.shipTime = shipTime;
	}

	public String getShipListState()
	{
		return this.shipListState;
	}

	public void setShipListState(String shipListState)
	{
		this.shipListState = shipListState;
	}

}