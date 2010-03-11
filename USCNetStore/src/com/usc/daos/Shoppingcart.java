package com.usc.daos;

/**
 * Shoppingcart entity. @author MyEclipse Persistence Tools
 */

public class Shoppingcart implements java.io.Serializable
{

	// Fields

	private Integer shoppingCartId;
	private String customName;
	private Integer commodityId;   
	private Float shoppingPrice;
	private Integer quantity;

	// Constructors

	/** default constructor */
	public Shoppingcart()
	{
	}

	/** minimal constructor */
	public Shoppingcart(Float shoppingPrice, Integer quantity)
	{
		this.shoppingPrice = shoppingPrice;
		this.quantity = quantity;
	}

	/** full constructor */
	public Shoppingcart(String customName, Integer commodityId,
			Float shoppingPrice, Integer quantity)
	{
		this.customName=customName;
		this.commodityId = commodityId;
		this.shoppingPrice = shoppingPrice;
		this.quantity = quantity;
	}

	// Property accessors

	public Integer getShoppingCartId()
	{
		return this.shoppingCartId;
	}

	public void setShoppingCartId(Integer shoppingCartId)
	{
		this.shoppingCartId = shoppingCartId;
	}




	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public Integer getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Integer commodityId) {
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