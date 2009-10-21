package org.test.service.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.test.bean.Person;
import org.test.service.PersonService;



@Stateless
@Remote(PersonService.class)
public class PersonServiceBean implements PersonService
{
	@PersistenceContext(unitName="Entity") EntityManager em; 
	//���ֻ��һ���־û���Ԫ�Ļ�����ʡ��unitName
	
	public void delete(Integer personid)
	{
		//��ȷɾ���������й�״̬
		em.remove(em.getReference(Person.class, personid));
		//�õ����Ǵ������
	}

	
	public Person getPerson(Integer personid)
	{
		return em.find(Person.class,personid);
	}

	
	@SuppressWarnings("unchecked")
	public List getPersons()
	{
		return  em.createQuery("select o from Person o").getResultList();//��ѯ����
	}

	
	public void save(Person person)
	{
		em.persist(person);

	}

	
	public void update(Person person)
	{
		//����״̬ʱ���У�������й�״̬�Ļ���������˽�з����Ϳ���ʵ��
		em.merge(person);
	}

}
