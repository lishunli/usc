package 模式9建造模式.BuilderDemo.builderdemo02;

public class BuilderCar {
	private Car car=new Car();
	public void carPart1(){
		System.out.println("汽车的框架完成了");
	}
	public void carPart2(){
		System.out.println("汽车的底盘完成了");
	}
	public void carPart3(){
		System.out.println("汽车的轮胎完成了");
	}
	public Car carOver(){
		return car;
	}
}
