package ģʽ2��̬ģʽ�ͼ򵥹���ģʽ.singleton;

class Single{
	private Single(){}
	
	private static final Single s1=new Single();
	public static Single getSingleInstance(){
		return s1;
	}
	public void Say(){
		System.out.println("�ҿ�ʼ˵���ˡ�������");
	}
	
}

public class SingletonDemo {


	public static void main(String[] args) {
		Single s=Single.getSingleInstance();
		s.Say();
//		Single s1=Single.getSingleInstance();
//		s1.Say();

	}

}