package 模式2单态模式和简单工厂模式.singleton;

class Single{
	private Single(){}
	
	private static final Single s1=new Single();
	public static Single getSingleInstance(){
		return s1;
	}
	public void Say(){
		System.out.println("我开始说话了。。。。");
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