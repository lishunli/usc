package com.DAO;

import javax.ejb.Remote;

@Remote
public interface ProcCall {
//	�����޷��ز����Ĵ洢����
	public String QueryNoneReturnValueStoreProcedure();
	//���÷��ص�ֵ�Ĵ洢����(���ݱ��ĳһ���ֶ�)
	public String QuerySingleObjectStoreProcedure(Integer id);
//	���÷���ȫ���Ĵ洢����
	public String QueryStoreProcedure();
//	���ò��ֵĴ洢����
	public String QueryPartColumnStoreProcedure();
}
