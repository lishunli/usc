package 模式9建造模式.BuilderDemo.builderdemo01;

public abstract class Builder {
	//汽车的框架建造方法
	public abstract void carPart1();
	//汽车的底盘建造方法
	public abstract void carPart2();
	//汽车的轮胎建造方法
	public abstract void carPart3();
	
	//建造好零件后，返还汽车
	public abstract Car carOver();
}
