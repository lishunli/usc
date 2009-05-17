
package com.DAO;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pojo.Photo;
import com.util.HSF;

/*
 2008-1-15����10:51:01
 ���ߣ���èzk
 ��Ȩ���У������ο�
 */
public class PhotoDAO {
	private Session session;
	public PhotoDAO(){
		this.session=HSF.getSession();
	}
	public void closeSession(){
		if(session.isOpen()){
			session.close();
		}
	}
	public void addPhoto(Photo p){
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(p);
		tx.commit();
	}
	public Photo getByName(String pname){
		String hql="from Photo p where p.pname=?";
		Query query=session.createQuery(hql);
		query.setString(0, pname);
		return (Photo) query.uniqueResult();
	}

}
