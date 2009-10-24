package org.usc.javautils.string;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.usc.javautils.string.StringUtil;

public class StringUtilTest
{
	@Test
	public void testFormatFraction()
	{
		double num = 0.693431014112044;
		int minFractionDigits = 1;
		int maxFractionDigits = 3;
		String expect = "0.693";
		assertTrue("formatFraction(" + num + "," + minFractionDigits+
						"," + maxFractionDigits+
						") is "
				+ StringUtil.formatFraction(num, minFractionDigits,
						maxFractionDigits) + " not " + expect, expect
				.equals(StringUtil.formatFraction(num, minFractionDigits,
						maxFractionDigits)));
	}
}
