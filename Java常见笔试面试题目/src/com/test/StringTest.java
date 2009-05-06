package com.test;

public class StringTest 
{
	public static void main(String[] args) 
	{
//		new方法产生对象的时候先判断池中有没有该对象，如果有的话就不会产生池对象，而只会产生堆对象
		String s =new String("abc");//s为引用，new后面生成的才是对象，new会产生两个对象：string池和堆对象，而s是指向的堆对象（地址）
//		public String(String original)
//		初始化一个新创建的 String 对象，使其表示一个与参数相同的字符序列；
//		换句话说，新创建的字符串是该参数字符串的副本。由于 String 是不可变的，
//		所以无需使用此构造方法，除非需要 original 的显式副本。
		String s1="abc";//内存里没有产生对象，s1指向的是string池对象（地址）
		
		String s2=new String("abc");//只要有new，就会生产了一个新的堆对象
//		执行上面的三句语句的内存已经生成了三个对象
		
//		在java里面，等号表示的都是比较内存地址，也就是只引用指向的地址空间（对象）
	
//		System.out.println(s==s1);
//		System.out.println(s==s2);
//		System.out.println(s1==s2);
//		
//		System.out.println(s==s.intern());//false
//		System.out.println(s1==s1.intern());//true
//		System.out.println(s2==s2.intern());//false
//		System.out.println(s.intern()==s2.intern());//true
//		System.out.println(s1.intern()==s2.intern());//true
		
//		intern方法返回的是string池中的对象
		
		/*
		 * public String intern()
返回字符串对象的规范化表示形式。 

一个初始为空的字符串池，它由类 String 私有地维护。 

当调用 intern 方法时，如果池已经包含一个等于此 String 对象的字符串（用 equals(Object) 方法确定），则返回池中的字符串。否则，将此 String 对象添加到池中，并返回此 String 对象的引用。 

它遵循以下规则：对于任意两个字符串 s 和 t，当且仅当 s.equals(t) 为 true 时，s.intern() == t.intern() 才为 true。 

所有字面值字符串和字符串赋值常量表达式都使用 intern 方法进行操作。字符串字面值在 Java Language Specification 的 §3.10.5 定义。 


返回：
一个字符串，内容与此字符串相同，但一定取自具有唯一字符串的池。

		 * 
		 * */
		
		
		String hello ="hello";
		
		String hel="hel";
		
		String lo="lo";
		//hello在池中
		System.out.println(hello=="hel"+"lo");//池中已经有了
		System.out.println(hello==hel+"lo");//重新在堆中生成hello对象
		System.out.println(hello=="hel"+lo);//重新在堆中生成hello对象
		System.out.println(hello==hel+lo);//重新在堆中生成hello对象
		
		
		
		
		
	}

}
