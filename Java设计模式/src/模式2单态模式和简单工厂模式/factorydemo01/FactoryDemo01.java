package ģʽ2��̬ģʽ�ͼ򵥹���ģʽ.factorydemo01;

interface Car{
	public void run();
	public void stop();
}

class Benz implements Car{
	public void run(){
		System.out.println("Benz��ʼ�����ˡ���������");
	}
	public void stop(){
		System.out.println("Benzͣ���ˡ���������");
	}
}

class Ford implements Car{
	public void run(){
		System.out.println("Ford��ʼ�����ˡ�����");
	}
	public void stop(){
		System.out.println("Fordͣ���ˡ�������");
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
