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
	// �����޷��ز����Ĵ洢����
	@PersistenceContext
	private EntityManager em;

	public String QueryNoneReturnValueStoreProcedure() {
		Query query = em.createNativeQuery("{call addperson()}");// ������ѯ����
		query.executeUpdate();// �洢���̵�ִ��
		StringBuffer out = new StringBuffer("*************** QueryNoneReturnValueStoreProcedure  �����ӡ  ****************");
		return out.toString();

	}

	// ���÷��ص�ֵ�Ĵ洢����(���ݱ��ĳһ���ֶ�)
	public String QuerySingleObjectStoreProcedure(Integer id) {
		Query query = em.createNativeQuery("{call GetPersonName(?)}");// ��?�ķ�ʽ���д���
		query.setParameter(1, id);// �Զ���ķ�ʽ����
//		String result =  query.getSingleResult().toString();// ȡ��Ψһ�Ľ�� where
//		query.getSingleResult();
		List result = query.getResultList();
//		// xxx=����
		StringBuffer out = new StringBuffer(
				"*************** QuerySingleObjectStoreProcedure  �����ӡ  ****************");
//		out.append("\n" + "����ֵ(��Ա����)Ϊ��" + result);
//		return out.toString();
		
		if (result != null) {
			Iterator iterator = result.iterator();
			while (iterator.hasNext()) {
				// ȡÿһ��
				Object[] row = (Object[]) iterator.next();//�б���
				// �����еĵ�һ��ֵ�� personid
				
				String PersonName = row[1].toString();
				out.append("\n\t"+ "����ֵ(��Ա����)Ϊ��"+ PersonName);
			}
		}

		return out.toString();


	}

	// //���÷���ȫ���Ĵ洢����

	public String QueryStoreProcedure() {
		Query query = em.createNativeQuery("{call getpersonlist()}",
				Person.class);
		// Person.personid(����)------Rs(personid)----->setXXX
		List result = query.getResultList();// �Զ��������===>���󼯺�
		StringBuffer out = new StringBuffer(
				"*************** QueryStoreProcedure  �����ӡ****************");
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

	// ���÷���ȫ���Ĵ洢����

	public String QueryPartColumnStoreProcedure() {
		// ���÷��ز����еĴ洢����
		Query query = em.createNativeQuery("{call GetPersonPartProperties()}");//��ָ�����������򷵻ض�������
		List result = query.getResultList();
		StringBuffer out = new StringBuffer(
				"*************** QueryPartColumnStoreProcedure  �����ӡ****************");
		if (result != null) {
			Iterator iterator = result.iterator();
			while (iterator.hasNext()) {
				// ȡÿһ��
				Object[] row = (Object[]) iterator.next();//�б���
				// �����еĵ�һ��ֵ�� personid
				int personid = Integer.parseInt(row[0].toString());
				String PersonName = row[1].toString();
				out
						.append("\n\t"+"��Ա ID=" + "\t"+personid + "\t"+";  ����=" + PersonName
								);
			}
		}
		return out.toString();

	}
}
