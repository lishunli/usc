package org.usc.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

public class BetCake2 {
    private static final Random rand = new Random();
    private static final int dicesCount = 6;
    private static final int dicesMaxNum = 6;

    public static void main(String[] args) {
        for (int j = 0; j < 100000; j++) {
            String[] cakes = new String[dicesCount];
            for (int i = 0; i < dicesCount; i++) {
                cakes[i] = rand.nextInt(dicesMaxNum) + 1 + "";
            }

            System.out.println(lottery(cakes));
        }

    }
    private static String lottery(String[] cakes) {
        String result = StringUtils.join(cakes);

        Map<Integer, Integer> counts = new HashMap<Integer, Integer>(dicesCount);
        for (int i = 0; i < dicesCount; i++) {
            int num = i + 1;
            counts.put(num, StringUtils.countMatches(result, num + ""));
        }

        System.out.print(result + ":" /* + count */);

        if (counts.get(4) == 4) {
            if (counts.get(1) == 2) {
                return "插金花 六粒骰子有四粒为4，两粒为1";
            }

            return "四红  六粒骰子有四粒为4，另外两粒除了4和同时为1外任意数字";
        }

        if (counts.get(4) == 5) {
            return "五红  六粒骰子有五粒4";
        }

        if (counts.get(4) == 6) {
            return "红六勃 六粒骰子全部为4";
        }

        if (counts.get(1) == 6) {
            return "遍地锦 六粒骰子全部为1";
        }

        for (int count : counts.values()) {
            if (count == 4) {
                return "四进  六粒骰子有四粒点数相同（除4外)";
            }

            if (count == 5) {
                return "五子登科    六粒骰子有五粒相同（除4外）";
            }

            if (count == 6) {
                return "黑六勃 六粒骰子全部为相同点，除1和4";
            }
        }

//        if ("123456".equals(result)) {
//            return "对堂  六粒骰子为123456";
//        }

        if (counts.get(4) == 1) {
            return "一秀  六粒骰子中有一粒为4点";
        }

        if (counts.get(4) == 2) {
            return "二举  六粒骰子中有两粒为4点";
        }

        if (counts.get(4) == 3) {
            return "三红  六粒骰子有三粒的点数为4点";
        }

        return "没有中奖";
    }
}
