package com.usc.daos;

import java.util.Date;

/**
 * Stockin entity. @author MyEclipse Persistence Tools
 */

public class Stockin implements java.io.Serializable
{

	// Fields

	private Integer stockInId;
	private Operator operator;
	private Products products;
	private Float purchasedPrice;
	private Integer stockInQuantity;
	private String supplier;
	private Date stockInTime;
	private String remark;

	// Constructors

	/** default constructor */
	public Stockin()
	{
	}

	/** minimal constructor */
	public Stockin(Float purchasedPrice, Integer stockInQuantity,
			Date stockInTime)
	{
		this.purchasedPrice = purchasedPrice;
		this.stockInQuantity = stockInQuantity;
		this.stockInTime = stockInTime;
	}

	/** full constructor */
	public Stockin(Operator operator, Products products, Float purchasedPrice,
			Integer stockInQuantity, String supplier, Date stockInTime,
			String remark)
	{
		this.operator = operator;
		this.products = products;
		this.purchasedPrice = purchasedPrice;
		this.stockInQuantity = stockInQuantity;
		this.supplier = supplier;
		this.stockInTime = stockInTime;
		this.remark = remark;
	}

	// Property accessors

	public Integer getStockInId()
	{
		return this.stockInId;
	}

	public void setStockInId(Integer stockInId)
	{
		this.stockInId = stockInId;
	}

	public Operator getOperator()
	{
		return this.operator;
	}

	public void setOperator(Operator operator)
	{
		this.operator = operator;
	}

	public Products getProducts()
	{
		return this.products;
	}

	public void setProducts(Products products)
	{
		this.products = products;
	}

	public Float getPurchasedPrice()
	{
		return this.purchasedPrice;
	}

	public void setPurchasedPrice(Float purchasedPrice)
	{
		this.purchasedPrice = purchasedPrice;
	}

	public Integer getStockInQuantity()
	{
		return this.stockInQuantity;
	}

	public void setStockInQuantity(Integer stockInQuantity)
	{
		this.stockInQuantity = stockInQuantity;
	}

	public String getSupplier()
	{
		return this.supplier;
	}

	public void setSupplier(String supplier)
	{
		this.supplier = supplier;
	}

	public Date getStockInTime()
	{
		return this.stockInTime;
	}

	public void setStockInTime(Date stockInTime)
	{
		this.stockInTime = stockInTime;
	}

	public String getRemark()
	{
		return this.remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

}