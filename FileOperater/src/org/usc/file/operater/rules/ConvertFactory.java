package org.usc.file.operater.rules;

/**
 * 转换工厂
 *
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-12-11<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
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
