package com.usc.daos;

/**
 * Stock entity. @author MyEclipse Persistence Tools
 */

public class Stock implements java.io.Serializable
{

	// Fields

	private Integer storageId;
	private Products products;
	private Integer stockQuantity;
	private Integer factStockQuantity;

	// Constructors

	/** default constructor */
	public Stock()
	{
	}

	/** minimal constructor */
	public Stock(Integer stockQuantity, Integer factStockQuantity)
	{
		this.stockQuantity = stockQuantity;
		this.factStockQuantity = factStockQuantity;
	}

	/** full constructor */
	public Stock(Products products, Integer stockQuantity,
			Integer factStockQuantity)
	{
		this.products = products;
		this.stockQuantity = stockQuantity;
		this.factStockQuantity = factStockQuantity;
	}

	// Property accessors

	public Integer getStorageId()
	{
		return this.storageId;
	}

	public void setStorageId(Integer storageId)
	{
		this.storageId = storageId;
	}

	public Products getProducts()
	{
		return this.products;
	}

	public void setProducts(Products products)
	{
		this.products = products;
	}

	public Integer getStockQuantity()
	{
		return this.stockQuantity;
	}

	public void setStockQuantity(Integer stockQuantity)
	{
		this.stockQuantity = stockQuantity;
	}

	public Integer getFactStockQuantity()
	{
		return this.factStockQuantity;
	}

	public void setFactStockQuantity(Integer factStockQuantity)
	{
		this.factStockQuantity = factStockQuantity;
	}

}