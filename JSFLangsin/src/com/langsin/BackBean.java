package com.langsin;

public class BackBean {
	private double firstNumber=0.0;
	private double secondNumber=0.0;
	private double result;
	
	private AddBean addbean=new AddBean();
	public double getFirstNumber() {
		return firstNumber;
	}
	public void setFirstNumber(double firstNumber) {
		this.firstNumber = firstNumber;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	public double getSecondNumber() {
		return secondNumber;
	}
	public void setSecondNumber(double secondNumber) {
		this.secondNumber = secondNumber;
	}
	public String add()
	{
		result=addbean.add(firstNumber, secondNumber);
		return "success";
	}

}
