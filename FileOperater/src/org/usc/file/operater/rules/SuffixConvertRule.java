package org.usc.file.operater.rules;

/**
 * 后缀转换
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-12-11<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
public class SuffixConvertRule implements ConvertRule {

	@Override
	public String reNameByRule(String oldName) {
		return reNameByRule(oldName, "", "");
	}

	@Override
	public String reNameByRule(String oldName, String fix, String newFix) {
		int lastIndex = oldName.lastIndexOf(".");
		String spitBeforeString = oldName.substring(0, lastIndex != -1 ? lastIndex : oldName.length());
		String spitAfterString = lastIndex != -1 ? oldName.substring(lastIndex) : "";
		
		if (fix == null || fix.trim().length() == 0) {
			return spitBeforeString.concat(newFix).concat(spitAfterString);
		}else{
			int lastIndexByFix = spitBeforeString.lastIndexOf(fix);
			
			return lastIndexByFix != -1 ? spitBeforeString.substring(0,lastIndexByFix).concat(newFix).concat(spitAfterString) : oldName;
		}

	}
	public static void main(String[] args) {
		String str1 = "[1]xxx[1]";
		System.out.println(
				str1.substring(6).replaceFirst("[1]".replaceAll("\\[", "\\\\["), "[一]"));
	}

}
