package com.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable
{

	// Fields

	private Integer studentid;
	private String studentName;
	private Set teacherStudents = new HashSet(0);

	// Constructors

	/** default constructor */
	public Student()
	{
	}

	/** minimal constructor */
	public Student(String studentName)
	{
		this.studentName = studentName;
	}

	/** full constructor */
	public Student(String studentName, Set teacherStudents)
	{
		this.studentName = studentName;
		this.teacherStudents = teacherStudents;
	}

	// Property accessors

	public Integer getStudentid()
	{
		return this.studentid;
	}

	public void setStudentid(Integer studentid)
	{
		this.studentid = studentid;
	}

	public String getStudentName()
	{
		return this.studentName;
	}

	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
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