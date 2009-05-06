package ģʽ2��̬ģʽ�ͼ򵥹���ģʽ.factorydemo03;

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

class Toyota implements Car{
	public void run(){
		System.out.println("Toyota��ʼ�����ˡ�����");
	}
	public void stop(){
		System.out.println("Toyotaͣ���ˡ�������");
	}
}

class Factory{
	public static Car getCarInstance(String type){
		Car c=null;
//		ʹ�÷��������ʵ����һ������
		try {
			c=(Car)Class.forName("ģʽ2��̬ģʽ�ͼ򵥹���ģʽ.factorydemo03."+type).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		return c;
	}
}
public class FactoryDemo03 {

	public static void main(String[] args) {
		Car c=Factory.getCarInstance("Toyotaa");
		if(c!=null){
			c.run();
			c.stop();
		}else{
			System.out.println("�첻����������������");
		}
		

	}

}
