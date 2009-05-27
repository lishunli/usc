package com.Oracle.ADO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.corba.se.spi.resolver.Resolver;


public class testDB
{
	private  static DB db = new DB();
	
	
	public void insert(TestBean test)
	{
		Connection conn =null;
		
		try
		{
			conn= db.getCon();
			
			String sql="insert into test values(?,?,?)";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setLong(1, test.getEmpno());
			ps.setString(2, test.getEname() );
			ps.setDouble(3, test.getSal());
			
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
	
	
	public void update(TestBean test)
	{
		Connection conn =null;
		try
		{
			conn = db.getCon();
			String sql="update test set ename = ? ,sal = ?  where empno = ? ";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, test.getEname());
			ps.setDouble(2, test.getSal());
			ps.setLong(3, test.getEmpno());
				
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
//
//	public TestBean getById(int id)
//	{
//		Connection conn =null;
//		
//		TestBean test =null;
//		
//		try
//		{
//			conn = db.getCon(); 
//			
//			String sql="select id ,username,passworld,age from tb_test where id = ?";
//			
//			PreparedStatement ps = conn.prepareStatement(sql);
//			
//			ps.setInt(1, id);
//			
//			ResultSet rs=  ps.executeQuery();
//			
//			
//			
//			if(rs.next())
//			{
//				test = new TestBean();
//				
//				test.setId(rs.getInt("id"));
//				test.setUsername(rs.getString("username"));
//				test.setPassworld(rs.getString("passworld"));
//				test.setAge(rs.getInt("age"));
//				
//			}
//			rs.close();
//			
//			
//		} catch (Exception e)
//		{
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		
//		finally
//		{
//			try
//			{
//				if(null!=conn)
//				{
//					conn.close();
//				}
//			} catch (Exception e2)
//			{
//				// TODO: handle exception
//				e2.printStackTrace();
//			}
//		}
//		
//		
//		return test;
//	}
//	
//	public void deleteById(int id)
//	{
//		Connection conn =null;
//		
//		try
//		{
//			conn = db.getCon();
//			
//			String sql="delete from tb_test where id =?";
//			
//			PreparedStatement ps =conn.prepareStatement(sql);
//			
//			ps.setInt(1, id);
//			
//			ps.executeUpdate();
//			
//			
//		} catch (Exception e)
//		{
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		
//		finally
//		{
//			try
//			{
//				if(null!=conn)
//				{
//					conn.close();
//				}
//			} catch (Exception e2)
//			{
//				// TODO: handle exception
//				e2.printStackTrace();
//			}
//		}
//	}
//	

	
	public static void main(String[] args)
	{
		testDB db =new testDB();
		TestBean test =new TestBean();

		test.setEmpno(new java.lang.Long(8080));
		test.setEname("ÀîË³Àû");
		test.setSal(8000.00);
//		
//		db.insert(test);
		
		db.update(test);
	}

}




