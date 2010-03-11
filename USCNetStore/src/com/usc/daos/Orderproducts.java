package com.usc.daos;

/**
 * Orderproducts entity. @author MyEclipse Persistence Tools
 */

public class Orderproducts implements java.io.Serializable
{

	// Fields

	private Integer orderProductsId;
	private Orderform orderform;
	private Integer commodityId;
	private Float shoppingPrice;
	private Integer quantity;

	// Constructors

	/** default constructor */
	public Orderproducts()
	{
	}

	/** minimal constructor */
	public Orderproducts(Integer commodityId, Float shoppingPrice,
			Integer quantity)
	{
		this.commodityId = commodityId;
		this.shoppingPrice = shoppingPrice;
		this.quantity = quantity;
	}

	/** full constructor */
	public Orderproducts(Orderform orderform, Integer commodityId,
			Float shoppingPrice, Integer quantity)
	{
		this.orderform = orderform;
		this.commodityId = commodityId;
		this.shoppingPrice = shoppingPrice;
		this.quantity = quantity;
	}

	// Property accessors

	public Integer getOrderProductsId()
	{
		return this.orderProductsId;
	}

	public void setOrderProductsId(Integer orderProductsId)
	{
		this.orderProductsId = orderProductsId;
	}

	public Orderform getOrderform()
	{
		return this.orderform;
	}

	public void setOrderform(Orderform orderform)
	{
		this.orderform = orderform;
	}

	public Integer getCommodityId()
	{
		return this.commodityId;
	}

	public void setCommodityId(Integer commodityId)
	{
		this.commodityId = commodityId;
	}

	public Float getShoppingPrice()
	{
		return this.shoppingPrice;
	}

	public void setShoppingPrice(Float shoppingPrice)
	{
		this.shoppingPrice = shoppingPrice;
	}

	public Integer getQuantity()
	{
		return this.quantity;
	}

	public void setQuantity(Integer quantity)
	{
		this.quantity = quantity;
	}

}