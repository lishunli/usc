package 模式10模板方法模式.TemplateDemo;

public class PC extends Template{

	public PC(String pcType) {
		super(pcType);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void makeCPU(String pcType) {
		// TODO Auto-generated method stub
		System.out.println(pcType+"的CPU造好了");
		
	}

	@Override
	protected void makeHD(String pcType) {
		// TODO Auto-generated method stub
		System.out.println(pcType+"的硬盘造好了");
	}

	@Override
	protected void makeMainBorad(String pcType) {
		// TODO Auto-generated method stub
		System.out.println(pcType+"的主板造好了");
	}

}
