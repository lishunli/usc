package com.usc.daos;

import java.sql.Blob;
import java.util.Date;

public class DigitalExtra
{
	private Integer digitalId;//数码ID
	private String digitalName;//数码名称
	private String manufacturer;//厂家
	private String brand; //品牌
	private String modelNumber;//型号
	private String barcode;//条形码
	private Float publishedPrice;// 定价
	private Float discount;// 折扣
	private Float salePrice;//特价
	private Integer priority; //优先级
	private Date publisheTime;//发布时间
	private Integer productTypeName;//类型
	private String parameter;//参数
	private Blob photo;//图片
	private String description;//说明
	private String specialExplanation;//特别说明
	private Float privilegePrice;//会员价，有可能是定价*折扣，有可能是vip
	
	public Integer getDigitalId()
	{
		return digitalId;
	}
	public void setDigitalId(Integer digitalId)
	{
		this.digitalId = digitalId;
	}
	public String getDigitalName()
	{
		return digitalName;
	}
	public void setDigitalName(String digitalName)
	{
		this.digitalName = digitalName;
	}
	public String getManufacturer()
	{
		return manufacturer;
	}
	public void setManufacturer(String manufacturer)
	{
		this.manufacturer = manufacturer;
	}
	public String getBrand()
	{
		return brand;
	}
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	public String getModelNumber()
	{
		return modelNumber;
	}
	public void setModelNumber(String modelNumber)
	{
		this.modelNumber = modelNumber;
	}
	public String getBarcode()
	{
		return barcode;
	}
	public void setBarcode(String barcode)
	{
		this.barcode = barcode;
	}
	public Float getPublishedPrice()
	{
		return publishedPrice;
	}
	public void setPublishedPrice(Float publishedPrice)
	{
		this.publishedPrice = publishedPrice;
	}
	public Float getDiscount()
	{
		return discount;
	}
	public void setDiscount(Float discount)
	{
		this.discount = discount;
	}
	public Float getSalePrice()
	{
		return salePrice;
	}
	public void setSalePrice(Float salePrice)
	{
		this.salePrice = salePrice;
	}
	public Integer getPriority()
	{
		return priority;
	}
	public void setPriority(Integer priority)
	{
		this.priority = priority;
	}
	public Date getPublisheTime()
	{
		return publisheTime;
	}
	public void setPublisheTime(Date publisheTime)
	{
		this.publisheTime = publisheTime;
	}
	public Integer getProductTypeName()
	{
		return productTypeName;
	}
	public void setProductTypeName(Integer productTypeName)
	{
		this.productTypeName = productTypeName;
	}
	public String getParameter()
	{
		return parameter;
	}
	public void setParameter(String parameter)
	{
		this.parameter = parameter;
	}
	public Blob getPhoto()
	{
		return photo;
	}
	public void setPhoto(Blob photo)
	{
		this.photo = photo;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getSpecialExplanation()
	{
		return specialExplanation;
	}
	public void setSpecialExplanation(String specialExplanation)
	{
		this.specialExplanation = specialExplanation;
	}
	public Float getPrivilegePrice()
	{
		return privilegePrice;
	}
	public void setPrivilegePrice(Float privilegePrice)
	{
		this.privilegePrice = privilegePrice;
	}
	
	
}
