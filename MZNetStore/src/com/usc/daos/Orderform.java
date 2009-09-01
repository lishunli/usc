package com.usc.daos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Orderform entity. @author MyEclipse Persistence Tools
 */

public class Orderform implements java.io.Serializable
{

	// Fields

	private Integer orderFormId;
	private Custom custom;
	private Date orderFormTime;
	private String realName;
	private String address;
	private String postCode;
	private String mobile;
	private String phone;
	private String orderFormState;
	private Integer cargoListId;
	private Set consumptiondetails = new HashSet(0);
	private Set orderstates = new HashSet(0);
	private Set orderproductses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Orderform()
	{
	}

	/** minimal constructor */
	public Orderform(Date orderFormTime, String realName, String address,
			String postCode, String mobile, String orderFormState,
			Integer cargoListId)
	{
		this.orderFormTime = orderFormTime;
		this.realName = realName;
		this.address = address;
		this.postCode = postCode;
		this.mobile = mobile;
		this.orderFormState = orderFormState;
		this.cargoListId = cargoListId;
	}

	/** full constructor */
	public Orderform(Custom custom, Date orderFormTime, String realName,
			String address, String postCode, String mobile, String phone,
			String orderFormState, Integer cargoListId, Set consumptiondetails,
			Set orderstates, Set orderproductses)
	{
		this.custom = custom;
		this.orderFormTime = orderFormTime;
		this.realName = realName;
		this.address = address;
		this.postCode = postCode;
		this.mobile = mobile;
		this.phone = phone;
		this.orderFormState = orderFormState;
		this.cargoListId = cargoListId;
		this.consumptiondetails = consumptiondetails;
		this.orderstates = orderstates;
		this.orderproductses = orderproductses;
	}

	// Property accessors

	public Integer getOrderFormId()
	{
		return this.orderFormId;
	}

	public void setOrderFormId(Integer orderFormId)
	{
		this.orderFormId = orderFormId;
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

	public String getOrderFormState()
	{
		return this.orderFormState;
	}

	public void setOrderFormState(String orderFormState)
	{
		this.orderFormState = orderFormState;
	}

	public Integer getCargoListId()
	{
		return this.cargoListId;
	}

	public void setCargoListId(Integer cargoListId)
	{
		this.cargoListId = cargoListId;
	}

	public Set getConsumptiondetails()
	{
		return this.consumptiondetails;
	}

	public void setConsumptiondetails(Set consumptiondetails)
	{
		this.consumptiondetails = consumptiondetails;
	}

	public Set getOrderstates()
	{
		return this.orderstates;
	}

	public void setOrderstates(Set orderstates)
	{
		this.orderstates = orderstates;
	}

	public Set getOrderproductses()
	{
		return this.orderproductses;
	}

	public void setOrderproductses(Set orderproductses)
	{
		this.orderproductses = orderproductses;
	}

}