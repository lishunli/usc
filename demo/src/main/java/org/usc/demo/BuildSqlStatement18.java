package org.usc.demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.xunlei.youxi.core.util.FileUtil;

/**
 *
 * @author Shunli
 */
public class BuildSqlStatement18 {
    private static String tpl = "insert into task_000087_1 values (null, '%2$s', '%3$s', '%1$s', '2491', '%4$s', '%4$s', 0, '2014-10-30', now(), '', '');";

    public static void main(String[] args) throws IOException {
        List<String> lines = FileUtil.readLines("D://duplicate_50_step_1.txt");
        List<String> results = new ArrayList<String>();
        for (String cdkey : lines) {
            // System.out.println(lines);
            String[] split = cdkey.split("\t");
            results.add(String.format(tpl, split));
        }

        // lines = FileUtils.readLines("D://duplicat-send.txt");
        // for (String cdkey : lines) {
        // results.add(String.format(cdkey_tpl, -2, cdkey));
        // }

        for (String string : results) {
            System.out.println(string);
        }
        //
        // org.apache.commons.io.FileUtils.writeLines(new File("D://new 8.sql"), results);
        // System.out.println("over");
    }
}
