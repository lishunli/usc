package ģʽ9����ģʽ.BuilderDemo.builderdemo02;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Director d=new Director();
		Car car=d.buildCar();
		System.out.println(car);
		
		Director d1=new Director();
		Train train=d1.buildTrain();
		System.out.println(train);

	}

}
