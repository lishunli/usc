package 模式7策略模式.StrategyDemo.strategy;

public class Calc {
	public String oper(float a,float b,char c){
		float add=a+b;
		float jian=a-b;
		float cheng=a*b;
		float chu=0;
		
		
		switch(c){
		case '+':
			return "相加的结果为："+add;
		case '-':
			return "相减的结果为："+jian;
		case '*':
			return "相乘的结果为："+cheng;
		case '/':
		{
			if(b!=0)
			{
				chu=a/b;
				return "相除的结果为："+chu;
			}			
			else
			{
				System.out.println("除数不能为0，请修改除数");
				//return null;
			}
		}
			
		default :
			return "出错啦";
		}
		
	}
}
