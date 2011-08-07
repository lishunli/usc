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
public class User implements java.io.Serializable {
	private static final long serialVersionUID = 4230186551226007292L;

	private Integer id;
	private String username;
	private String password;
	private Blob picture;

	public User() {
	}

	public User(String name, String password) {
		this.username = name;
		this.password = password;
	}

	public User(Integer id, String name, String password, Blob picture) {
		this.id = id;
		this.username = name;
		this.password = password;
		this.picture = picture;
	}

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "username", nullable = false, length = 100)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "picture")
	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", username=" + username + "]";
	}
	
}