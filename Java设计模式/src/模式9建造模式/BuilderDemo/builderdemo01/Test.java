package ģʽ9����ģʽ.BuilderDemo.builderdemo01;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Director d=new Director();
		Car car=d.buildCar();
		System.out.println(car);

	}

}
