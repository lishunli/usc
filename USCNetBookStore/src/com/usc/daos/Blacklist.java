package com.usc.daos;

/**
 * Blacklist entity. @author MyEclipse Persistence Tools
 */

public class Blacklist implements java.io.Serializable
{

	// Fields

	private Integer blacklistId;
	private Custom custom;
	private Integer unOrderTimes;
	private Integer unRemarkTimes;
	private Integer unAcceptTimes;

	// Constructors

	/** default constructor */
	public Blacklist()
	{
	}

	/** full constructor */
	public Blacklist(Custom custom, Integer unOrderTimes,
			Integer unRemarkTimes, Integer unAcceptTimes)
	{
		this.custom = custom;
		this.unOrderTimes = unOrderTimes;
		this.unRemarkTimes = unRemarkTimes;
		this.unAcceptTimes = unAcceptTimes;
	}

	// Property accessors

	public Integer getBlacklistId()
	{
		return this.blacklistId;
	}

	public void setBlacklistId(Integer blacklistId)
	{
		this.blacklistId = blacklistId;
	}

	public Custom getCustom()
	{
		return this.custom;
	}

	public void setCustom(Custom custom)
	{
		this.custom = custom;
	}

	public Integer getUnOrderTimes()
	{
		return this.unOrderTimes;
	}

	public void setUnOrderTimes(Integer unOrderTimes)
	{
		this.unOrderTimes = unOrderTimes;
	}

	public Integer getUnRemarkTimes()
	{
		return this.unRemarkTimes;
	}

	public void setUnRemarkTimes(Integer unRemarkTimes)
	{
		this.unRemarkTimes = unRemarkTimes;
	}

	public Integer getUnAcceptTimes()
	{
		return this.unAcceptTimes;
	}

	public void setUnAcceptTimes(Integer unAcceptTimes)
	{
		this.unAcceptTimes = unAcceptTimes;
	}

}