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
	// ejb�������Ķ���
	private EntityManager em;// ejbʵ��bean�Ĳ��������

	public void deletePerson(Integer personid)
	{
		Person person = em.find(Person.class, personid);
		if (person != null)
			em.remove(person);
	}

	public Person getPersonByID(Integer personid)
	{
		Person person = em.find(Person.class, personid);// QBC��ѯ��ʽ
		return person;

	}

	public void insertPerson(String name, boolean sex, short age,
			String birthday, String cardID)
	{
		Person person = new Person();// ����ʵ��BEAN�Ķ���
		person.setName(name);
		person.setSex(sex);
		person.setAge(Short.valueOf(age));
		person.setBirthday(birthday);

		IDCard idcard = new IDCard(cardID);// ����ʵ��BEAN�Ķ���

		idcard.setPerson(person);
		person.setIdcard(idcard);// ����˫�����

		em.persist(person);// �������ݿ�

	}

	public void updatePersonInfo(Integer personid, String newname,
			String newIDcard)
	{
		Person person = em.find(Person.class, personid);// QBC��ѯ
		if (person != null)
		{
			person.setName(newname);
			if (person.getIdcard() != null)
			{
				person.getIdcard().setCardno(newIDcard);
			}
			em.merge(person);// ���·���
		}

	}

}
