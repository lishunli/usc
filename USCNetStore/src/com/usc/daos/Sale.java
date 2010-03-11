package com.usc.daos;

/**
 * Sale entity. @author MyEclipse Persistence Tools
 */

public class Sale implements java.io.Serializable
{

	// Fields

	private Integer saleCommodityId;
	private Integer commodityId;
	private Integer operatorID;
	private Float salePrice;
	private Integer priority;

	// Constructors

	/** default constructor */
	public Sale()
	{
	}

	/** minimal constructor */
	public Sale(Float salePrice, Integer priority)
	{
		this.salePrice = salePrice;
		this.priority = priority;
	}

	/** full constructor */
	public Sale(Integer commodityId, Integer operatorID, Float salePrice,
			Integer priority)
	{
		this.commodityId = commodityId;
		this.operatorID = operatorID;
		this.salePrice = salePrice;
		this.priority = priority;
	}

	// Property accessors

	public Integer getSaleCommodityId()
	{
		return this.saleCommodityId;
	}

	public void setSaleCommodityId(Integer saleCommodityId)
	{
		this.saleCommodityId = saleCommodityId;
	}


	public Integer getCommodityId()
	{
		return commodityId;
	}

	public void setCommodityId(Integer commodityId)
	{
		this.commodityId = commodityId;
	}

	public Integer getOperatorID()
	{
		return operatorID;
	}

	public void setOperatorID(Integer operatorID)
	{
		this.operatorID = operatorID;
	}

	public Float getSalePrice()
	{
		return this.salePrice;
	}

	public void setSalePrice(Float salePrice)
	{
		this.salePrice = salePrice;
	}

	public Integer getPriority()
	{
		return this.priority;
	}

	public void setPriority(Integer priority)
	{
		this.priority = priority;
	}

}