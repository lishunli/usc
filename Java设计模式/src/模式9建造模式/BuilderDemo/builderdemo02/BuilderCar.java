package ģʽ9����ģʽ.BuilderDemo.builderdemo02;

public class BuilderCar {
	private Car car=new Car();
	public void carPart1(){
		System.out.println("�����Ŀ�������");
	}
	public void carPart2(){
		System.out.println("�����ĵ��������");
	}
	public void carPart3(){
		System.out.println("��������̥�����");
	}
	public Car carOver(){
		return car;
	}
}
