package com.bjsxt.dp.proxy;


public class Client {
	public static void main(String[] args) throws Exception {
		Tank t = new Tank();
//		InvocationHandler h = new TimeHandler(t);
//		
//		Moveable m = (Moveable)Proxy.newProxyInstance(Moveable.class, h);
//		
//		m.move();
		TankTimeProxy ttp = new TankTimeProxy(t);
		TankLogProxy tlp = new TankLogProxy(ttp);
//		Moveable m = tlp;
		tlp.move();
	}
}
//���Զ�����Ķ�������Ľӿڷ�����ʵ������Ĵ���