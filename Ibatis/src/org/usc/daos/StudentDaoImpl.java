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
	   * SqlMapClient instances are thread safe, so you only need one.
	   * In this case, we'll use a static singleton.  So sue me.  ;-)
	   */
	  private static SqlMapClient sqlMapClient;

	  /**
	   * It's not a good idea to put code that can fail in a class initializer,
	   * but for sake of argument, here's how you configure an SQL Map.
	   */
	  static {
	    try {
	      Reader reader = Resources.getResourceAsReader("org/usc/mappings/SqlMapConfig.xml");
	      sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
	      reader.close(); 
	    } catch (IOException e) {
	      // Fail fast.
	      throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
	    }
	  }

	public void addStudent(Student student)
	{
		try
		{
			sqlMapClient.insert("insertStudent",student);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void addStudentBySequence(Student student)
	{
		
	}

	public void deleteStudentById(int no)
	{
		try
		{
			System.out.println(sqlMapClient.delete("deleteStudentById", no));
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public List<Student> queryAllStudent()
	{
		List<Student> studentList = null;
		try
		{
			studentList = sqlMapClient.queryForList("selectAllStudents");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return studentList;
	}

	public Student queryStudentById(int no)
	{
		Student student = null;
		try
		{
			student = (Student) sqlMapClient.queryForObject("selectStudentById", no);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return student;
	}

	public List<Student> queryStudentByName(String name)
	{
		return null;
	}

	public void updateStudentById(Student student)
	{
		
	}
}
