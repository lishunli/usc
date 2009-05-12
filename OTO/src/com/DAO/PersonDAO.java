package com.DAO;

import javax.ejb.Remote;

import com.pojo.Person;

@Remote
public interface PersonDAO {
	public void insertPerson(String name, boolean sex, short age,
			String birthday, String cardID);

	public Person getPersonByID(Integer personid);

	public void updatePersonInfo(Integer personid, String newname,
			String newIDcard);

	public void deletePerson(Integer personid);

}
