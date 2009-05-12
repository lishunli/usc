package org.ejb_jar.impl;

import javax.ejb.Stateless;

import org.ejb_jar.Hello;


@Stateless
public class HelloBean implements Hello
{

	public String sayHello(String name)
	{
		//org.apache.commons.collections,这里假设用到了其它包中的类
//        CollectionUtils c=new CollectionUtils();
//        org.apache.commons.lang
//        StringUtils s=new StringUtils(); 
        return "hello,i am "+name;

	}

}
