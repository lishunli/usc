package com.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Student")
public class Student implements Serializable {
	private Integer studentid;

	private String StudentName;

	private Set<Teacher> teachers = new HashSet<Teacher>();//设置集合SET

	public Student() {
	}

	public Student(String studentName) {
		StudentName = studentName;
	}

	@Id
	@GeneratedValue
	public Integer getStudentid() {
		return studentid;
	}

	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}

	@Column(nullable = false, length = 32)
	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	@ManyToMany(mappedBy = "students")
	/*
	 * 学生类作为多对多的一方,对应教师类中Set集合,
	 * ***mappedBy  属性定义了包含 Students  为双向关系的维护端***
	 * 指定教师作为双向关联的维护端----DAO业务接口
	 * */
	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
}
