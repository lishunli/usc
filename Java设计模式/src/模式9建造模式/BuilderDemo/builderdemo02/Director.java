package 模式9建造模式.BuilderDemo.builderdemo02;

public class Director {
	private BuilderCar bc=new BuilderCar();
	private BuilderTrain bt=new BuilderTrain();
	//命令造汽车
	public Car buildCar(){
		bc.carPart1();
		bc.carPart2();
		bc.carPart3();
		Car car=bc.carOver();
		return car;
	}
	
	//命令造火车
	public Train buildTrain(){
		bt.trainPart();
		bt.loco();
		Train train=bt.trainOver();
		return train;
	}
	
}
