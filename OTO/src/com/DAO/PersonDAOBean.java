package com.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.pojo.IDCard;
import com.pojo.Person;

public @Stateless
class PersonDAOBean implements PersonDAO
{
	@PersistenceContext
	// ejb的上下文对象
	private EntityManager em;// ejb实体bean的操作类对象

	public void deletePerson(Integer personid)
	{
		Person person = em.find(Person.class, personid);
		if (person != null)
			em.remove(person);
	}

	public Person getPersonByID(Integer personid)
	{
		Person person = em.find(Person.class, personid);// QBC查询方式
		return person;

	}

	public void insertPerson(String name, boolean sex, short age,
			String birthday, String cardID)
	{
		Person person = new Person();// 生成实体BEAN的对象
		person.setName(name);
		person.setSex(sex);
		person.setAge(Short.valueOf(age));
		person.setBirthday(birthday);

		IDCard idcard = new IDCard(cardID);// 生成实体BEAN的对象

		idcard.setPerson(person);
		person.setIdcard(idcard);// 设置双向关联

		em.persist(person);// 插入数据库

	}

	public void updatePersonInfo(Integer personid, String newname,
			String newIDcard)
	{
		Person person = em.find(Person.class, personid);// QBC查询
		if (person != null)
		{
			person.setName(newname);
			if (person.getIdcard() != null)
			{
				person.getIdcard().setCardno(newIDcard);
			}
			em.merge(person);// 更新方法
		}

	}

}
