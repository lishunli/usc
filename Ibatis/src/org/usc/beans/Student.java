package org.usc.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */
public class Student
{
	/*
	 * 学号
	 * 姓名
	 * 性别
	 * 年龄
	 * 分数
	 * 入学日期
	 */
	private Integer no;
	private String name;
	private String sex;
	private Integer age;
	private Double score;
	private Date eduTime;
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	// Constructors

	public Integer getNo()
	{
		return no;
	}

	public void setNo(Integer no)
	{
		this.no = no;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public Integer getAge()
	{
		return age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	public Double getScore()
	{
		return score;
	}

	public void setScore(Double score)
	{
		this.score = score;
	}

	public Date getEduTime()
	{
		return eduTime;
	}

	public void setEduTime(Date eduTime)
	{
		this.eduTime = eduTime;
	}

	/** default constructor */
	public Student()
	{
	}

	/** minimal constructor */
	public Student(Integer no, String name, String sex)
	{
		this.no = no;
		this.name = name;
		this.sex = sex;
	}

	/** full constructor */
	public Student(Integer no, String name, String sex, Integer age,
			Double score, Date eduTime)
	{
		this.no = no;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.score = score;
		this.eduTime = eduTime;
	}
	
	@Override
	public String toString()
	{
		String result = "no:"+no+",name:"+name+",age:"+age+",sex:"+sex+",score"+score+",eduTime:"+sdf.format(eduTime);
		return result;
	}

}
