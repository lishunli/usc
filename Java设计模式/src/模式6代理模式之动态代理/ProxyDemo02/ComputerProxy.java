package 模式6代理模式之动态代理.ProxyDemo02;

import java.lang.reflect.Proxy;

public class ComputerProxy {
	public static SaleComputer getComputerMaker(){
		ProxyFunction pf=new ProxyFunction();
		return (SaleComputer)Proxy.newProxyInstance(ComputerMaker.class.getClassLoader(), ComputerMaker.class.getInterfaces(), pf);
	}
}
