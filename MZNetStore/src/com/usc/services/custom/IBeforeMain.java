package com.usc.services.custom;

import java.util.List;

import com.usc.daos.Custom;

public interface IBeforeMain {

	public void saveCustom(Custom costom);
	
	public List<Custom> findbyCustomName(String customName);
	
	public List<Custom> findByEmail(String email);
	
	public String encoderByMd5(String password);
	
}
