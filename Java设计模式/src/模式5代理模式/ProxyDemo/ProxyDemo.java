package ģʽ5����ģʽ.ProxyDemo;

abstract class SaleComputer{
	abstract public void SaleComputer();
}
//��ʵ�������ɫ��ComputerMaker��
class ComputerMaker extends SaleComputer{
	public void SaleComputer(){
		System.out.println("������һ̨���ԡ�����");
	}
}
//����������ɫ(ComputerProxy)
class ComputerProxy extends SaleComputer{
	ComputerMaker cm=null;
	public void youHui(){
		System.out.println("�Ҹ����Ż�....");
	}
	public void giveMouse(){
		System.out.println("�һ�����һ����ꡣ����");
	}
	public void SaleComputer(){
		youHui();
		giveMouse();
		if(cm==null){
			cm=new ComputerMaker();
		}
		cm.SaleComputer();
	}
}
public class ProxyDemo {

	
	public static void main(String[] args) {
		//SaleComputer sc=new ComputerMaker();
		SaleComputer sc=new ComputerProxy();
		sc.SaleComputer();

	}

}
