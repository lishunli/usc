package ģʽ4���󹤳�ģʽ.FactoryDemo03;

interface Person{
	public void eat();
	public void talk();
}
//����
class Man implements Person{
	public void eat(){
		System.out.println("�����ٳԶ�����������");
	}
	public void talk(){
		System.out.println("������˵����������");
	}
}
//Ů��
class Woman implements Person{
	public void eat(){
		System.out.println("Ů���ٳԶ�����������");
	}
	public void talk(){
		System.out.println("Ů����˵����������");
	}
}

interface Animal{
	public void eat();
	public void sleep();
}
//��ţ
class Bull implements Animal{
	public void eat(){
		System.out.println("Bull�ٳԶ�������������");
	}
	public void sleep(){
		System.out.println("Bull˯���ˡ�������");
	}
}
//ĸţ
class Cow implements Animal{
	public void eat(){
		System.out.println("Cow�ٳԶ�������������");
	}
	public void sleep(){
		System.out.println("Cow˯���ˡ�������");
	}
}
//NWFactory-->Ů�
interface NWFactory{
	public Person getPerson(String type);
	public Animal getAnimal(String type);
}
//����-->���������˺����Զ��Bull��
class YangSheng implements NWFactory{
	Man m=null;
	Bull b=null;
	public Man getPerson(String type){
		try {
			m=(Man)Class.forName("ģʽ4���󹤳�ģʽ.FactoryDemo03."+type).newInstance();
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return m;
	}
	public Bull getAnimal(String type){
		try {
			b=(Bull)Class.forName("ģʽ4���󹤳�ģʽ.FactoryDemo03."+type).newInstance();
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return b;
	}
}
//����-->������Ů�˺ʹ��Զ��Cow��
class YinSheng implements NWFactory{
	Woman w=null;
	Cow c=null;
	public Woman getPerson(String type){
		try {
			w=(Woman)Class.forName("ģʽ4���󹤳�ģʽ.FactoryDemo03."+type).newInstance();
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return w;
	}
	public Cow getAnimal(String type){
		try {
			c=(Cow)Class.forName("ģʽ4���󹤳�ģʽ.FactoryDemo03."+type).newInstance();
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return c;
	}
}

public class FactoryDemo03 {

	public static void main(String[] args) {
		//ʵ����һ������,ys
		YangSheng ys=new YangSheng();
		//ʵ����һ������,ys1
		YinSheng ys1=new YinSheng();
		//�����˺�Ů��,p1������,p2��Ů��
		Person p1=null;
		p1=ys.getPerson("Woman");
		if(p1!=null){
			p1.eat();
			p1.talk();			
		}
		else {
			System.out.println("�������˵�ʱ����ѡ����ȷ������");
		}
		
		Person p2=null;
		p2=ys1.getPerson("Woman");
		if(p2!=null){
			p2.eat();
			p2.talk();			
		}
		else {
			System.out.println("����Ů�˵�ʱ����ѡ����ȷ������");
		}
		
		//�춯�a1�ǹ�ţ��Bull����a2��ĸţ��Cow��
		Animal a1=null;
		a1=ys.getAnimal("Bull");
		if(a1!=null){
			a1.eat();
			a1.sleep();			
		}
		else {
			System.out.println("���칫ţ��ʱ����ѡ����ȷ������");
		}
		
		
		Animal a2=null;
		a2=ys1.getAnimal("Cow");
		if(a2!=null){
			a2.eat();
			a2.sleep();		
		}
		else {
			System.out.println("����ĸţ��ʱ����ѡ����ȷ������");
		}
		
	}

}
