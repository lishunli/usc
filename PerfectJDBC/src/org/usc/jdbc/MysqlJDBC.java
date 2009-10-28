package org.usc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Mysql connect JDBC
 * 
 * @author MZ
 * 
 *         2009-10-28下午02:06:07
 */
public class MysqlJDBC
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");// 1.加载驱动，获得DriverManager
			try
			{
				conn = DriverManager
						.getConnection(
								"jdbc:mysql://localhost:3306/netstore?useUnicode=true&amp;characterEncoding=utf8",
								"root", "lishunli");// 2.获得连接
				stmt = conn.createStatement();// 3.获得创建语句
				String Sql = "select * from custom";// 执行的sql语句
				rs = stmt.executeQuery(Sql);// 4.执行sql
				while (rs.next())// 5.信息结果
				{
					System.out.println("Usename:" + rs.getString("customName"));
					System.out
							.println("Password:" + rs.getString("customPass"));
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
			if (rs != null)
			{
				try
				{
					rs.close();//关闭
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
				rs = null;//内存管理，垃圾回收
			}
			if (stmt != null)
			{
				try
				{
					stmt.close();//关闭
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
				stmt = null;//内存管理，垃圾回收
			}
			if (conn != null)
			{
				try
				{
					conn.close();//关闭
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
				conn = null;//内存管理，垃圾回收
			}
		}
	}

}
