package com.usc.daos;

import java.util.HashSet;
import java.util.Set;

/**
 * Products entity. @author MyEclipse Persistence Tools
 */

public class Products implements java.io.Serializable
{

	// Fields

	private Integer productsId;
	private Integer productTypeId;
	private Integer entityId;
	private Set commodities = new HashSet(0);
	private Set stockouts = new HashSet(0);
	private Set stocks = new HashSet(0);
	private Set stockins = new HashSet(0);

	// Constructors

	/** default constructor */
	public Products()
	{
	}

	/** minimal constructor */
	public Products(Integer entityId)
	{
		this.entityId = entityId;
	}

	/** full constructor */
	public Products(Integer productTypeId, Integer entityId, Set commodities,
			Set stockouts, Set stocks, Set stockins)
	{
		this.productTypeId = productTypeId;
		this.entityId = entityId;
		this.commodities = commodities;
		this.stockouts = stockouts;
		this.stocks = stocks;
		this.stockins = stockins;
	}

	// Property accessors

	public Integer getProductsId()
	{
		return this.productsId;
	}

	public void setProductsId(Integer productsId)
	{
		this.productsId = productsId;
	}


	public Integer getProductTypeId()
	{
		return productTypeId;
	}

	public void setProductTypeId(Integer productTypeId)
	{
		this.productTypeId = productTypeId;
	}

	public Integer getEntityId()
	{
		return this.entityId;
	}

	public void setEntityId(Integer entityId)
	{
		this.entityId = entityId;
	}

	public Set getCommodities()
	{
		return this.commodities;
	}

	public void setCommodities(Set commodities)
	{
		this.commodities = commodities;
	}

	public Set getStockouts()
	{
		return this.stockouts;
	}

	public void setStockouts(Set stockouts)
	{
		this.stockouts = stockouts;
	}

	public Set getStocks()
	{
		return this.stocks;
	}

	public void setStocks(Set stocks)
	{
		this.stocks = stocks;
	}

	public Set getStockins()
	{
		return this.stockins;
	}

	public void setStockins(Set stockins)
	{
		this.stockins = stockins;
	}

}