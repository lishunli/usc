package org.usc.demo.lottery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 不同概率抽奖
 *
 * 提供两样东西即可，一个是各物品的抽奖概率，一个是物品的详情（序号==物品名称==物品Id），两者都需要安装顺序一一对应
 *
 * @author ShunLi
 */
public class LotteryTest {
	public static void main(String[] args) {
		List<ThreeTuple<String, String, String>> gifts = new ArrayList<ThreeTuple<String, String, String>>();
		// 序号==物品名称==物品Id
		gifts.add(new ThreeTuple<String, String, String>("1", "物品1", "301"));
		gifts.add(new ThreeTuple<String, String, String>("2", "物品2", "302"));
		gifts.add(new ThreeTuple<String, String, String>("3", "物品3", "303"));
		// gifts.add(new ThreeTuple<String, String, String>("4", "物品4", "304"));
		// gifts.add(new ThreeTuple<String, String, String>("5", "物品5", "305"));

		// List<Double> orignalRates = null;// Arrays.asList(0.4d, 0.1d, 0.3d, 0.2d);new ArrayList<Double>();//
		// List<Double> orignalRates = Arrays.asList(0.4d, 0.1d, 0.3d, 0.2d, 0.123d);
		List<Double> orignalRates = Arrays.asList(0.2d, 0.4d, 0.4d);

		for (int i = 0; i < 10; i++) {
			ThreeTuple<String, String, String> tuple = gifts.get(LotteryUtil.lottery(orignalRates));
			System.out.println(tuple);
		}

		// calc
		Map<ThreeTuple<String, String, String>, Integer> count = new HashMap<ThreeTuple<String, String, String>, Integer>();

		for (int i = 0; i < 1000000; i++) {
			int orignalIndex = LotteryUtil.lottery(orignalRates);

			ThreeTuple<String, String, String> tuple = gifts.get(orignalIndex);
			Integer value = count.get(tuple);
			count.put(tuple, value == null ? 1 : value + 1);
		}

		System.out.println(count);

		Set<Entry<ThreeTuple<String, String, String>, Integer>> entrySet = count.entrySet();
		double sum = 0;
		for (Entry<ThreeTuple<String, String, String>, Integer> entry : entrySet) {
			sum += entry.getValue();
		}
		for (Entry<ThreeTuple<String, String, String>, Integer> entry : entrySet) {
			System.out.println(entry.getKey() + ":" + entry.getValue() / sum);
		}
	}
}
