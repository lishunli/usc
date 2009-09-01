package com.usc.daos;

import java.util.Date;

/**
 * Favorite entity. @author MyEclipse Persistence Tools
 */

public class Favorite implements java.io.Serializable
{

	// Fields

	private Integer favoriteId;
	private Custom custom;
	private Commodity commodity;
	private Date favoriteTime;

	// Constructors

	/** default constructor */
	public Favorite()
	{
	}

	/** minimal constructor */
	public Favorite(Date favoriteTime)
	{
		this.favoriteTime = favoriteTime;
	}

	/** full constructor */
	public Favorite(Custom custom, Commodity commodity, Date favoriteTime)
	{
		this.custom = custom;
		this.commodity = commodity;
		this.favoriteTime = favoriteTime;
	}

	// Property accessors

	public Integer getFavoriteId()
	{
		return this.favoriteId;
	}

	public void setFavoriteId(Integer favoriteId)
	{
		this.favoriteId = favoriteId;
	}

	public Custom getCustom()
	{
		return this.custom;
	}

	public void setCustom(Custom custom)
	{
		this.custom = custom;
	}

	public Commodity getCommodity()
	{
		return this.commodity;
	}

	public void setCommodity(Commodity commodity)
	{
		this.commodity = commodity;
	}

	public Date getFavoriteTime()
	{
		return this.favoriteTime;
	}

	public void setFavoriteTime(Date favoriteTime)
	{
		this.favoriteTime = favoriteTime;
	}

}