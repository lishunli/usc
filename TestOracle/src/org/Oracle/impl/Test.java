package org.Oracle.impl;

/**
 * Test entity. @author MyEclipse Persistence Tools
 */

public class Test implements java.io.Serializable
{

	// Fields

	private TestId id;

	// Constructors

	/** default constructor */
	public Test()
	{
	}

	/** full constructor */
	public Test(TestId id)
	{
		this.id = id;
	}

	// Property accessors

	public TestId getId()
	{
		return this.id;
	}

	public void setId(TestId id)
	{
		this.id = id;
	}

}