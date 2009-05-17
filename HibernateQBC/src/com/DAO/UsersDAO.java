package com.DAO;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.pojo.Users;
import com.util.HibernateSessionFactory;

//QBC的查询不支持SQL的函数
public class UsersDAO
{
	private Session session;

	public UsersDAO()
	{
		session = HibernateSessionFactory.getSession();
	}

	public void closeSession()
	{
		if (session.isOpen())
			session.close();
	}

	@SuppressWarnings("unchecked")
	public void search()
	{
		//QBC的查询方法
		//1.查询全部
		
		//定义整体的模板
		Criteria cr =session.createCriteria(Users.class);//指定要查询的表---以类的方式书写
		
		//添加查询条件（条件对象）
		Criterion c1 =Expression.like("uname", "李%");
		Criterion c2 =Expression.eq("upass", "li");
		
		//条件添加到模板中
		cr.add(c1);
		cr.add(c2);
		
		List<Users> users=cr.list();
		for(Users user : users)
		{
			System.out.println(""+user.getUname()+"\t"+user.getUpass());
		}
		
		//另一种快捷的查询
		
		Criteria cr1 = session.createCriteria(Users.class)
								.add(Expression.gt("uid", 2))//uid大于2
								.add(Expression.not(Expression.eq("uid", 4)))//uid不等于4
								.add(Expression.isNotNull("uname"))//uname 为空
								.add(Expression.in("uname", new String[]{"a","b","aa"}))//姓名在a和b中
								.add(Expression.between("uid", 7, 25))//between in
//							    .add(Expression.not(Expression.between("uid", 7, 25)))//between not in
								.add(Expression.like("uname", "a_").ignoreCase())//uname 以a打头，长度为二，忽略大小写
								.addOrder(Order.asc("uid"))//排序
								.setFirstResult(0)
								.setMaxResults(5)//分页
								;
		
		List<Users> users1 =cr1.list();
		for(Users user: users1)
		{
			System.out.println(user.getUid()+"\t"+user.getUname()+"\t"+user.getUpass());
		}
		
		
//		 //命名查询语句的调用
		 Query q=session.getNamedQuery("select");
		 q.setString("name", "a%");
		 List l=q.list();
		 System.out.println(l.size());
		
		

		
		
	}
	// @SuppressWarnings("unchecked")
	// public void search(){
	// //命名查询语句的调用
	// Query q=session.getNamedQuery("zkLook");
	// q.setString("name", "t%");
	// List l=q.list();
	// System.out.println(l.size());
	// //QBC的查询方法
	// //1.查询全部
	// Criteria cr=session.createCriteria(Users.class);//指定要查询的表---以类的方式书写
	// //定义整体的模板
	// //添加查询条件
	// Criterion c1=Expression.like("uname", "t%");
	// Criterion c2=Expression.eq("upass", "123");
	// //条件添加到模板中
	//		
	// Criteria c=session.createCriteria(Users.class)
	// .add(Expression.gt("uid",4))// >某个值的判断
	// .add(Expression.not(Expression.eq("uid",6)))// uid !=6
	// .add(Expression.isNull("uname"))//某列为空
	// .add(Expression.in("name", new String[]{"tom","may","jone"})) //name in
	// "tom","may","jone"
	// .add(Expression.between("uid", 18, 25))//uid in 18---25
	// .add(Expression.not(Expression.between("uid", 18, 25)))//uid not in
	// 18---25
	// .add(Expression.like("uname", "T_ _").ignoreCase())
	// .addOrder(Order.desc("uid"))
	// .setFirstResult(1)
	// .setMaxResults(5);
	// cr.add(c1);
	// cr.add(c2);
	// List< Users> list=cr.list();
	// for (Iterator<Users> iter = list.iterator(); iter.hasNext();) {
	// Users element = iter.next();
	// System.out.println(element.getUname()+ "   "+element.getUpass());
	// }
	// }
	//	
	//	
	//	
	//	
	//	

}
