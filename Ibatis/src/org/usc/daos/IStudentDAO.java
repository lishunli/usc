package org.usc.daos;

import java.util.List;

import org.usc.beans.Student;

/**
 * 学生类Dao接口
 * 
 * @author ShunLi
 * @Time 2009-12-26
 */
public interface IStudentDAO
{
	public void addStudent(Student student);
	public void addStudentBySequence(Student student);
	public void deleteStudentById(int no);
	public void updateStudentById(Student student);
	public List<Student> queryAllStudent();
	public List<Student> queryStudentByName(String name);
	public Student queryStudentById(int no);
	
}
