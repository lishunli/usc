package com.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Person")
public class Person implements Serializable
{// 序列化

	private Integer personid;

	private String name;

	private boolean sex;

	private Short age;

	private String birthday;

	private IDCard idcard;

	@Id
	// 主键声明标记
	@GeneratedValue(strategy=GenerationType.AUTO)
	// 一一对应数据表,下面的就可以省略
	// @Column(name="PersonId")
	public Integer getPersonid()
	{
		return personid;
	}

	public void setPersonid(Integer personid)
	{
		this.personid = personid;
	}

	@Column(name = "PersonName", nullable = false, length = 32)
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Column(nullable = false)
	public boolean getSex()
	{
		return sex;
	}

	public void setSex(boolean sex)
	{
		this.sex = sex;
	}

	@Column(nullable = false)
	public Short getAge()
	{
		return age;
	}

	public void setAge(Short age)
	{
		this.age = age;
	}

	@Column(nullable = false)
	public String getBirthday()
	{
		return birthday;
	}

	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}

	@OneToOne(optional = true, cascade = CascadeType.ALL, mappedBy = "person")
	// 使用@OneToMany标记映射一对多的关系
	/*
	 * mappedBy:定义类与类的映射的关系,如若是双向关联需要声明此标记,若为单向关联则不需要声明此标记
	 * 取值:必须与一对一的多方的属性名称相同(重要) cascade:设置的操作的级联关系(递归的操作)
	 * CascadeType的取值:ALL----全部的操作 MERGE----级联更新 PERSIST----级联插入 REFRESH----级联刷新
	 * REMOVE ----级联删除 fetch:表示查询的方式 FetchType的取值:LAZY:延迟查询 EAGER:立即装载(不推荐)
	 */
	public IDCard getIdcard()
	{
		return idcard;
	}

	public void setIdcard(IDCard idcard)
	{
		this.idcard = idcard;
	}
}
