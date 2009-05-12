package com.DAO;

import javax.ejb.Remote;

import com.pojo.Student;
import com.pojo.Teacher;

@Remote
public interface TeacherDAO {
	public void insertTeacher(String name, String[] studentnames);//(��ѧ���Ľ�ʦ����)
	public Teacher getTeacherByID(Integer teacherid);
	public Student getStudentByID(Integer studentid);
}
