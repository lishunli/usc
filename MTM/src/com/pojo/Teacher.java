package com.pojo;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Teacher")
public class Teacher implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer teacherid;

	private String TeacherName;

	private Set<Student> students = new HashSet<Student>();

	public Teacher() {
	}

	public Teacher(String teacherName) {
		TeacherName = teacherName;
	}

	@Id
	@GeneratedValue
	public Integer getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(Integer teacherid) {
		this.teacherid = teacherid;
	}

	@Column(nullable = false, length = 32)
	public String getTeacherName() {
		return TeacherName;
	}

	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "Teacher_Student", joinColumns = { @JoinColumn(name = "Teacher_ID", referencedColumnName = "teacherid") }, 
			inverseJoinColumns = { @JoinColumn(name = "Student_ID", referencedColumnName = "studentid") })
	/*@ManyToMany  注释表示 Teacher 是多对多关系的一端。(是和学生类直接关联吗?NO，跟中间表关联)
	 * @JoinTable  描述了多对多关系的数据表关系。
	 * name 属性指定中间表名称
	 * joinColumns  定义中间表与 Teacher 表的外键关系。(中间表与主表之间的关系)
	 * 
	 * 上面的代码中，中间表 Teacher_Student的 Teacher_ID 列是 Teacher 表的主键列对应的外键列，
	 * inverseJoinColumns  属性定义了中间表与另外一端(Student从表)的外键关系。
	 * */
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
//定义方法用于添加,删除学生-----确定教师作为维护端（主表）
	public void addStudent(Student student) {
		if (!this.students.contains(student)) {
			this.students.add(student);
		}
//		this.students.add(student);
	//在教师的集合中添加学生	,避免重复添加
	}

	public void removeStudent(Student student) {
		this.students.remove(student);
	}
}
