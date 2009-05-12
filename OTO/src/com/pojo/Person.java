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
{// ���л�

	private Integer personid;

	private String name;

	private boolean sex;

	private Short age;

	private String birthday;

	private IDCard idcard;

	@Id
	// �����������
	@GeneratedValue(strategy=GenerationType.AUTO)
	// һһ��Ӧ���ݱ�,����ľͿ���ʡ��
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
	// ʹ��@OneToMany���ӳ��һ�Զ�Ĺ�ϵ
	/*
	 * mappedBy:�����������ӳ��Ĺ�ϵ,������˫�������Ҫ�����˱��,��Ϊ�����������Ҫ�����˱��
	 * ȡֵ:������һ��һ�Ķ෽������������ͬ(��Ҫ) cascade:���õĲ����ļ�����ϵ(�ݹ�Ĳ���)
	 * CascadeType��ȡֵ:ALL----ȫ���Ĳ��� MERGE----�������� PERSIST----�������� REFRESH----����ˢ��
	 * REMOVE ----����ɾ�� fetch:��ʾ��ѯ�ķ�ʽ FetchType��ȡֵ:LAZY:�ӳٲ�ѯ EAGER:����װ��(���Ƽ�)
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
