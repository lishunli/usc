package 模式7策略模式.StrategyDemo.strategy2;

public class Chu extends Operation{
	public void oper(float a,float b){
		float result=0;
		
		if(b!=0)
		{
			result=a/b;
			System.out.println("相除的结果为-->"+result);
		}			
		else
		{
			System.out.println("除数不能为0，请修改除数");
			//return null;
		}
		
		
	}
}