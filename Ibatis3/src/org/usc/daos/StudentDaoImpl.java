package org.usc.daos;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.usc.beans.Student;
import org.usc.utils.SqlMapUtils;


/**
 * 学生类Dao实现类
 * 
 * @author ShunLi
 * @Time 2009-12-26
 */
public class StudentDaoImpl implements IStudentDAO
{
	private static final String SELECT_ALL_STUDENTS = "Studnet.selectAllStudents";//查询所有的学生

	private SqlSession session = null;

	public StudentDaoImpl()
	{
		session = SqlMapUtils.getInstance().getSession();
	}


	/**
	 * 查询所有学生信息
	 */
	public List<Student> queryAllStudent()
	{
		return session.selectList(SELECT_ALL_STUDENTS);
	}

	/**
	 * 添加学生
	 */
	public void addStudent(Student student)
	{
		session.insert("insertStudent", student);
	}
	
	/**
	 * 根据序列来添加学生
	 */
	public void addStudentBySequence(Student student)
	{
		
	}
	
	/**
	 * 根据no删除学生信息
	 */
	public void deleteStudentById(int no)
	{
		System.out.println(session.delete("deleteStudentById", no));
	}


	/**
	 * 根据no查询学生信息
	 */
	public Student queryStudentById(int no)
	{
		return (Student) session.selectOne("selectStudentById", no);
	}

	/**
	 * 根据姓名模糊查询学生信息
	 */
	public List<Student> queryStudentByName(String name)
	{
		return session.selectList("selectStudentByName", name);
	}

	/**
	 * 根据no更新学生信息
	 */
	public void updateStudentById(Student student)
	{
			System.out.println(session.update("updateStudentById", student));
	}
}
