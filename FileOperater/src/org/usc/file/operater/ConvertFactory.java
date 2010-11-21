package org.usc.file.operater;

public class ConvertFactory {

	public static ConvertRule createConvertRule(Rule rule) {

		ConvertRule cr = new SmallToBigConvertRule(); // Default

		if (Rule.SmallToBig == rule) {
			cr = new SmallToBigConvertRule();
		} else if (Rule.BigToSmall == rule) {
			cr = new BigToSmallConvertRule();
		}

		return cr;
	}

}
