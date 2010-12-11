package org.usc.file.operater.rules;

/**
 * 前缀转换
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-12-11<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
public class PrefixConvertRule implements ConvertRule {

	@Override
	public String reNameByRule(String oldName) {
		return reNameByRule(oldName, "", "");
	}

	@Override
	public String reNameByRule(String oldName, String fix, String newFix) {

		if (fix == null || fix.trim().length() == 0) {
			return newFix.concat(oldName);
		}
		else {
			int indexByFix = oldName.indexOf(fix);
			
			return indexByFix != -1 ? newFix.concat(oldName.substring(fix.length())) : oldName;
		}
	}
}
