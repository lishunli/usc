package 模式7策略模式.StrategyDemo.strategy2;

public class Add extends Operation{
	public void oper(float a,float b){
		float result=a+b;
		System.out.println("相加的结果为-->"+result);
	}
}
