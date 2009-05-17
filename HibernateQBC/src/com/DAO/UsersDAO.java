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

//QBC�Ĳ�ѯ��֧��SQL�ĺ���
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
		//QBC�Ĳ�ѯ����
		//1.��ѯȫ��
		
		//���������ģ��
		Criteria cr =session.createCriteria(Users.class);//ָ��Ҫ��ѯ�ı�---����ķ�ʽ��д
		
		//��Ӳ�ѯ��������������
		Criterion c1 =Expression.like("uname", "��%");
		Criterion c2 =Expression.eq("upass", "li");
		
		//������ӵ�ģ����
		cr.add(c1);
		cr.add(c2);
		
		List<Users> users=cr.list();
		for(Users user : users)
		{
			System.out.println(""+user.getUname()+"\t"+user.getUpass());
		}
		
		//��һ�ֿ�ݵĲ�ѯ
		
		Criteria cr1 = session.createCriteria(Users.class)
								.add(Expression.gt("uid", 2))//uid����2
								.add(Expression.not(Expression.eq("uid", 4)))//uid������4
								.add(Expression.isNotNull("uname"))//uname Ϊ��
								.add(Expression.in("uname", new String[]{"a","b","aa"}))//������a��b��
								.add(Expression.between("uid", 7, 25))//between in
//							    .add(Expression.not(Expression.between("uid", 7, 25)))//between not in
								.add(Expression.like("uname", "a_").ignoreCase())//uname ��a��ͷ������Ϊ�������Դ�Сд
								.addOrder(Order.asc("uid"))//����
								.setFirstResult(0)
								.setMaxResults(5)//��ҳ
								;
		
		List<Users> users1 =cr1.list();
		for(Users user: users1)
		{
			System.out.println(user.getUid()+"\t"+user.getUname()+"\t"+user.getUpass());
		}
		
		
//		 //������ѯ���ĵ���
		 Query q=session.getNamedQuery("select");
		 q.setString("name", "a%");
		 List l=q.list();
		 System.out.println(l.size());
		
		

		
		
	}
	// @SuppressWarnings("unchecked")
	// public void search(){
	// //������ѯ���ĵ���
	// Query q=session.getNamedQuery("zkLook");
	// q.setString("name", "t%");
	// List l=q.list();
	// System.out.println(l.size());
	// //QBC�Ĳ�ѯ����
	// //1.��ѯȫ��
	// Criteria cr=session.createCriteria(Users.class);//ָ��Ҫ��ѯ�ı�---����ķ�ʽ��д
	// //���������ģ��
	// //��Ӳ�ѯ����
	// Criterion c1=Expression.like("uname", "t%");
	// Criterion c2=Expression.eq("upass", "123");
	// //������ӵ�ģ����
	//		
	// Criteria c=session.createCriteria(Users.class)
	// .add(Expression.gt("uid",4))// >ĳ��ֵ���ж�
	// .add(Expression.not(Expression.eq("uid",6)))// uid !=6
	// .add(Expression.isNull("uname"))//ĳ��Ϊ��
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
