package 模式1抽象类与适配器模式.Demo2;

interface Eat{
	public void eatBread();
	public void eatApple();
	public void eatBanana();
}

abstract class PersonEat implements Eat{
	public void eatBread(){
		
	}
	public void eatApple(){}
	public void eatBanana(){}
}

class Person extends PersonEat{
	public void eatBread(){
		System.out.println("我在吃面包");
	}
	
	public void eatApple(){
		System.out.println("我在吃苹果");
	}
}


public class Demo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p=new Person();
		p.eatBread();
		p.eatApple();

	}

}
