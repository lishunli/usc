package com.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.corba.se.spi.resolver.Resolver;
import com.test.person.*;

public class PersonDB
{
	private  static DB db = new DB();
	
	
	public void insert(personBean person)
	{
		Connection conn =null;
		
		try
		{
			conn= db.getCon();
			
			String sql="insert into tb_Person(username,passworld,age) values(?,?,?)";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setString(1, person.getUsername());
			ps.setString(2, person.getPassworld());
			ps.setInt(3, person.getAge());
			
			ps.executeUpdate();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
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
	}
	
	
	public void update(personBean person)
	{
		Connection conn =null;
		try
		{
			conn = db.getCon();
			String sql="update tb_Person set username = ? ,passworld = ? ,age = ? where id = ? ";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, person.getUsername());
			ps.setString(2, person.getPassworld());
			ps.setInt(3, person.getAge());
			ps.setInt(4, person.getId());
			
			ps.executeUpdate();
			
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
		
	}

	public personBean getById(int id)
	{
		Connection conn =null;
		
		personBean person =null;
		
		try
		{
			conn = db.getCon(); 
			
			String sql="select id ,username,passworld,age from tb_Person where id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs=  ps.executeQuery();
			
			
			
			if(rs.next())
			{
				person = new personBean();
				
				person.setId(rs.getInt("id"));
				person.setUsername(rs.getString("username"));
				person.setPassworld(rs.getString("passworld"));
				person.setAge(rs.getInt("age"));
				
			}
			rs.close();
			
			
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
	
	public void deleteById(int id)
	{
		Connection conn =null;
		
		try
		{
			conn = db.getCon();
			
			String sql="delete from tb_person where id =?";
			
			PreparedStatement ps =conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			
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
	}
	

	
//	public static void main(String[] args)
//	{
//		PersonDB db =new PersonDB();
//		personBean person =new personBean();
//		person.setUsername("jsjmz");
//		person.setPassworld("lishunli");
//		person.setAge(20);
//		
//		db.insert(person);
//	}

}




