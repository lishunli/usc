package com.usc.daos;

public class ShoppingcartExtra {

	private Integer shoppingCartId;
	private String customName;
	private Integer commodityId;   
	private Float shoppingPrice;
	private Integer quantity;
    private float publishedPrice;
    private String commodityName;
	public Integer getShoppingCartId() {
		return shoppingCartId;
	}
	public void setShoppingCartId(Integer shoppingCartId) {
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
	public Float getShoppingPrice() {
		return shoppingPrice;
	}
	public void setShoppingPrice(Float shoppingPrice) {
		this.shoppingPrice = shoppingPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public float getPublishedPrice() {
		return publishedPrice;
	}
	public void setPublishedPrice(float publishedPrice) {
		this.publishedPrice = publishedPrice;
	}
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
}
