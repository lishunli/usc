package com.usc.daos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Custom entity. @author MyEclipse Persistence Tools
 */

public class Custom implements java.io.Serializable
{

	// Fields

	private String customName;
	private String customPass;
	private String email;
	private String realName;
	private String sex;
	private String address;
	private String postCode;
	private String mobile;
	private String phone;
	private Float consumption;
	private Float ucurrency;
	private Float benefits;
	private Integer vipFlag;
	private Date vipDate;
	private Integer activeFlag;
	private Set consumptiondetails = new HashSet(0);
	private Set remarks = new HashSet(0);
	private Set orderforms = new HashSet(0);
	private Set latencyorderforms = new HashSet(0);
	private Set favorites = new HashSet(0);
	private Set blacklists = new HashSet(0);
	private Set shoppingcarts = new HashSet(0);
	private Set benefitsdetails = new HashSet(0);
	private Set ucurrencydetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public Custom()
	{
	}

	/** minimal constructor */
	public Custom(String customName, String customPass, String email,
			String realName, String sex, String address, String postCode,
			String mobile, Float consumption, Float ucurrency, Float benefits,
			Integer vipFlag, Date vipDate, Integer activeFlag)
	{
		this.customName = customName;
		this.customPass = customPass;
		this.email = email;
		this.realName = realName;
		this.sex = sex;
		this.address = address;
		this.postCode = postCode;
		this.mobile = mobile;
		this.consumption = consumption;
		this.ucurrency = ucurrency;
		this.benefits = benefits;
		this.vipFlag = vipFlag;
		this.vipDate = vipDate;
		this.activeFlag = activeFlag;
	}

	/** full constructor */
	public Custom(String customName, String customPass, String email,
			String realName, String sex, String address, String postCode,
			String mobile, String phone, Float consumption, Float ucurrency,
			Float benefits, Integer vipFlag, Date vipDate, Integer activeFlag,
			Set consumptiondetails, Set remarks, Set orderforms,
			Set latencyorderforms, Set favorites, Set blacklists,
			Set shoppingcarts, Set benefitsdetails, Set ucurrencydetails)
	{
		this.customName = customName;
		this.customPass = customPass;
		this.email = email;
		this.realName = realName;
		this.sex = sex;
		this.address = address;
		this.postCode = postCode;
		this.mobile = mobile;
		this.phone = phone;
		this.consumption = consumption;
		this.ucurrency = ucurrency;
		this.benefits = benefits;
		this.vipFlag = vipFlag;
		this.vipDate = vipDate;
		this.activeFlag = activeFlag;
		this.consumptiondetails = consumptiondetails;
		this.remarks = remarks;
		this.orderforms = orderforms;
		this.latencyorderforms = latencyorderforms;
		this.favorites = favorites;
		this.blacklists = blacklists;
		this.shoppingcarts = shoppingcarts;
		this.benefitsdetails = benefitsdetails;
		this.ucurrencydetails = ucurrencydetails;
	}

	// Property accessors

	public String getCustomName()
	{
		return this.customName;
	}

	public void setCustomName(String customName)
	{
		this.customName = customName;
	}

	public String getCustomPass()
	{
		return this.customPass;
	}

	public void setCustomPass(String customPass)
	{
		this.customPass = customPass;
	}

	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getRealName()
	{
		return this.realName;
	}

	public void setRealName(String realName)
	{
		this.realName = realName;
	}

	public String getSex()
	{
		return this.sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
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

	public Float getConsumption()
	{
		return this.consumption;
	}

	public void setConsumption(Float d)
	{
		this.consumption =  d;
	}

	public Float getUcurrency()
	{
		return this.ucurrency;
	}

	public void setUcurrency(Float d)
	{
		this.ucurrency = d;
	}

	public Float getBenefits()
	{
		return this.benefits;
	}

	public void setBenefits(Float benefits)
	{
		this.benefits = benefits;
	}

	public Integer getVipFlag()
	{
		return this.vipFlag;
	}

	public void setVipFlag(Integer vipFlag)
	{
		this.vipFlag = vipFlag;
	}

	public Date getVipDate()
	{
		return this.vipDate;
	}

	public void setVipDate(Date vipDate)
	{
		this.vipDate = vipDate;
	}

	public Integer getActiveFlag()
	{
		return this.activeFlag;
	}

	public void setActiveFlag(Integer activeFlag)
	{
		this.activeFlag = activeFlag;
	}

	public Set getConsumptiondetails()
	{
		return this.consumptiondetails;
	}

	public void setConsumptiondetails(Set consumptiondetails)
	{
		this.consumptiondetails = consumptiondetails;
	}

	public Set getRemarks()
	{
		return this.remarks;
	}

	public void setRemarks(Set remarks)
	{
		this.remarks = remarks;
	}

	public Set getOrderforms()
	{
		return this.orderforms;
	}

	public void setOrderforms(Set orderforms)
	{
		this.orderforms = orderforms;
	}

	public Set getLatencyorderforms()
	{
		return this.latencyorderforms;
	}

	public void setLatencyorderforms(Set latencyorderforms)
	{
		this.latencyorderforms = latencyorderforms;
	}

	public Set getFavorites()
	{
		return this.favorites;
	}

	public void setFavorites(Set favorites)
	{
		this.favorites = favorites;
	}

	public Set getBlacklists()
	{
		return this.blacklists;
	}

	public void setBlacklists(Set blacklists)
	{
		this.blacklists = blacklists;
	}

	public Set getShoppingcarts()
	{
		return this.shoppingcarts;
	}

	public void setShoppingcarts(Set shoppingcarts)
	{
		this.shoppingcarts = shoppingcarts;
	}

	public Set getBenefitsdetails()
	{
		return this.benefitsdetails;
	}

	public void setBenefitsdetails(Set benefitsdetails)
	{
		this.benefitsdetails = benefitsdetails;
	}

	public Set getUcurrencydetails()
	{
		return this.ucurrencydetails;
	}

	public void setUcurrencydetails(Set ucurrencydetails)
	{
		this.ucurrencydetails = ucurrencydetails;
	}

}