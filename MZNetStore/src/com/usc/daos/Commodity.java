package com.usc.daos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Commodity entity. @author MyEclipse Persistence Tools
 */

public class Commodity implements java.io.Serializable
{

	// Fields

	private Integer commodityId;
	private Integer operatorID;
	private Integer productsID;
	private Float discount;
	private Integer saleFlag;
	private Date publisheTime;
	private Set favorites = new HashSet(0);
	private Set remarks = new HashSet(0);
	private Set sales = new HashSet(0);
	private Set shoppingcarts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Commodity()
	{
	}

	/** minimal constructor */
	public Commodity(Float discount, Integer saleFlag, Date publisheTime)
	{
		this.discount = discount;
		this.saleFlag = saleFlag;
		this.publisheTime = publisheTime;
	}

	/** full constructor */
	public Commodity(Integer operatorID, Integer productsID, Float discount,
			Integer saleFlag, Date publisheTime, Set favorites, Set remarks,
			Set sales, Set shoppingcarts)
	{
		this.operatorID = operatorID;
		this.productsID = productsID;
		this.discount = discount;
		this.saleFlag = saleFlag;
		this.publisheTime = publisheTime;
		this.favorites = favorites;
		this.remarks = remarks;
		this.sales = sales;
		this.shoppingcarts = shoppingcarts;
	}

	// Property accessors

	public Integer getCommodityId()
	{
		return this.commodityId;
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

	public Integer getProductsID()
	{
		return productsID;
	}

	public void setProductsID(Integer productsID)
	{
		this.productsID = productsID;
	}

	public Float getDiscount()
	{
		return this.discount;
	}

	public void setDiscount(Float discount)
	{
		this.discount = discount;
	}

	public Integer getSaleFlag()
	{
		return this.saleFlag;
	}

	public void setSaleFlag(Integer saleFlag)
	{
		this.saleFlag = saleFlag;
	}

	public Date getPublisheTime()
	{
		return this.publisheTime;
	}

	public void setPublisheTime(Date publisheTime)
	{
		this.publisheTime = publisheTime;
	}

	public Set getFavorites()
	{
		return this.favorites;
	}

	public void setFavorites(Set favorites)
	{
		this.favorites = favorites;
	}

	public Set getRemarks()
	{
		return this.remarks;
	}

	public void setRemarks(Set remarks)
	{
		this.remarks = remarks;
	}

	public Set getSales()
	{
		return this.sales;
	}

	public void setSales(Set sales)
	{
		this.sales = sales;
	}

	public Set getShoppingcarts()
	{
		return this.shoppingcarts;
	}

	public void setShoppingcarts(Set shoppingcarts)
	{
		this.shoppingcarts = shoppingcarts;
	}

}