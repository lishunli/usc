package 模式4抽象工厂模式.FactoryDemo03;

interface Person{
	public void eat();
	public void talk();
}
//男人
class Man implements Person{
	public void eat(){
		System.out.println("男人再吃东西。。。。");
	}
	public void talk(){
		System.out.println("男人在说话。。。。");
	}
}
//女人
class Woman implements Person{
	public void eat(){
		System.out.println("女人再吃东西。。。。");
	}
	public void talk(){
		System.out.println("女人在说话。。。。");
	}
}

interface Animal{
	public void eat();
	public void sleep();
}
//公牛
class Bull implements Animal{
	public void eat(){
		System.out.println("Bull再吃东西。。。。。");
	}
	public void sleep(){
		System.out.println("Bull睡觉了。。。。");
	}
}
//母牛
class Cow implements Animal{
	public void eat(){
		System.out.println("Cow再吃东西。。。。。");
	}
	public void sleep(){
		System.out.println("Cow睡觉了。。。。");
	}
}
//NWFactory-->女娲
interface NWFactory{
	public Person getPerson(String type);
	public Animal getAnimal(String type);
}
//阳绳-->用来造男人和雄性动物（Bull）
class YangSheng implements NWFactory{
	Man m=null;
	Bull b=null;
	public Man getPerson(String type){
		try {
			m=(Man)Class.forName("模式4抽象工厂模式.FactoryDemo03."+type).newInstance();
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return m;
	}
	public Bull getAnimal(String type){
		try {
			b=(Bull)Class.forName("模式4抽象工厂模式.FactoryDemo03."+type).newInstance();
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return b;
	}
}
//阴绳-->用来造女人和雌性动物（Cow）
class YinSheng implements NWFactory{
	Woman w=null;
	Cow c=null;
	public Woman getPerson(String type){
		try {
			w=(Woman)Class.forName("模式4抽象工厂模式.FactoryDemo03."+type).newInstance();
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return w;
	}
	public Cow getAnimal(String type){
		try {
			c=(Cow)Class.forName("模式4抽象工厂模式.FactoryDemo03."+type).newInstance();
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return c;
	}
}

public class FactoryDemo03 {

	public static void main(String[] args) {
		//实例化一个阳绳,ys
		YangSheng ys=new YangSheng();
		//实例化一个阴绳,ys1
		YinSheng ys1=new YinSheng();
		//造男人和女人,p1是男人,p2是女人
		Person p1=null;
		p1=ys.getPerson("Woman");
		if(p1!=null){
			p1.eat();
			p1.talk();			
		}
		else {
			System.out.println("在造男人的时候请选择正确的神绳");
		}
		
		Person p2=null;
		p2=ys1.getPerson("Woman");
		if(p2!=null){
			p2.eat();
			p2.talk();			
		}
		else {
			System.out.println("在造女人的时候请选择正确的神绳");
		}
		
		//造动物，a1是公牛（Bull），a2是母牛（Cow）
		Animal a1=null;
		a1=ys.getAnimal("Bull");
		if(a1!=null){
			a1.eat();
			a1.sleep();			
		}
		else {
			System.out.println("在造公牛的时候请选择正确的神绳");
		}
		
		
		Animal a2=null;
		a2=ys1.getAnimal("Cow");
		if(a2!=null){
			a2.eat();
			a2.sleep();		
		}
		else {
			System.out.println("在造母牛的时候请选择正确的神绳");
		}
		
	}

}
