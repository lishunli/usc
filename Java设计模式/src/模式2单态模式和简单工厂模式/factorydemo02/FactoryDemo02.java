package 模式2单态模式和简单工厂模式.factorydemo02;

/*
 * 动态的制作工厂
 * */
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

class Factory{
	public static Car getCarInstance(String type){
		Car c=null;
		if("Benz".equals(type)){
			c=new Benz();
		}
		if("Ford".equals(type)){
			c=new Ford();
		}
		return c;
	}
}
public class FactoryDemo02 {

	public static void main(String[] args)
	{
		Car c=Factory.getCarInstance("Benz");
		if(c!=null){
			c.run();
			c.stop();
		}else{
			System.out.println("造不了这种汽车。。。");
		}
		
//		try{
//			c.run();
//			c.stop();
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
		
		

	}

}