package org.usc.demo.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyHandler implements InvocationHandler {
	Object obj;

	public DynamicProxyHandler() {
	}

	public DynamicProxyHandler(Object obj) {
		this.obj = obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(obj, args);
	}

}
