package com.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "tp")
public class Tp implements Serializable {
	private int pid;

	private String pname;

	private float price;

	public Tp() {

	}
	@Id
	@GeneratedValue//要求表中的此列是自动增长
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
@Column(nullable=false)
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}
	@Column(nullable=false)
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + pid;
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tp other = (Tp) obj;
		if (pid != other.pid)
			return false;
		return true;
	}
	
	
	
}
