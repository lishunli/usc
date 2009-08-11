package com.usc.service;

import java.util.List;

import com.usc.dao.Pct;
import com.usc.dao.PctDAO;

public class PCTServiceImpl implements IPCTService
{
	private PctDAO pdao;
	
	public void setPdao(PctDAO pdao)
	{
		this.pdao = pdao;
	}

	public List<Pct> getCountrys(String pctID)
	{
		return  pdao.findByPctid(pctID);
	}

}
