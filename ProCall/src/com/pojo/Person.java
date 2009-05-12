package com.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person  implements Serializable{
	private int personid;
	private String personname,age,sex;
	public Person() {
		
	}
	@Column(name="age")
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Id
	@Column(name="personid")
	public int getPersonid() {
		return personid;
	}
	public void setPersonid(int personid) {
		this.personid = personid;
	}
	@Column(name="personname")
	public String getPersonname() {
		return personname;
	}
	public void setPersonname(String personname) {
		this.personname = personname;
	}
	@Column(name="sex")
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	

}
