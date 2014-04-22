package org.usc.demo;

import java.io.IOException;
import java.util.List;

import com.xunlei.youxi.core.util.FileUtil;

/**
 *
 * @author Shunli
 */
public class BuildSqlStatement4 {

    public static void main(String[] args) throws IOException {
//        String sqlTpt = "INSERT INTO `thundercurrencyoutdetail` VALUES (null, '%s', '%s', '%s', '%s', '%f', '2012-12-19 12:20:00', '303001', '1', '1', '1', '1', '1', '%d', '1', '1');";
//
//        List<String> readFile = FileUtils.readFile("D:\\users.txt");
//
//        for (int i = 0; i < 50; i++) {
//            String userId = readFile.get(i);
//            System.out.println(String.format(sqlTpt, userId, userId, userId, userId, 125.00d, i + 100));
//
//        }
        String sqlTpt = "update usersendmailfail set resendstatus = '2' where orderid = '%s' and eventid = '10099';";

        List<String> readFile = FileUtil.readLines("D:\\orderid.txt");
        for (String userId : readFile) {
            System.out.println(String.format(sqlTpt, userId));

        }
    }
}
