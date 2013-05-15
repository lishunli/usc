package org.usc.demo;

import java.util.Arrays;
import java.util.List;

import com.xunlei.game.activity.utils.FileUtils;

/**
 *
 * @author Shunli
 */
public class BuildSqlStatement8 {

    public static void main(String[] args) {
        String sqlTpt = "INSERT INTO `configitem` VALUES (null, '1', '%s', '%s', '%s', '', now(), 'lishunli', '', '', '1000');";

        List<String> readFile = FileUtils.readFile("D:\\servers.txt");
        for (String line : readFile) {
            String[] split = line.split("\t");
            // System.out.println(Arrays.toString(split));
            System.out.println(String.format(sqlTpt, split[5].trim(), split[4].trim(), split[0].trim()));
        }
    }
}
