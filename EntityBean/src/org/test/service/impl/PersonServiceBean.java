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
	//如果只有一个持久化单元的话可以省略unitName
	
	public void delete(Integer personid)
	{
		//正确删除必须是托管状态
		em.remove(em.getReference(Person.class, personid));
		//得到的是代理对象
	}

	
	public Person getPerson(Integer personid)
	{
		return em.find(Person.class,personid);
	}

	
	@SuppressWarnings("unchecked")
	public List getPersons()
	{
		return  em.createQuery("select o from Person o").getResultList();//查询对象
	}

	
	public void save(Person person)
	{
		em.persist(person);

	}

	
	public void update(Person person)
	{
		//游离状态时才行，如果是托管状态的话调用它的私有方法就可以实现
		em.merge(person);
	}

}
