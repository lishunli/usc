package org.usc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * �ݹ�������
 * 
 * @author MZ
 * 
 * @2009-10-28����05:24:03
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
			Class.forName("com.mysql.jdbc.Driver");// 1.�������������DriverManager
			try
			{
				String url = "jdbc:mysql://localhost:3306/tree?useUnicode=true&amp;characterEncoding=utf8";
				String user = "root";
				String password = "lishunli";
				conn = DriverManager.getConnection(url, user, password);// 2.�������
				stmt = conn.createStatement();// 3.��ô������
				String Sql = "select * from tree where pid = 0";// ִ�е�sql���
				rs = stmt.executeQuery(Sql);// 4.ִ��sql
				while (rs.next())// 5.��Ϣ���
				{
					System.out.println(rs.getString("name"));
					tree(conn,rs.getInt("id"),1);
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
			try
			{
				if (rs != null)
				{
					rs.close();// �ر�
					rs = null;// �ڴ������������
				}

				if (stmt != null)
				{
					stmt.close();// �ر�
					stmt = null;// �ڴ������������
				}

				if (conn != null)
				{

					conn.close();// �ر�
					conn = null;// �ڴ������������
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
			stmt = conn.createStatement();// 3.��ô������
			String Sql = "select * from tree where pid = " + pid;// ִ�е�sql���
			rs = stmt.executeQuery(Sql);// 4.ִ��sql
			while(rs.next())// 5.��Ϣ���
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
					rs.close();// �ر�
					rs = null;// �ڴ������������
				}

				if (stmt != null)
				{
					stmt.close();// �ر�
					stmt = null;// �ڴ������������
				}
////conn�Ǹ��ഫ�����ģ����ܹرգ������ɸ���ر�
//				if (conn != null)
//				{
//
//					conn.close();// �ر�
//					conn = null;// �ڴ������������
//				}
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}
}
