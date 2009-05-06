package 模式2单态模式和简单工厂模式.factorydemo01;

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
	public static Car getCarInstance(){
		return new Ford();
	}
}
public class FactoryDemo01 {

	public static void main(String[] args) {
		Car c=Factory.getCarInstance();
		c.run();
		c.stop();

	}

}
