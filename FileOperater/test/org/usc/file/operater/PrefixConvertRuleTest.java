package org.usc.file.operater;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.usc.file.operater.rules.PrefixConvertRule;

/**
 * 
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-12-11<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
public class PrefixConvertRuleTest {
	private PrefixConvertRule rule = new PrefixConvertRule();
	private String fix = "[XXX]";
	private String newFix = "[李顺利]";

	@Test
	public void reNameByPrefixConvertRuleTest() {
		assertEquals("[李顺利]第十讲.avi", rule.reNameByRule("第十讲.avi", "", newFix));
		assertEquals("[李顺利]XXX.rar", rule.reNameByRule("[XXX]XXX.rar", fix, newFix));
		assertEquals("[XXX]XXX.rar", rule.reNameByRule("[XXX]XXX.rar", "", ""));
		assertEquals("[XXX]XXX.rar", rule.reNameByRule("[XXX]XXX.rar", "[XX]", newFix));

	}

}
