package com.test;

public class StringTest 
{
	public static void main(String[] args) 
	{
//		new�������������ʱ�����жϳ�����û�иö�������еĻ��Ͳ�������ض��󣬶�ֻ������Ѷ���
		String s =new String("abc");//sΪ���ã�new�������ɵĲ��Ƕ���new�������������string�غͶѶ��󣬶�s��ָ��ĶѶ��󣨵�ַ��
//		public String(String original)
//		��ʼ��һ���´����� String ����ʹ���ʾһ���������ͬ���ַ����У�
//		���仰˵���´������ַ����Ǹò����ַ����ĸ��������� String �ǲ��ɱ�ģ�
//		��������ʹ�ô˹��췽����������Ҫ original ����ʽ������
		String s1="abc";//�ڴ���û�в�������s1ָ�����string�ض��󣨵�ַ��
		
		String s2=new String("abc");//ֻҪ��new���ͻ�������һ���µĶѶ���
//		ִ����������������ڴ��Ѿ���������������
		
//		��java���棬�Ⱥű�ʾ�Ķ��ǱȽ��ڴ��ַ��Ҳ����ֻ����ָ��ĵ�ַ�ռ䣨����
	
//		System.out.println(s==s1);
//		System.out.println(s==s2);
//		System.out.println(s1==s2);
//		
//		System.out.println(s==s.intern());//false
//		System.out.println(s1==s1.intern());//true
//		System.out.println(s2==s2.intern());//false
//		System.out.println(s.intern()==s2.intern());//true
//		System.out.println(s1.intern()==s2.intern());//true
		
//		intern�������ص���string���еĶ���
		
		/*
		 * public String intern()
�����ַ�������Ĺ淶����ʾ��ʽ�� 

һ����ʼΪ�յ��ַ����أ������� String ˽�е�ά���� 

������ intern ����ʱ��������Ѿ�����һ�����ڴ� String ������ַ������� equals(Object) ����ȷ�������򷵻س��е��ַ��������򣬽��� String ������ӵ����У������ش� String ��������á� 

����ѭ���¹��򣺶������������ַ��� s �� t�����ҽ��� s.equals(t) Ϊ true ʱ��s.intern() == t.intern() ��Ϊ true�� 

��������ֵ�ַ������ַ�����ֵ�������ʽ��ʹ�� intern �������в������ַ�������ֵ�� Java Language Specification �� ��3.10.5 ���塣 


���أ�
һ���ַ�������������ַ�����ͬ����һ��ȡ�Ծ���Ψһ�ַ����ĳء�

		 * 
		 * */
		
		
		String hello ="hello";
		
		String hel="hel";
		
		String lo="lo";
		//hello�ڳ���
		System.out.println(hello=="hel"+"lo");//�����Ѿ�����
		System.out.println(hello==hel+"lo");//�����ڶ�������hello����
		System.out.println(hello=="hel"+lo);//�����ڶ�������hello����
		System.out.println(hello==hel+lo);//�����ڶ�������hello����
		
		
		
		
		
	}

}
