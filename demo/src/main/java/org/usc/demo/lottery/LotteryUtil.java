package org.usc.demo.lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Shunli
 */
public class LotteryUtil {
	private static final Random random = new Random();

	public static int lottery(List<Double> orignalRates) {
		if (orignalRates == null || orignalRates.isEmpty()) {
			return -1;
		}

		int size = orignalRates.size();

		List<Double> sortOrignalRates = new ArrayList<Double>(size);
		sortOrignalRates.addAll(orignalRates);
		Collections.sort(sortOrignalRates);

		List<Double> rates = new ArrayList<Double>(size);
		Double sumRate = 0d;
		for (Double rate : sortOrignalRates) {
			sumRate += rate;
		}

		Double tempSumRate = 0d;
		for (Double rate : sortOrignalRates) {
			tempSumRate += rate;
			rates.add(tempSumRate / sumRate);
		}

		double result = rates.get(0);
		double nextDouble = random.nextDouble();

		for (double rate : rates) {
			if (nextDouble >= rate) {
				continue;
			}
			result = rate;
			break;
		}

		int index = rates.indexOf(result);
		int orignalIndex = orignalRates.indexOf(sortOrignalRates.get(index));

		return orignalIndex;
	}
}
