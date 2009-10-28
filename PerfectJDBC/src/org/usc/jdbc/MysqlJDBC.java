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
 *         2009-10-28����02:06:07
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
			Class.forName("com.mysql.jdbc.Driver");// 1.�������������DriverManager
			try
			{
				conn = DriverManager
						.getConnection(
								"jdbc:mysql://localhost:3306/netstore?useUnicode=true&amp;characterEncoding=utf8",
								"root", "lishunli");// 2.�������
				stmt = conn.createStatement();// 3.��ô������
				String Sql = "select * from custom";// ִ�е�sql���
				rs = stmt.executeQuery(Sql);// 4.ִ��sql
				while (rs.next())// 5.��Ϣ���
				{
					System.out.println("Usename:" + rs.getString("customName"));
					System.out
							.println("Password:" + rs.getString("customPass"));
				}

			} catch (SQLException e)
			{
				e.printStackTrace();// ����ʹ��log4j�����쳣��־��¼
			}

		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();// ����ʹ��log4j�����쳣��־��¼
		} finally
		{
			if (rs != null)
			{
				try
				{
					rs.close();//�ر�
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
				rs = null;//�ڴ������������
			}
			if (stmt != null)
			{
				try
				{
					stmt.close();//�ر�
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
				stmt = null;//�ڴ������������
			}
			if (conn != null)
			{
				try
				{
					conn.close();//�ر�
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
				conn = null;//�ڴ������������
			}
		}
	}

}
