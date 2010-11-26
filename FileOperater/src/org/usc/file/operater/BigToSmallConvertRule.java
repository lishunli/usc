package org.usc.file.operater;

import java.util.HashMap;
import java.util.Map;

public class BigToSmallConvertRule implements ConvertRule {

	@Override
	public String reNameByRule(String oldName) {
		Map<String, Integer> numberMap = new HashMap<String, Integer>();
		numberMap.put("零", 0);
		numberMap.put("一", 1);
		numberMap.put("二", 2);
		numberMap.put("三", 3);
		numberMap.put("四", 4);
		numberMap.put("五", 5);
		numberMap.put("六", 6);
		numberMap.put("七", 7);
		numberMap.put("八", 8);
		numberMap.put("九", 9);
		numberMap.put("十", 10);

		Map<String, Integer> unitMap = new HashMap<String, Integer>();
		unitMap.put("十", 10);
		unitMap.put("百", 100);
		unitMap.put("千", 1000);
		unitMap.put("万", 10000);

		Map<String, Integer> levelMap = new HashMap<String, Integer>();
		levelMap.put("万", 10000);

		Integer sum = 0;

		StringBuffer newName = new StringBuffer();

		int size = oldName.length();
		for (int i = 0; i < size; i++) {

			Boolean flag = false;

			if (numberMap.keySet().contains(oldName.substring(i, i + 1))) {
				Integer factor = 1;

				Integer small = numberMap.get(oldName.substring(i, i + 1));

				Integer big = 1;

				if ((i + 1 < size) && unitMap.keySet().contains(oldName.substring(i + 1, i + 2))) {
					big = unitMap.get(oldName.substring(i + 1, i + 2));

					if ("万".equals(oldName.substring(i + 1, i + 2))) {
						small += sum;
						factor = 0;
					}

					if ((i + 2 < size) && levelMap.keySet().contains(oldName.substring(i + 2, i + 3))) {
						small = small * big + sum;
						big = unitMap.get(oldName.substring(i + 2, i + 3));
						i++;
					}

					i++;
				}

				sum = sum * factor + small * big;

				flag = true;
			}

			if (!flag) {
				if (sum != 0) {
					newName.append(sum.toString());
				}
				newName.append(oldName.substring(i, i + 1));
				sum = 0;
			}
			else {
				if (sum == 0 && "零".equals(oldName.substring(i, i + 1))) {
					newName.append(sum.toString());
				}
			}

		}
		if (sum != 0) {
			newName.append(sum.toString());
		}

		return newName.toString();
	}

}
