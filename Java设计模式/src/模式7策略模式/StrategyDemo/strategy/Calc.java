package ģʽ7����ģʽ.StrategyDemo.strategy;

public class Calc {
	public String oper(float a,float b,char c){
		float add=a+b;
		float jian=a-b;
		float cheng=a*b;
		float chu=0;
		
		
		switch(c){
		case '+':
			return "��ӵĽ��Ϊ��"+add;
		case '-':
			return "����Ľ��Ϊ��"+jian;
		case '*':
			return "��˵Ľ��Ϊ��"+cheng;
		case '/':
		{
			if(b!=0)
			{
				chu=a/b;
				return "����Ľ��Ϊ��"+chu;
			}			
			else
			{
				System.out.println("��������Ϊ0�����޸ĳ���");
				//return null;
			}
		}
			
		default :
			return "������";
		}
		
	}
}
