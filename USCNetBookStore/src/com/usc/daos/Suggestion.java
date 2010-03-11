package com.usc.daos;

import java.util.Date;

/**
 * Suggestion entity. @author MyEclipse Persistence Tools
 */

public class Suggestion implements java.io.Serializable
{

	// Fields

	private Integer suggestionId;
	private String columnName;
	private String suggestionContents;
	private Date suggestionTime;
	private Integer suggestionFlag;

	// Constructors

	/** default constructor */
	public Suggestion()
	{
	}

	/** minimal constructor */
	public Suggestion(String suggestionContents, Date suggestionTime,
			Integer suggestionFlag)
	{
		this.suggestionContents = suggestionContents;
		this.suggestionTime = suggestionTime;
		this.suggestionFlag = suggestionFlag;
	}

	/** full constructor */
	public Suggestion(String columnName, String suggestionContents,
			Date suggestionTime, Integer suggestionFlag)
	{
		this.columnName = columnName;
		this.suggestionContents = suggestionContents;
		this.suggestionTime = suggestionTime;
		this.suggestionFlag = suggestionFlag;
	}

	// Property accessors

	public Integer getSuggestionId()
	{
		return this.suggestionId;
	}

	public void setSuggestionId(Integer suggestionId)
	{
		this.suggestionId = suggestionId;
	}

	public String getColumnName()
	{
		return this.columnName;
	}

	public void setColumnName(String columnName)
	{
		this.columnName = columnName;
	}

	public String getSuggestionContents()
	{
		return this.suggestionContents;
	}

	public void setSuggestionContents(String suggestionContents)
	{
		this.suggestionContents = suggestionContents;
	}

	public Date getSuggestionTime()
	{
		return this.suggestionTime;
	}

	public void setSuggestionTime(Date suggestionTime)
	{
		this.suggestionTime = suggestionTime;
	}

	public Integer getSuggestionFlag()
	{
		return this.suggestionFlag;
	}

	public void setSuggestionFlag(Integer suggestionFlag)
	{
		this.suggestionFlag = suggestionFlag;
	}

}