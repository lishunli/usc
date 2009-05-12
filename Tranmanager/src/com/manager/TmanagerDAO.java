package com.manager;

import javax.ejb.Remote;

@Remote
public interface TmanagerDAO {
	public void insertTP(String name, Float price, boolean error);
	public void ModifyTP(String newname, boolean error) throws Exception ;

}
