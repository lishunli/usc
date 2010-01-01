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
	/**
	 * 添加学生
	 * @param student 学生对象 
	 */
	public void addStudent(Student student);

	/**
	 * 根据序列来添加学生
	 * @param student 学生对象
	 */
	public void addStudentBySequence(Student student);

	/**
	 * 根据no删除学生信息
	 * @param no 学号
	 */
	public void deleteStudentById(int no);

	/**
	 * 根据no更新学生信息
	 * @param student 学生对象
	 */
	public void updateStudentById(Student student);

	/**
	 * 查询所有学生信息
	 * @return 学生List 
	 */
	public List<Student> queryAllStudent();

	/**
	 * 根据姓名模糊查询学生信息
	 * @param name 姓名
	 * @return 学生List 
	 */
	public List<Student> queryStudentByName(String name);

	/**
	 * 根据no查询学生信息
	 * @param no 学号
	 * @return 唯一学生 
	 */
	public Student queryStudentById(int no);

}
