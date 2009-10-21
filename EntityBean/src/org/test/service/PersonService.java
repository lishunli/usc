package org.test.service;

import java.util.List;

import org.test.bean.Person;



public interface PersonService
{
	public void save(Person person);
	public void update(Person person);
	public void delete(Integer personid);
	public Person getPerson(Integer personid);
	public List getPersons();
	
}
