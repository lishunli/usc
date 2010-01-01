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
	public void addStudent(Student student);// 添加学生

	public void addStudentBySequence(Student student);// 根据序列来添加学生

	public void deleteStudentById(int no);// 根据no删除学生信息

	public void updateStudentById(Student student);// 根据no更新学生信息

	public List<Student> queryAllStudent();// 查询所有学生信息

	public List<Student> queryStudentByName(String name);// 根据姓名模糊查询学生信息

	public Student queryStudentById(int no);// 根据no查询学生信息

}
