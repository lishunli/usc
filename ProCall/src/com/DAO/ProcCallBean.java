package com.DAO;

import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.pojo.Person;

@Stateless
public  class ProcCallBean implements ProcCall {
	// 调用无返回参数的存储过程
	@PersistenceContext
	private EntityManager em;

	public String QueryNoneReturnValueStoreProcedure() {
		Query query = em.createNativeQuery("{call addperson()}");// 创建查询对象
		query.executeUpdate();// 存储过程的执行
		StringBuffer out = new StringBuffer("*************** QueryNoneReturnValueStoreProcedure  结果打印  ****************");
		return out.toString();

	}

	// 调用返回单值的存储过程(数据表的某一个字段)
	public String QuerySingleObjectStoreProcedure(Integer id) {
		Query query = em.createNativeQuery("{call GetPersonName(?)}");// 以?的方式进行传参
		query.setParameter(1, id);// 以对象的方式传递
//		String result =  query.getSingleResult().toString();// 取出唯一的结果 where
//		query.getSingleResult();
		List result = query.getResultList();
//		// xxx=参数
		StringBuffer out = new StringBuffer(
				"*************** QuerySingleObjectStoreProcedure  结果打印  ****************");
//		out.append("\n" + "返回值(人员姓名)为：" + result);
//		return out.toString();
		
		if (result != null) {
			Iterator iterator = result.iterator();
			while (iterator.hasNext()) {
				// 取每一行
				Object[] row = (Object[]) iterator.next();//行变量
				// 数组中的第一个值是 personid
				
				String PersonName = row[1].toString();
				out.append("\n\t"+ "返回值(人员姓名)为："+ PersonName);
			}
		}

		return out.toString();


	}

	// //调用返回全部的存储过程

	public String QueryStoreProcedure() {
		Query query = em.createNativeQuery("{call getpersonlist()}",
				Person.class);
		// Person.personid(属性)------Rs(personid)----->setXXX
		List result = query.getResultList();// 自动将结果集===>对象集合
		StringBuffer out = new StringBuffer(
				"*************** QueryStoreProcedure  结果打印****************");
		if (result != null) {
			Iterator iterator = result.iterator();
			while (iterator.hasNext()) {
				Person person = (Person) iterator.next();
				out.append("\n\t"+person.getPersonname());
				out.append("\t"+person.getAge());
				out.append("\t"+person.getSex());
				out.append("\t"+person.getPersonid());
			}
		}
		return out.toString();

	}

	// 调用返回全部的存储过程

	public String QueryPartColumnStoreProcedure() {
		// 调用返回部分列的存储过程
		Query query = em.createNativeQuery("{call GetPersonPartProperties()}");//不指定返回类型则返回对象数组
		List result = query.getResultList();
		StringBuffer out = new StringBuffer(
				"*************** QueryPartColumnStoreProcedure  结果打印****************");
		if (result != null) {
			Iterator iterator = result.iterator();
			while (iterator.hasNext()) {
				// 取每一行
				Object[] row = (Object[]) iterator.next();//行变量
				// 数组中的第一个值是 personid
				int personid = Integer.parseInt(row[0].toString());
				String PersonName = row[1].toString();
				out
						.append("\n\t"+"人员 ID=" + "\t"+personid + "\t"+";  姓名=" + PersonName
								);
			}
		}
		return out.toString();

	}
}
