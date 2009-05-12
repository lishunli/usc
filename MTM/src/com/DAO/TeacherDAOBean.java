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
		if (studentnames != null) {//��ѧ��������ɵ�����
			for (int i = 0; i < studentnames.length; i++) {
				teacher.addStudent(new Student(studentnames[i]));
				//��ѧ����ӵ���ʦ������֮ǰ,����ѧ����ķ�װ
			}
		}
		em.persist(teacher);
	}

	public Teacher getTeacherByID(Integer teacherid) {
		Teacher teacher = em.find(Teacher.class, teacherid);//�鵽�Ľ����,����ѧ���ļ���Ϊ��
		if (teacher != null)
			teacher.getStudents().size();//size������ʹ��:����ʦ�����а�����ѧ�����Ͻ�������װ��
		return teacher;
	}

	public Student getStudentByID(Integer studentid) {
		Student student = em.find(Student.class, studentid);//ֱ�Ӳ�ѯѧ��
		if (student != null)
			student.getTeachers().size();//װ�ؽ�ʦ����Ϣ
		return student;
	}

}
