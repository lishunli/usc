package com.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.pojo.Student;
import com.pojo.Teacher;

public @Stateless
class TeacherDAOBean implements TeacherDAO {
	@PersistenceContext
	private EntityManager em;

	public void insertTeacher(String name, String[] studentnames) {
		Teacher teacher = new Teacher(name);
		if (studentnames != null) {//由学生姓名组成的数组
			for (int i = 0; i < studentnames.length; i++) {
				teacher.addStudent(new Student(studentnames[i]));
				//在学生添加到教师集合中之前,进行学生类的封装
			}
		}
		em.persist(teacher);
	}

	public Teacher getTeacherByID(Integer teacherid) {
		Teacher teacher = em.find(Teacher.class, teacherid);//查到的结果中,包含学生的集合为空
		if (teacher != null)
			teacher.getStudents().size();//size方法的使用:将教师对象中包含的学生集合进行数据装载
		return teacher;
	}

	public Student getStudentByID(Integer studentid) {
		Student student = em.find(Student.class, studentid);//直接查询学生
		if (student != null)
			student.getTeachers().size();//装载教师的信息
		return student;
	}

}
