package ģʽ10ģ�巽��ģʽ.TemplateDemo;

public class NotePC extends Template{

	public NotePC(String pcType) {
		super(pcType);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void makeCPU(String pcType) {
		System.out.println(pcType+"��CPU�����");
		
	}

	@Override
	protected void makeHD(String pcType) {
		System.out.println(pcType+"��Ӳ�������");
		
	}

	@Override
	protected void makeMainBorad(String pcType) {
		System.out.println(pcType+"�����������");
		
	}

}
