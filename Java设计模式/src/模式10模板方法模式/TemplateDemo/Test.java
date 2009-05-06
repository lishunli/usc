package 模式10模板方法模式.TemplateDemo;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Template t=new NotePC("笔记本");
		Template t1=new PC("台式机");
		t.makePC();
		t1.makePC();

	}

}
