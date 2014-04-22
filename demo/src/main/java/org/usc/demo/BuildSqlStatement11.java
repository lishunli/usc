package org.usc.demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import com.xunlei.youxi.core.util.FileUtil;

/**
 *
 * @author Shunli
 */
public class BuildSqlStatement11 {

    public static void main(String[] args) throws IOException {
        String sqlTpt = "INSERT INTO `keyinfo_56` VALUES (null, '56', '674', '%s', '2013-06-01 00:00:00', '2013-07-10 23:59:59', '', 'lishunli', now(), '', '%s', '%s', now(), '119.145.40.161', '2', '', '', '', '', '', '101001', 'lishunli', now(), '', '', '671', '', '', '');";

        List<String> lines = FileUtil.readLines("D://按此添加白名单.txt");
        List<String> results = new ArrayList<String>();
        for (String line : lines) {
            String[] content = line.split("\\t");
            String cdkey = "RH" + RandomStringUtils.randomAlphanumeric(15).toUpperCase();
            String userId = content[1];
            String oldName = content[0];

            results.add(String.format(sqlTpt, cdkey, userId, oldName));

        }

        org.apache.commons.io.FileUtils.writeLines(new File("D://accounts.txt"), results);
        System.out.println("over");
    }
}
