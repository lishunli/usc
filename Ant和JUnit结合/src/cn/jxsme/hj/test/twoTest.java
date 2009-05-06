package cn.jxsme.hj.test;
/*
 * autho huangjin green eat  
 *Dec 30, 2008
 */
public class twoTest {

	/**
	 * 加法
	 * @param i 
	 * @param b
	 * @return 返回两个数的加值
	 */
	public int sum (int i,int b){
		return i+b;
	}
	
	/**
	 * 减法
	 * @param i
	 * @param b
	 * @return  返回两个数的减法值
	 */
	public int minu(int i, int b){
		return i-b;
	}
	
	/**
	 * 乘法
	 * @param i
	 * @param b
	 * @return 返回两个数的乘法值
	 */
	public int ride(int i,int b){
		return i*b;
	}
	
	/**
	 * 除法
	 * @param i
	 * @param b
	 * @return 返回两个数的除法值,,如果b为o的话返回0
	 */
	public int ex(int i ,int b){
		if(b==0)return 0;
		return i/b;
	}
	
}
