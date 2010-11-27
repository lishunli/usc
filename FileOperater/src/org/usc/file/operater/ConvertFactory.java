package org.usc.file.operater;

public class ConvertFactory {

	public static ConvertRule createConvertRule(Rule rule) {

		ConvertRule cr = new SmallToBigConvertRule(); // Default

		if (Rule.SmallToBig == rule) {
			cr = new SmallToBigConvertRule();
		} else if (Rule.BigToSmall == rule) {
//			cr = new BigToSmallConvertRule();
			cr = new SimpleBigToSmallConvertRule(); // simple 支持百一下的文件，快速一点
		}

		return cr;
	}

}
