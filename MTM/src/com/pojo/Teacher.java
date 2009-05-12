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
	/*@ManyToMany  ע�ͱ�ʾ Teacher �Ƕ�Զ��ϵ��һ�ˡ�(�Ǻ�ѧ����ֱ�ӹ�����?NO�����м�����)
	 * @JoinTable  �����˶�Զ��ϵ�����ݱ��ϵ��
	 * name ����ָ���м������
	 * joinColumns  �����м���� Teacher ��������ϵ��(�м��������֮��Ĺ�ϵ)
	 * 
	 * ����Ĵ����У��м�� Teacher_Student�� Teacher_ID ���� Teacher ��������ж�Ӧ������У�
	 * inverseJoinColumns  ���Զ������м��������һ��(Student�ӱ�)�������ϵ��
	 * */
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
//���巽���������,ɾ��ѧ��-----ȷ����ʦ��Ϊά���ˣ�����
	public void addStudent(Student student) {
		if (!this.students.contains(student)) {
			this.students.add(student);
		}
//		this.students.add(student);
	//�ڽ�ʦ�ļ��������ѧ��	,�����ظ����
	}

	public void removeStudent(Student student) {
		this.students.remove(student);
	}
}
