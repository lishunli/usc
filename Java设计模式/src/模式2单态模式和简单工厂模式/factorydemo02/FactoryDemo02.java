package ģʽ2��̬ģʽ�ͼ򵥹���ģʽ.factorydemo02;

/*
 * ��̬����������
 * */
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
	public static Car getCarInstance(String type){
		Car c=null;
		if("Benz".equals(type)){
			c=new Benz();
		}
		if("Ford".equals(type)){
			c=new Ford();
		}
		return c;
	}
}
public class FactoryDemo02 {

	public static void main(String[] args)
	{
		Car c=Factory.getCarInstance("Benz");
		if(c!=null){
			c.run();
			c.stop();
		}else{
			System.out.println("�첻����������������");
		}
		
//		try{
//			c.run();
//			c.stop();
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
		
		

	}

}