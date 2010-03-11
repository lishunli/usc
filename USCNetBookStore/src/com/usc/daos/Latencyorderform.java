package com.usc.daos;

import java.util.Date;

/**
 * Latencyorderform entity. @author MyEclipse Persistence Tools
 */

public class Latencyorderform implements java.io.Serializable
{

	// Fields

	private Integer latencyOrderFormId;
	private Custom custom;
	private Date orderFormTime;
	private String realName;
	private String address;
	private String postCode;
	private String mobile;
	private String phone;
	private String commodityName;
	private Integer quantity;

	// Constructors

	/** default constructor */
	public Latencyorderform()
	{
	}

	/** minimal constructor */
	public Latencyorderform(Date orderFormTime, String realName,
			String address, String postCode, String mobile,
			String commodityName, Integer quantity)
	{
		this.orderFormTime = orderFormTime;
		this.realName = realName;
		this.address = address;
		this.postCode = postCode;
		this.mobile = mobile;
		this.commodityName = commodityName;
		this.quantity = quantity;
	}

	/** full constructor */
	public Latencyorderform(Custom custom, Date orderFormTime, String realName,
			String address, String postCode, String mobile, String phone,
			String commodityName, Integer quantity)
	{
		this.custom = custom;
		this.orderFormTime = orderFormTime;
		this.realName = realName;
		this.address = address;
		this.postCode = postCode;
		this.mobile = mobile;
		this.phone = phone;
		this.commodityName = commodityName;
		this.quantity = quantity;
	}

	// Property accessors

	public Integer getLatencyOrderFormId()
	{
		return this.latencyOrderFormId;
	}

	public void setLatencyOrderFormId(Integer latencyOrderFormId)
	{
		this.latencyOrderFormId = latencyOrderFormId;
	}

	public Custom getCustom()
	{
		return this.custom;
	}

	public void setCustom(Custom custom)
	{
		this.custom = custom;
	}

	public Date getOrderFormTime()
	{
		return this.orderFormTime;
	}

	public void setOrderFormTime(Date orderFormTime)
	{
		this.orderFormTime = orderFormTime;
	}

	public String getRealName()
	{
		return this.realName;
	}

	public void setRealName(String realName)
	{
		this.realName = realName;
	}

	public String getAddress()
	{
		return this.address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getPostCode()
	{
		return this.postCode;
	}

	public void setPostCode(String postCode)
	{
		this.postCode = postCode;
	}

	public String getMobile()
	{
		return this.mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public String getPhone()
	{
		return this.phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getCommodityName()
	{
		return this.commodityName;
	}

	public void setCommodityName(String commodityName)
	{
		this.commodityName = commodityName;
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