package org.usc.file.operater.rules;

/**
 * 字符串转换规则
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-12-11<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
public class ReplaceConvertRule implements ConvertRule {

	@Override
	public String reNameByRule(String oldName) {
		return reNameByRule(oldName, "", "");
	}

	@Override
	public String reNameByRule(String oldName, String fix, String newFix) {
		return oldName.replaceAll(fix.replaceAll("\\[", "\\\\["), newFix);
	}

	@Override
	public String reNameByRule(String oldName, String fix, String newFix, Boolean isFolder) {
		if (isFolder) {
			int index = oldName.lastIndexOf("\\");
			return oldName.substring(0, index + 1).concat(reNameByRule(oldName.substring(index + 1), fix, newFix));
		} else {
			return reNameByRule(oldName, fix, newFix);
		}
	}

}