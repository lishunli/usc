package ģʽ7����ģʽ.StrategyDemo.strategy2;

public class Chu extends Operation{
	public void oper(float a,float b){
		float result=0;
		
		if(b!=0)
		{
			result=a/b;
			System.out.println("����Ľ��Ϊ-->"+result);
		}			
		else
		{
			System.out.println("��������Ϊ0�����޸ĳ���");
			//return null;
		}
		
		
	}
}