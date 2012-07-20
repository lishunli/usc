package org.usc.daos;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.usc.beans.Student;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

/**
 * 学生类Dao实现类
 * 
 * @author ShunLi
 * @Time 2009-12-26
 */
public class StudentDaoImpl implements IStudentDAO
{
	/**
	 * SqlMapClient instances are thread safe, so you only need one. In this
	 * case, we'll use a static singleton. So sue me. ;-)
	 */
	private static SqlMapClient sqlMapClient;

	/**
	 * It's not a good idea to put code that can fail in a class initializer,
	 * but for sake of argument, here's how you configure an SQL Map.
	 */
	static
	{
		try
		{
			Reader reader = Resources.getResourceAsReader("org/usc/mappings/SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 添加学生
	 */
	public void addStudent(Student student)
	{
		try
		{
			sqlMapClient.insert("insertStudent", student);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
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
		try
		{
			System.out.println(sqlMapClient.delete("deleteStudentById", no));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 查询所有学生信息
	 */
	public List<Student> queryAllStudent()
	{
		List<Student> studentList = null;
		try
		{
			studentList = sqlMapClient.queryForList("selectAllStudents");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return studentList;
	}

	/**
	 * 根据no查询学生信息
	 */
	public Student queryStudentById(int no)
	{
		Student student = null;
		try
		{
			student = (Student) sqlMapClient.queryForObject("selectStudentById", no);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return student;
	}

	/**
	 * 根据姓名模糊查询学生信息
	 */
	public List<Student> queryStudentByName(String name)
	{
		List<Student> studentList = null;
		try
		{
			studentList = sqlMapClient.queryForList("selectStudentByName", name);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return studentList;
	}

	/**
	 * 根据no更新学生信息
	 */
	public void updateStudentById(Student student)
	{
		try
		{
			System.out.println(sqlMapClient.update("updateStudentById", student));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}