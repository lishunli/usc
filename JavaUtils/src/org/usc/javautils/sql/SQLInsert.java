package org.usc.javautils.sql;

import java.util.*;

import org.usc.javautils.string.StringUtil;

/**
 * ���� Insert SQL ������.
 * 
 * @author MZ
 * @date 2009-11-3
 */
public class SQLInsert extends HashMap<String, Object>
{
	private String table;// �����
	private String columns;// ������, �Զ��Ÿ���
	/** �Ƿ���������Ч�� */
	private boolean checkColumn = true;
	/** �Ƿ������ظ�������ֵ, Ĭ������ */
	private boolean allowDuplicate = true;
	/** �б�, ������ܵ����� */
	private List<String> columnList = new ArrayList<String>();

	public SQLInsert()
	{
	}

	/**
	 * ��������������(��������)�Ĺ�����.
	 * 
	 * @param table
	 *            - ����
	 * @param columns
	 *            - ����(��������)
	 */
	public SQLInsert(String table, String columns)
	{
		setTable(table);
		setColumns(columns);
	}

	public static void main(String[] args)
	{
		SQLInsert insert = new SQLInsert();
		insert.setTable("Test");
		insert.setColumns("id, name ,age");
		insert.put("id", "1");
		insert.put("name", "1");
		insert.put("age", 20);
		System.out.println(insert);
	}

	public String toString()
	{
		if (table == null || table.length() == 0)
		{
			throw new Error("�Բ���, ����� setTable() ָ������");
		}
		String sql = "insert into " + table + " ( ";
		String values = "values( ";
		if (this.size() == 0)
		{
			throw new Error("�Բ���, û���κ���ֵ, �޷����� INSERT ���");
		} else if (columnList.size() == 0)
		{
			// ���Դ������б����������б�
			String[] cols = this.keySet().toArray(new String[0]);
			for (String col : cols)
			{
				columnList.add(col);
			}
		}
		// System.out.println("columnList=" + columnList.size());
		if (columnList.size() > 0)
		{
			for (int i = 0; i < columnList.size(); i++)
			{
				String col = columnList.get(i);
				Object value = this.get(col);
				if (value == null && checkColumn)
				{
					throw new Error("�Բ���, ��[" + col + "]��ֵΪ��");
				}
				sql += col;
				if (!StringUtil.isNumeric(value + ""))
				{
					values += "'" + value + "'";
				} else
				{
					values += value;
				}
				if (columnList.size() > 1 && (i != columnList.size() - 1))
				{
					sql += (", ");
					values += (", ");
				}
			}
		}

		sql += (" ) ");
		values += (" )");

		// System.out.println("�Զ����ɵ� sql = " + sql + values);
		return sql + values;
	}

	/**
	 * @param columns
	 *            the ������, �Զ��Ÿ��� to set
	 */
	public void setColumns(String columns)
	{
		this.columns = columns;
		columnList.clear();
		if (columns != null)
		{
			// �滻�ո���ַ�, ������������
			StringBuffer buff = new StringBuffer();
			for (int i = 0; i < columns.length(); i++)
			{
				char ch = columns.charAt(i);
				if (Character.isSpaceChar(ch))
				{
					continue;
				}
				buff.append(ch);
			}
			String[] cols = buff.toString().split(",");
			// System.out.println("cols.length=" + cols.length);
			for (String col : cols)
			{
				columnList.add(col);
			}
		}
	}

	/**
	 * @return the �Ƿ������ظ�������ֵ, Ĭ������
	 */
	public boolean isAllowDuplicate()
	{
		return allowDuplicate;
	}

	/**
	 * @param allowDuplicate
	 *            the �Ƿ������ظ�������ֵ, Ĭ������ to set
	 */
	public void setAllowDuplicate(boolean allowDuplicate)
	{
		this.allowDuplicate = allowDuplicate;
	}

	/**
	 * @return the �Ƿ���������Ч��
	 */
	public boolean isCheckColumn()
	{
		return checkColumn;
	}

	/**
	 * @param checkColumn
	 *            the �Ƿ���������Ч�� to set
	 */
	public void setCheckColumn(boolean checkColumn)
	{
		this.checkColumn = checkColumn;
	}

	/**
	 * @return the ������, �Զ��Ÿ���
	 */
	public String getColumns()
	{
		return columns;
	}

	/**
	 * �����
	 * 
	 * @return
	 */
	public String getTable()
	{
		return table;
	}

	/**
	 * �����
	 * 
	 * @param table
	 */
	public void setTable(String table)
	{
		this.table = table;
	}
}
