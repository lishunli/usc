package org.usc.demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Shunli
 */
public class BuildSqlStatement15 {
    private static String giftInfoTplPrefix = "INSERT INTO sy_giftinfo VALUES";
    private static String giftInfoTplSuffix = "(null,'%1$s','%1$s','%1$s',1,0,0,0,'DATA_PATCH','lishunli',now(),'','','')";

    private static String keyInfoTplPrefix = "INSERT INTO sy_keyinfo_%1$s VALUES";
    private static String keyInfoTplSuffix = "(null,'%1$s','%1$s','%2$s',0,'','','')";

    public static void main(String[] args) throws IOException {
        List<String> results = new ArrayList<String>();

        for (int i = 0; i < 100; i++) {// 100 tables
            StringBuffer keys = new StringBuffer(String.format(keyInfoTplPrefix, i));

            StringBuffer gifts = new StringBuffer(giftInfoTplPrefix);
            for (int j = 0; j < 10; j++) {
                int index = i + j * 100;
                String giftId = StringUtils.leftPad(index + "", 4, "0");

                gifts.append(String.format(giftInfoTplSuffix, giftId));
                gifts.append(",");

                for (int k = 0; k < 10000; k++) {
                    keys.append(String.format(keyInfoTplSuffix, giftId, RandomStringUtils.randomAlphanumeric(10)));
                    keys.append(",");

                }
            }

            gifts.deleteCharAt(gifts.length() - 1).append(";");
            keys.deleteCharAt(keys.length() - 1).append(";");
            results.add(gifts.toString());
            results.add(keys.toString());
            // System.out.println(gifts);
            // System.out.println(keys);
        }

        org.apache.commons.io.FileUtils.writeLines(new File("D://keyinfos.sql"), results);
        System.out.println("over");
    }
}
