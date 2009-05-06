package 模式7策略模式.StrategyDemo.strategy2;

public class Cheng extends Operation{
	public void oper(float a,float b){
		float result=a*b;
		System.out.println("相乘的结果为-->"+result);
	}
}
