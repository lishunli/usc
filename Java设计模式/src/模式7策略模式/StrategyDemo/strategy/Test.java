package ģʽ7����ģʽ.StrategyDemo.strategy;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		float a=100;
		float b=(float) 10.5;
		Calc c=new Calc();
		String result=c.oper(a, b, '/');
		System.out.println(result);
	}

}
