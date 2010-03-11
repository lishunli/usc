package com.usc.daos;

import java.util.Date;

/**
 * Stockout entity. @author MyEclipse Persistence Tools
 */

public class Stockout implements java.io.Serializable
{

	// Fields

	private Integer stockOutId;
	private Operator operator;
	private Products products;
	private Integer stockOutQuantity;
	private Date stockOuttTime;
	private String remark;

	// Constructors

	/** default constructor */
	public Stockout()
	{
	}

	/** minimal constructor */
	public Stockout(Integer stockOutQuantity, Date stockOuttTime)
	{
		this.stockOutQuantity = stockOutQuantity;
		this.stockOuttTime = stockOuttTime;
	}

	/** full constructor */
	public Stockout(Operator operator, Products products,
			Integer stockOutQuantity, Date stockOuttTime, String remark)
	{
		this.operator = operator;
		this.products = products;
		this.stockOutQuantity = stockOutQuantity;
		this.stockOuttTime = stockOuttTime;
		this.remark = remark;
	}

	// Property accessors

	public Integer getStockOutId()
	{
		return this.stockOutId;
	}

	public void setStockOutId(Integer stockOutId)
	{
		this.stockOutId = stockOutId;
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

	public Integer getStockOutQuantity()
	{
		return this.stockOutQuantity;
	}

	public void setStockOutQuantity(Integer stockOutQuantity)
	{
		this.stockOutQuantity = stockOutQuantity;
	}

	public Date getStockOuttTime()
	{
		return this.stockOuttTime;
	}

	public void setStockOuttTime(Date stockOuttTime)
	{
		this.stockOuttTime = stockOuttTime;
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