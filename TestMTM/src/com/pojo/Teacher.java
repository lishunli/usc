package com.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable
{

	// Fields

	private Integer teacherid;
	private String teacherName;
	private Set teacherStudents = new HashSet(0);

	// Constructors

	/** default constructor */
	public Teacher()
	{
	}

	/** minimal constructor */
	public Teacher(String teacherName)
	{
		this.teacherName = teacherName;
	}

	/** full constructor */
	public Teacher(String teacherName, Set teacherStudents)
	{
		this.teacherName = teacherName;
		this.teacherStudents = teacherStudents;
	}

	// Property accessors

	public Integer getTeacherid()
	{
		return this.teacherid;
	}

	public void setTeacherid(Integer teacherid)
	{
		this.teacherid = teacherid;
	}

	public String getTeacherName()
	{
		return this.teacherName;
	}

	public void setTeacherName(String teacherName)
	{
		this.teacherName = teacherName;
	}

	public Set getTeacherStudents()
	{
		return this.teacherStudents;
	}

	public void setTeacherStudents(Set teacherStudents)
	{
		this.teacherStudents = teacherStudents;
	}

}