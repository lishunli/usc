package org.usc.demo;

import java.io.IOException;
import java.util.List;

import com.xunlei.youxi.core.util.FileUtil;

/**
 * 
 * @author Shunli
 */
public class BuildSqlStatement6 {

    public static void main(String[] args) throws IOException {
        build1();
        build2();
        build3();
    }

    private static void build1() throws IOException {
        String sqlTpt = "INSERT INTO `signin_4` VALUES (null, '%s', '%s', '0', '2013-02-25', '2013-02-25 23:59:59', '119.145.40.161');";

        List<String> readFile = FileUtil.readLines("D:\\nologinuser\\nologinuser_25.txt");
        for (String line : readFile) {
            String[] split = line.split(",");
            // System.out.println(Arrays.toString(split));
            System.out.println(String.format(sqlTpt, split[0], split[1]));
        }
    }

    private static void build2() throws IOException {
        String sqlTpt = "INSERT INTO `signin_4` VALUES (null, '%s', '%s', '0', '2013-02-26', '2013-02-26 23:59:59', '119.145.40.161');";

        List<String> readFile = FileUtil.readLines("D:\\nologinuser\\nologinuser_26.txt");
        for (String line : readFile) {
            String[] split = line.split(",");
            // System.out.println(Arrays.toString(split));
            System.out.println(String.format(sqlTpt, split[0], split[1]));
        }
    }

    private static void build3() throws IOException {
        String sqlTpt = "INSERT INTO `signin_4` VALUES (null, '%s', '%s', '0', '2013-02-27', '2013-02-27 23:59:59', '119.145.40.161');";

        List<String> readFile = FileUtil.readLines("D:\\nologinuser\\nologinuser_27.txt");
        for (String line : readFile) {
            String[] split = line.split(",");
            // System.out.println(Arrays.toString(split));
            System.out.println(String.format(sqlTpt, split[0], split[1]));
        }
    }

}
