package com.DAO;

import javax.ejb.Remote;

@Remote
public interface ProcCall {
//	调用无返回参数的存储过程
	public String QueryNoneReturnValueStoreProcedure();
	//调用返回单值的存储过程(数据表的某一个字段)
	public String QuerySingleObjectStoreProcedure(Integer id);
//	调用返回全部的存储过程
	public String QueryStoreProcedure();
//	调用部分的存储过程
	public String QueryPartColumnStoreProcedure();
}
