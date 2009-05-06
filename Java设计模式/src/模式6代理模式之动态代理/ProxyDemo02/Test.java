package 模式6代理模式之动态代理.ProxyDemo02;

public class Test {

	
	public static void main(String[] args) {
		SaleComputer sc=ComputerProxy.getComputerMaker();
//		sc.sale("联想");
		sc.sale("三星");
//		sc.sale("Dell");

	}

}
