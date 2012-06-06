package cn.itcast.service.privilege;

import cn.itcast.bean.privilege.Employee;
import cn.itcast.service.base.DAO;

public interface EmployeeService extends DAO<Employee> {
	/**
	 * �ж��û����Ƿ����
	 * @param username �û���
	 * @return
	 */
	public boolean exist(String username);
	/**
	 * ��ְ����
	 * @param username �û���
	 */
	public void leave(String username);
	/**
	 * �ж��û����������Ƿ���ȷ
	 * @param username �û���
	 * @param password ����
	 * @return
	 */
	public boolean validate(String username, String password);
}