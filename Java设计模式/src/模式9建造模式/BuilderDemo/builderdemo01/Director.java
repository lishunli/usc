package 模式9建造模式.BuilderDemo.builderdemo01;

public class Director {
	private Builder b=new BuilderCar();
	
	//命令造汽车
	public Car buildCar(){
		b.carPart1();
		b.carPart2();
		b.carPart3();
		Car car=b.carOver();
		return car;
	}
}
