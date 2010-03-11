package com.usc.daos;

import java.util.HashSet;
import java.util.Set;

/**
 * Producttype entity. @author MyEclipse Persistence Tools
 */

public class Producttype implements java.io.Serializable
{

	// Fields

	private Integer productTypeId;
	private String productTypeName;
	private Integer fartherTypeId;
	private Set productses = new HashSet(0);
	private Set digitals = new HashSet(0);
	private Set books = new HashSet(0);

	// Constructors

	/** default constructor */
	public Producttype()
	{
	}

	/** minimal constructor */
	public Producttype(String productTypeName)
	{
		this.productTypeName = productTypeName;
	}

	/** full constructor */
	public Producttype(String productTypeName, Integer fartherTypeId,
			Set productses, Set digitals, Set books)
	{
		this.productTypeName = productTypeName;
		this.fartherTypeId = fartherTypeId;
		this.productses = productses;
		this.digitals = digitals;
		this.books = books;
	}

	// Property accessors

	public Integer getProductTypeId()
	{
		return this.productTypeId;
	}

	public void setProductTypeId(Integer productTypeId)
	{
		this.productTypeId = productTypeId;
	}

	public String getProductTypeName()
	{
		return this.productTypeName;
	}

	public void setProductTypeName(String productTypeName)
	{
		this.productTypeName = productTypeName;
	}

	public Integer getFartherTypeId()
	{
		return this.fartherTypeId;
	}

	public void setFartherTypeId(Integer fartherTypeId)
	{
		this.fartherTypeId = fartherTypeId;
	}

	public Set getProductses()
	{
		return this.productses;
	}

	public void setProductses(Set productses)
	{
		this.productses = productses;
	}

	public Set getDigitals()
	{
		return this.digitals;
	}

	public void setDigitals(Set digitals)
	{
		this.digitals = digitals;
	}

	public Set getBooks()
	{
		return this.books;
	}

	public void setBooks(Set books)
	{
		this.books = books;
	}

}