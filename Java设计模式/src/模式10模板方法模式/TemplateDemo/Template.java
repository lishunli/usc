package 模式10模板方法模式.TemplateDemo;

public abstract class Template {
	protected String pcType;
	public Template(String pcType){
		this.pcType=pcType;
	}
	
	//留给子类去实现的基本方法1
	abstract protected void makeCPU(String pcType);
	//留给子类去实现的基本方法2
	abstract protected void makeMainBorad(String pcType);
	//留给子类去实现的基本方法3
	abstract protected void makeHD(String pcType);
	
	//基本方法，已经实现好了
	public final void makeOver(String pcType){
		System.out.println(pcType+"造好了");
	}
	
	//模板方法，造电脑
	public final void makePC(){
		makeCPU(pcType);
		makeMainBorad(pcType);
		makeHD(pcType);
		makeOver(pcType);
	}
}
