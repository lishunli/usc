package 模式6代理模式之动态代理.ProxyDemo02;

public class ComputerMaker implements SaleComputer {

	public void sale(String type) {
		System.out.println("卖出了一台"+type+"电脑");

	}

}
