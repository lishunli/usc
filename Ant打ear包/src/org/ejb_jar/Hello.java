package org.ejb_jar;

import javax.ejb.Remote;

@Remote
public interface Hello
{
	 public String sayHello(String name);

}
