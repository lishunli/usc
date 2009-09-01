package com.usc.daos;

import java.sql.Blob;
import java.util.Date;


public class BookExtra
{
	private Integer bookId;//图书ID
	private String bookName;//图书名称 
	private String author;//作者
	private String publisher; //出版社  
	private String isbn;//ISBN
	private Float publishedPrice;//定价
	private Float discount;// 折扣
	private Float salePrice;//特价
	private Integer priority; //优先级
	private Integer productTypeName;//类型
	private Date publishingTime;//出版时间
	private Date publisheTime;//发布时间
	private String version;//版本
	private String catalog;//目录
	private Blob picture;//照片
	private String briefIntroduction;//内容简介
	private Float privilegePrice;//会员价，有可能是定价*折扣，有可能是vip
	
	public Integer getBookId()
	{
		return bookId;
	}
	public void setBookId(Integer bookId)
	{
		this.bookId = bookId;
	}
	public String getBookName()
	{
		return bookName;
	}
	public void setBookName(String bookName)
	{
		this.bookName = bookName;
	}
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public String getPublisher()
	{
		return publisher;
	}
	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}
	public String getIsbn()
	{
		return isbn;
	}
	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
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
	public Integer getProductTypeName()
	{
		return productTypeName;
	}
	public void setProductTypeName(Integer productTypeName)
	{
		this.productTypeName = productTypeName;
	}
	public Date getPublishingTime()
	{
		return publishingTime;
	}
	public void setPublishingTime(Date publishingTime)
	{
		this.publishingTime = publishingTime;
	}
	public Date getPublisheTime()
	{
		return publisheTime;
	}
	public void setPublisheTime(Date publisheTime)
	{
		this.publisheTime = publisheTime;
	}
	public String getVersion()
	{
		return version;
	}
	public void setVersion(String version)
	{
		this.version = version;
	}
	public String getCatalog()
	{
		return catalog;
	}
	public void setCatalog(String catalog)
	{
		this.catalog = catalog;
	}
	public Blob getPicture()
	{
		return picture;
	}
	public void setPicture(Blob picture)
	{
		this.picture = picture;
	}
	public String getBriefIntroduction()
	{
		return briefIntroduction;
	}
	public void setBriefIntroduction(String briefIntroduction)
	{
		this.briefIntroduction = briefIntroduction;
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
