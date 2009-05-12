package com.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "IDCard")
public class IDCard implements Serializable
{
	private Integer id;
	private String cardno;
	private Person person;

	public IDCard()
	{
	}

	public IDCard(String cardno)
	{
		this.cardno = cardno;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;

	}

	@Column(nullable = false, length = 18, unique = true)
	public String getCardno()
	{
		return cardno;
	}

	public void setCardno(String cardno)
	{
		this.cardno = cardno;
	}

	@OneToOne(optional = false, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "Person_ID", referencedColumnName = "personid", unique = true)
	/*
	 * optional=false:主表和从表的连接关系 false: inner join true: left join
	 */
	public Person getPerson()
	{
		return person;
	}

	public void setPerson(Person person)
	{
		this.person = person;
	}
}
