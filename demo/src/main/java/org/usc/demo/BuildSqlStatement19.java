package org.usc.demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.xunlei.youxi.core.util.FileUtil;

/**
 *
 * @author Shunli
 */
public class BuildSqlStatement19 {
    // seqid | userid | username | serverid | rolename | day | infotype | inputtime
    private static String tpl_1 = "insert into monopolyroleinfo values(null, '%4$s', '%5$s', '%1$s', '%6$s', '2014-12-04', '%7$s', now());";
    private static String tpl_2 = "insert into monopolyroleinfo values(null, '%1$s', '%2$s', '%3$s', '%4$s', '2014-12-04', '%5$s', now());";

    public static void main(String[] args) throws IOException {
        int i = 1;

        List<String> results = new ArrayList<String>();
        for (String line : FileUtil.readLines("D://mon.txt")) {
            // System.out.println(lines);
            String[] split = line.split("\t");

            String type = "LOGIN_";
            if ("活跃礼包".equals(split[1])) {
                type = "GIFT_";
            }

            results.add(String.format(tpl_1, ArrayUtils.addAll(split, type + (i++))));
        }

        for (String line : FileUtil.readLines("D://mon_2.txt")) {
            String[] split = line.split("\\| ");

            String userid = StringUtils.trim(split[2]);
            String username = StringUtils.trim(split[3]);
            String serverid = StringUtils.trim(split[4]);
            String rolename = StringUtils.trim(split[5]);
            String infotype = StringUtils.trim(split[7]);
            String type = "LOGIN_";
            if ("GIFT".equals(infotype)) {
                type = "GIFT_";
            }

            results.add(String.format(tpl_2, userid, username, serverid, rolename, type + (i++)));
        }

        for (String string : results) {
            System.out.println(string);
        }

         org.apache.commons.io.FileUtils.writeLines(new File("D://monopolyroleinfo_patch.sql"), results);
         System.out.println("over");
    }
}
