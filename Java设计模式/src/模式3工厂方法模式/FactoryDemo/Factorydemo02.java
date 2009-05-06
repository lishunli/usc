package ģʽ3��������ģʽ.FactoryDemo;

interface Car{
	public void start();
	public void stop();
}

class Benz implements Car{
	public void start(){
		System.out.println("Benz�����ˡ�������");
	}
	public void stop(){
		System.out.println("Benzͣ���ˡ�����");
	}
}

class Ford implements Car{
	public void start(){
		System.out.println("Ford�����ˡ�������");
	}
	public void stop(){
		System.out.println("Fordͣ���ˡ�����");
	}
}

class BigBus implements Car{
	public void start(){
		System.out.println("��Ϳ����ˡ�������");
	}
	public void stop(){
		System.out.println("���ͣ���ˡ�������");
	}
}

class MiniBus implements Car{
	public void start(){
		System.out.println("С�Ϳ����ˡ�������");
	}
	public void stop(){
		System.out.println("С��ͣ���ˡ�������");
	}
}

interface AbstractFactory{
	
}
class CarFactory implements AbstractFactory{
	public Car getCar(String type){
		Car c=null;
		try {
			c=(Car)Class.forName("ģʽ3��������ģʽ.FactoryDemo."+type).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		return c;
	}
	
}

class BusFactory implements AbstractFactory{
	public Car getBus(String type){
		Car c=null;
		try {
			c=(Car)Class.forName("ģʽ3��������ģʽ.FactoryDemo."+type).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		return c;
	}
	
}

public class Factorydemo02 {

	
	public static void main(String[] args) {
		//CarFactory cf=new CarFactory();
		BusFactory bf=new BusFactory();
		Car c=null;
		//c=cf.getCar("Benz");
		c=bf.getBus("BigBus");
		if(c!=null)
		{
			c.start();
			c.stop();
		}
		else{
			System.out.println("this is not");
		}
		
		CarFactory cf =new CarFactory();
		Car c2=null;
		c2=cf.getCar("Benz");
		if(c2!=null)
		{
			c2.start();
			c2.stop();
		}
		else{
			System.out.println("this is not");
		}
	}

}
