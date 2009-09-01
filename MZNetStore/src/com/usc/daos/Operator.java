package com.usc.daos;

import java.util.HashSet;
import java.util.Set;

/**
 * Operator entity. @author MyEclipse Persistence Tools
 */

public class Operator implements java.io.Serializable
{

	// Fields

	private Integer operatorId;
	private String operatorName;
	private String operatorPass;
	private String operatorSex;
	private String operatorType;
	private Set commodities = new HashSet(0);
	private Set sales = new HashSet(0);
	private Set stockouts = new HashSet(0);
	private Set stockins = new HashSet(0);

	// Constructors

	/** default constructor */
	public Operator()
	{
	}

	/** minimal constructor */
	public Operator(String operatorName, String operatorPass,
			String operatorSex, String operatorType)
	{
		this.operatorName = operatorName;
		this.operatorPass = operatorPass;
		this.operatorSex = operatorSex;
		this.operatorType = operatorType;
	}

	/** full constructor */
	public Operator(String operatorName, String operatorPass,
			String operatorSex, String operatorType, Set commodities,
			Set sales, Set stockouts, Set stockins)
	{
		this.operatorName = operatorName;
		this.operatorPass = operatorPass;
		this.operatorSex = operatorSex;
		this.operatorType = operatorType;
		this.commodities = commodities;
		this.sales = sales;
		this.stockouts = stockouts;
		this.stockins = stockins;
	}

	// Property accessors

	public Integer getOperatorId()
	{
		return this.operatorId;
	}

	public void setOperatorId(Integer operatorId)
	{
		this.operatorId = operatorId;
	}

	public String getOperatorName()
	{
		return this.operatorName;
	}

	public void setOperatorName(String operatorName)
	{
		this.operatorName = operatorName;
	}

	public String getOperatorPass()
	{
		return this.operatorPass;
	}

	public void setOperatorPass(String operatorPass)
	{
		this.operatorPass = operatorPass;
	}

	public String getOperatorSex()
	{
		return this.operatorSex;
	}

	public void setOperatorSex(String operatorSex)
	{
		this.operatorSex = operatorSex;
	}

	public String getOperatorType()
	{
		return this.operatorType;
	}

	public void setOperatorType(String operatorType)
	{
		this.operatorType = operatorType;
	}

	public Set getCommodities()
	{
		return this.commodities;
	}

	public void setCommodities(Set commodities)
	{
		this.commodities = commodities;
	}

	public Set getSales()
	{
		return this.sales;
	}

	public void setSales(Set sales)
	{
		this.sales = sales;
	}

	public Set getStockouts()
	{
		return this.stockouts;
	}

	public void setStockouts(Set stockouts)
	{
		this.stockouts = stockouts;
	}

	public Set getStockins()
	{
		return this.stockins;
	}

	public void setStockins(Set stockins)
	{
		this.stockins = stockins;
	}

}