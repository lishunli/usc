package com.test.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.test.person.personBean;

public class PersonDBTest
{
	private static PersonDB db =null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		db =new PersonDB();
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}


	@Test
	public void testInsert()
	{
		personBean person =new personBean();
		person.setUsername("lishunli");
		person.setPassworld("mz");
		person.setAge(21);
		
		db.insert(person);
		
		personBean person2 =this.getMaxIdperson();
		
		this.comparePersons(person, person2);
		
		db.deleteById(person2.getId());//数据库不能产生脏数据，所以需要清空数据库
		
		}

	@Test
	public void testUpdate()
	{
		personBean person =new personBean();
		person.setUsername("木子");
		person.setPassworld("李顺利");
		person.setAge(21);
		
		db.insert(person);
		
		personBean person2 = this.getMaxIdperson();
		
		this.comparePersons(person, person2);
		
		person2.setUsername("李顺利");
		person2.setPassworld("mz");
		person2.setAge(20);
		
		
		db.update(person2);
		
		personBean person3 = this.getMaxIdperson();
		
		this.comparePersons(person2, person3);
		
		db.deleteById(person3.getId());//数据库不能产生垃圾数据，所以需要清空数据库

	}
	
	@Test
	public void testGetById()
	{
		personBean person = new personBean();
		person.setUsername("木子");
		person.setPassworld("李顺利");
		person.setAge(21);
		
		db.insert(person);
		
		db.getById(this.getMaxId());
		
		personBean person2 =db.getById(getMaxId());
		
		this.comparePersons(person, person2);
		
		db.deleteById(person2.getId());
		
	}
	
	@Test
	public void testDeleteById()
	{
		personBean person = new personBean();
		person.setUsername("木子");
		person.setPassworld("李顺利");
		person.setAge(21);
		
		db.insert(person);
		int MaxId =this.getMaxId();
		
		db.deleteById(MaxId);
		
		personBean person2 =db.getById(MaxId);
		
		assertNull(person2);
		
		
	}




	private int getMaxId()
	{
		DB db = new DB();
		
		Connection conn= null;
		
		int MaxId=0;
		
		try
		{
			conn= db.getCon();
			
			String sql="select max(id) as MaxId from tb_Person";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			
			
			if(rs.next())
			{
				MaxId = rs.getInt("MaxId");
			}
			
		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(null!=conn)
				{
					conn.close();
				}
			} catch (Exception e2)
			{
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return MaxId;
		
	}
	
	
	private personBean getMaxIdperson()
	{
		DB db = new DB();
		
		Connection conn= null;
		
		personBean person=null;
		
		try
		{
			conn= db.getCon();
			
			String sql="select max(id) as MaxId from tb_Person";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			int MaxId=0;
			
			if(rs.next())
			{
				MaxId = rs.getInt("MaxId");
			}
			
			String sql2="select * from tb_Person where id = " + MaxId;
			
//			System.out.println(""+MaxId);
			
			ps = conn.prepareStatement(sql2);
			
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				person =new personBean();
				person.setId(MaxId);
				person.setUsername(rs.getString("username"));
				person.setPassworld(rs.getString("passworld"));
				person.setAge(rs.getInt("age"));

			}
			
			
			
			
		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(null!=conn)
				{
					conn.close();
				}
			} catch (Exception e2)
			{
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return person;
	}
	
	
	private void comparePersons(personBean person1,personBean person2)
	{
		assertEquals(person1.getUsername(), person2.getUsername());
		assertEquals(person1.getPassworld(), person2.getPassworld());
		assertEquals(person1.getAge(), person2.getAge());

	}

}
