package org.usc.daos;

import java.util.Date;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */
public class Student extends AbstractStudent implements java.io.Serializable
{

	// Constructors

	/** default constructor */
	public Student()
	{
	}

	/** minimal constructor */
	public Student(String no, String name, String sex)
	{
		super(no, name, sex);
	}

	/** full constructor */
	public Student(String no, String name, String sex, Integer age,
			Double score, Date eduTime)
	{
		super(no, name, sex, age, score, eduTime);
	}

}
