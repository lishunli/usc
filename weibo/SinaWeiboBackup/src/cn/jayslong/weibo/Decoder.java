package cn.jayslong.weibo;

public class Decoder
{

	public static String decode(String string)
	{
		return string.replaceAll("%3A", ":").replaceAll("%2F", "/").replaceAll("%3D", "=").replaceAll("%26", "&");
	}

}
