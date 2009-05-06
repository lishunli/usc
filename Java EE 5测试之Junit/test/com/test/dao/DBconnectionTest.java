package com.test.dao;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

public class DBconnectionTest
{

	@Test
	public void testGetCon()
	{
		DB db = new DB();
		
		Connection conn= db.getCon();
		
		assertNotNull(conn);


	}

}
