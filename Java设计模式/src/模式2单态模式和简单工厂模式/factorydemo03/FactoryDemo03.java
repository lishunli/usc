package 模式2单态模式和简单工厂模式.factorydemo03;

interface Car{
	public void run();
	public void stop();
}

class Benz implements Car{
	public void run(){
		System.out.println("Benz开始启动了。。。。。");
	}
	public void stop(){
		System.out.println("Benz停车了。。。。。");
	}
}

class Ford implements Car{
	public void run(){
		System.out.println("Ford开始启动了。。。");
	}
	public void stop(){
		System.out.println("Ford停车了。。。。");
	}
}

class Toyota implements Car{
	public void run(){
		System.out.println("Toyota开始启动了。。。");
	}
	public void stop(){
		System.out.println("Toyota停车了。。。。");
	}
}

class Factory{
	public static Car getCarInstance(String type){
		Car c=null;
//		使用反射机制来实例化一个对象
		try {
			c=(Car)Class.forName("模式2单态模式和简单工厂模式.factorydemo03."+type).newInstance();
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
public class FactoryDemo03 {

	public static void main(String[] args) {
		Car c=Factory.getCarInstance("Toyotaa");
		if(c!=null){
			c.run();
			c.stop();
		}else{
			System.out.println("造不了这种汽车。。。");
		}
		

	}

}
