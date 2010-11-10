package org.usc.beans;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User Model,Please attention type of picture field
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-11-10<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
@Entity
@Table(name = "user", catalog = "test")
public class User implements java.io.Serializable
{
	private static final long serialVersionUID = 4230186551226007292L;

	private Integer id;
	private String name;
	private String password;
	private Blob picture;

	public User()
	{
	}

	public User(String name, String password)
	{
		this.name = name;
		this.password = password;
	}

	public User(Integer id, String name, String password, Blob picture)
	{
		this.id = id;
		this.name = name;
		this.password = password;
		this.picture = picture;
	}

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Column(name = "password", nullable = false, length = 100)
	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Column(name = "picture")
	public Blob getPicture()
	{
		return picture;
	}

	public void setPicture(Blob picture)
	{
		this.picture = picture;
	}
}