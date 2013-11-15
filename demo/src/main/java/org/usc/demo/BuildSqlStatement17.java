package org.usc.demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shunli
 */
public class BuildSqlStatement17 {
    private static String tpl1 = "ALTER TABLE `sy_keyinfo_%s` ADD COLUMN `getmobileid`  varchar(48) NOT NULL DEFAULT '' AFTER `getphone`;";
    private static String tpl2 = "ALTER TABLE `sy_keyinfo_%s` ADD INDEX `idx_gift_mobile_id` (`giftid`, `getmobileid`);";
    private static String tpl3 = "ALTER TABLE `sy_keyinfo_%s` DROP COLUMN `appid`;";

    public static void main(String[] args) throws IOException {

        List<String> results = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            results.add(String.format(tpl1, i));
            results.add(String.format(tpl2, i));
            results.add(String.format(tpl3, i));
        }

        System.out.println(results);

        org.apache.commons.io.FileUtils.writeLines(new File("D://mobile_patch.sql"), results);
        System.out.println("over");
    }
}
