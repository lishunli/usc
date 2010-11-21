package org.usc.file.operater;

public class BigToSmallConvertRule implements ConvertRule {

	@Override
	public String reNameByRule(String oldName) {
		String newName = oldName;

		newName = newName.replaceAll("十一", "1").replaceAll("十二", "2").replaceAll("十三", "3").replaceAll("十四", "4").replaceAll("十五", "5").replaceAll("十六", "6")
				.replaceAll("十七", "7").replaceAll("十八", "8").replaceAll("十九", "9").replaceAll("一", "1").replaceAll("二", "2").replaceAll("三", "3")
				.replaceAll("四", "4").replaceAll("五", "5").replaceAll("六", "6").replaceAll("七", "7").replaceAll("八", "8").replaceAll("九", "9")
				.replaceAll("十", "0");

		return newName;
		
	}

}
