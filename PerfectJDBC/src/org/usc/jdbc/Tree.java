package org.usc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 递归生成树
 * 
 * @author MZ
 * 
 * @2009-10-28下午05:24:03
 */
public class Tree
{

	public static void main(String[] args)
	{
		new Tree().show();
	}

	public void show()
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");// 1.加载驱动，获得DriverManager
			try
			{
				String url = "jdbc:mysql://localhost:3306/tree?useUnicode=true&amp;characterEncoding=utf8";
				String user = "root";
				String password = "lishunli";
				conn = DriverManager.getConnection(url, user, password);// 2.获得连接
				stmt = conn.createStatement();// 3.获得创建语句
				String Sql = "select * from tree where pid = 0";// 执行的sql语句
				rs = stmt.executeQuery(Sql);// 4.执行sql
				while (rs.next())// 5.信息结果
				{
					System.out.println(rs.getString("name"));
					tree(conn,rs.getInt("id"),1);
				}

			} catch (SQLException e)
			{
				e.printStackTrace();// 可以使用log4j进行异常日志记录
			}
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();// 可以使用log4j进行异常日志记录
		} finally
		{
			try
			{
				if (rs != null)
				{
					rs.close();// 关闭
					rs = null;// 内存管理，垃圾回收
				}

				if (stmt != null)
				{
					stmt.close();// 关闭
					stmt = null;// 内存管理，垃圾回收
				}

				if (conn != null)
				{

					conn.close();// 关闭
					conn = null;// 内存管理，垃圾回收
				}
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void tree(Connection conn ,int pid,int level)
	{
		Statement stmt = null;
		ResultSet rs = null;
		String br ="";
		for(int i = 0;i<level;i++)
		{
			br ="-"+br;
		}
		try
		{
			stmt = conn.createStatement();// 3.获得创建语句
			String Sql = "select * from tree where pid = " + pid;// 执行的sql语句
			rs = stmt.executeQuery(Sql);// 4.执行sql
			while(rs.next())// 5.信息结果
			{
				System.out.println(br + rs.getString("name"));
				tree(conn,rs.getInt("id"),level+1);
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (rs != null)
				{
					rs.close();// 关闭
					rs = null;// 内存管理，垃圾回收
				}

				if (stmt != null)
				{
					stmt.close();// 关闭
					stmt = null;// 内存管理，垃圾回收
				}
////conn是父类传过来的，不能关闭，而是由父类关闭
//				if (conn != null)
//				{
//
//					conn.close();// 关闭
//					conn = null;// 内存管理，垃圾回收
//				}
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}
}
