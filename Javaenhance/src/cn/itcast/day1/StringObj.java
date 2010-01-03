package cn.itcast.day1;

public class StringObj
{
	public String strX;
	public String strY;
	public String strZ;
	public StringObj(String strX, String strY, String strZ)
	{
		this.strX = strX;
		this.strY = strY;
		this.strZ = strZ;
	}
	@Override
	public String toString()
	{
		return "StringObj [strX=" + strX + ", strY=" + strY + ", strZ=" + strZ + "]";
	}
	
}
