package org.usc.demo;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

import com.xunlei.youxi.core.util.FileUtil;

/**
 *
 * @author Shunli
 */
public class ItemSearch {
    // private static List<String> plateList = Arrays.asList("胸铠", "战盔", "长裤", "战靴", "扣带", "手筒");
    // private static String plates = "胸铠|战盔|长裤|战靴|扣带|手筒";

    public static void main(String[] args) throws IOException {
        for (String line : FileUtil.readLines("D://items.txt")) {
            String[] content = line.split("\t");

            String giftId = content[0];
            String giftName = content[1];

            // Pattern pattern = Pattern.compile("最高级彩虹玛瑙[" + plates + "]+");
            // if (pattern.matcher(giftName).matches()) {
            // System.out.println("AddItem(" + giftId + ")" + "\t" + Arrays.toString(content));
            // }

            Pattern pattern = Pattern.compile(".*角色.*");
            if (pattern.matcher(giftName).matches()) {
                System.out.println("AddItem(" + giftId + ")" + "\t" + Arrays.toString(content));
            }

        }
    }
}
