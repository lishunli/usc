package 模式5代理模式.ProxyDemo;

abstract class SaleComputer{
	abstract public void SaleComputer();
}
//真实的主题角色（ComputerMaker）
class ComputerMaker extends SaleComputer{
	public void SaleComputer(){
		System.out.println("卖出了一台电脑。。。");
	}
}
//代理的主题角色(ComputerProxy)
class ComputerProxy extends SaleComputer{
	ComputerMaker cm=null;
	public void youHui(){
		System.out.println("我给你优惠....");
	}
	public void giveMouse(){
		System.out.println("我还送你一个鼠标。。。");
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
