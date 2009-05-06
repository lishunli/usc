package 模式3工厂方法模式.FactoryDemo;

interface Car{
	public void start();
	public void stop();
}

class Benz implements Car{
	public void start(){
		System.out.println("Benz开动了。。。。");
	}
	public void stop(){
		System.out.println("Benz停车了。。。");
	}
}

class Ford implements Car{
	public void start(){
		System.out.println("Ford开动了。。。。");
	}
	public void stop(){
		System.out.println("Ford停车了。。。");
	}
}

class BigBus implements Car{
	public void start(){
		System.out.println("大巴开车了。。。。");
	}
	public void stop(){
		System.out.println("大巴停车了。。。。");
	}
}

class MiniBus implements Car{
	public void start(){
		System.out.println("小巴开车了。。。。");
	}
	public void stop(){
		System.out.println("小巴停车了。。。。");
	}
}

interface AbstractFactory{
	
}
class CarFactory implements AbstractFactory{
	public Car getCar(String type){
		Car c=null;
		try {
			c=(Car)Class.forName("模式3工厂方法模式.FactoryDemo."+type).newInstance();
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
			c=(Car)Class.forName("模式3工厂方法模式.FactoryDemo."+type).newInstance();
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
