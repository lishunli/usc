package com.usc.daos;

import java.sql.Blob;
import java.util.Date;

/**
 * Book entity. @author MyEclipse Persistence Tools
 */

public class Book implements java.io.Serializable
{

	// Fields

	private Integer bookId;
	private Integer productTypeID;
	private String bookName;
	private String author;
	private String publisher;
	private Date publishingTime;
	private String version;
	private String isbn;
	private Float publishedPrice;
	private String catalog;
	private Blob picture;
	private String briefIntroduction;
	private Integer productsPflag;

	// Constructors

	/** default constructor */
	public Book()
	{
	}

	/** minimal constructor */
	public Book(String bookName, String publisher, String isbn,
			Float publishedPrice, Integer productsPflag)
	{
		this.bookName = bookName;
		this.publisher = publisher;
		this.isbn = isbn;
		this.publishedPrice = publishedPrice;
		this.productsPflag = productsPflag;
	}

	/** full constructor */
	public Book(Integer productTypeID, String bookName, String author,
			String publisher, Date publishingTime, String version, String isbn,
			Float publishedPrice, String catalog, Blob picture,
			String briefIntroduction, Integer productsPflag)
	{
		this.productTypeID = productTypeID;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.publishingTime = publishingTime;
		this.version = version;
		this.isbn = isbn;
		this.publishedPrice = publishedPrice;
		this.catalog = catalog;
		this.picture = picture;
		this.briefIntroduction = briefIntroduction;
		this.productsPflag = productsPflag;
	}

	// Property accessors

	public Integer getBookId()
	{
		return this.bookId;
	}

	public void setBookId(Integer bookId)
	{
		this.bookId = bookId;
	}


	public Integer getProductTypeID()
	{
		return productTypeID;
	}

	public void setProductTypeID(Integer productTypeID)
	{
		this.productTypeID = productTypeID;
	}

	public String getBookName()
	{
		return this.bookName;
	}

	public void setBookName(String bookName)
	{
		this.bookName = bookName;
	}

	public String getAuthor()
	{
		return this.author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public String getPublisher()
	{
		return this.publisher;
	}

	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}

	public Date getPublishingTime()
	{
		return this.publishingTime;
	}

	public void setPublishingTime(Date publishingTime)
	{
		this.publishingTime = publishingTime;
	}

	public String getVersion()
	{
		return this.version;
	}

	public void setVersion(String version)
	{
		this.version = version;
	}

	public String getIsbn()
	{
		return this.isbn;
	}

	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}

	public Float getPublishedPrice()
	{
		return this.publishedPrice;
	}

	public void setPublishedPrice(Float publishedPrice)
	{
		this.publishedPrice = publishedPrice;
	}

	public String getCatalog()
	{
		return this.catalog;
	}

	public void setCatalog(String catalog)
	{
		this.catalog = catalog;
	}

	public Blob getPicture()
	{
		return this.picture;
	}

	public void setPicture(Blob picture)
	{
		this.picture = picture;
	}

	public String getBriefIntroduction()
	{
		return this.briefIntroduction;
	}

	public void setBriefIntroduction(String briefIntroduction)
	{
		this.briefIntroduction = briefIntroduction;
	}

	public Integer getProductsPflag()
	{
		return this.productsPflag;
	}

	public void setProductsPflag(Integer productsPflag)
	{
		this.productsPflag = productsPflag;
	}

}