package com.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Hb entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "hb", catalog = "test")
public class Hb implements java.io.Serializable
{

	// Fields

	private Integer uid;
	private String uname;
	private String upass;

	// Constructors

	/** default constructor */
	public Hb()
	{
	}

	/** full constructor */
	public Hb(Integer uid, String uname, String upass)
	{
		this.uid = uid;
		this.uname = uname;
		this.upass = upass;
	}

	// Property accessors
	@Id
	@Column(name = "uid", unique = true, nullable = false)
	public Integer getUid()
	{
		return this.uid;
	}

	public void setUid(Integer uid)
	{
		this.uid = uid;
	}

	@Column(name = "uname", nullable = false, length = 20)
	public String getUname()
	{
		return this.uname;
	}

	public void setUname(String uname)
	{
		this.uname = uname;
	}

	@Column(name = "upass", nullable = false, length = 20)
	public String getUpass()
	{
		return this.upass;
	}

	public void setUpass(String upass)
	{
		this.upass = upass;
	}

}