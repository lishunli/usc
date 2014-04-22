package org.usc.demo;

import java.io.IOException;
import java.util.List;

import com.xunlei.youxi.core.util.FileUtil;

/**
 * 
 * @author Shunli
 */
public class BuildSqlStatement7 {

    public static void main(String[] args) throws IOException {
        build1();
        build2();
    }

    private static void build1() throws IOException {
        String sqlTpt = "INSERT INTO `signin_4` VALUES (null, '%s', '%s', '0', '2013-02-28', '2013-02-28 23:59:59', '119.145.40.161');";

        List<String> readFile = FileUtil.readLines("D:\\nologinuser\\nologinuser_28.txt");
        for (String line : readFile) {
            String[] split = line.split(",");
            // System.out.println(Arrays.toString(split));
            System.out.println(String.format(sqlTpt, split[0], split[1]));
        }
    }

    private static void build2() throws IOException {
        String sqlTpt = "INSERT INTO `signin_4` VALUES (null, '%s', '%s', '0', '2013-02-29', '2013-02-29 23:59:59', '119.145.40.161');";

        List<String> readFile = FileUtil.readLines("D:\\nologinuser\\nologinuser_29.txt");
        for (String line : readFile) {
            String[] split = line.split(",");
            // System.out.println(Arrays.toString(split));
            System.out.println(String.format(sqlTpt, split[0], split[1]));
        }
    }

}
