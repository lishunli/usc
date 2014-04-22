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
public class BuildSqlStatement14 {
    private static String tpl = "update configitem set itemvalue = '%s' where itemkey = '%s' and itemvalue = '%s' and groupid = '1';";

    public static void main(String[] args) throws IOException {
        List<String> lines = FileUtil.readLines("D://new  7.txt");
        List<String> results = new ArrayList<String>();
        for (String cdkey : lines) {
            // System.out.println(lines);
            String[] split = cdkey.split("\t");
            // System.out.println(Arrays.toString(split));
            results.add(String.format(tpl, split[5], split[0], split[1]));
        }

        // lines = FileUtils.readLines("D://duplicat-send.txt");
        // for (String cdkey : lines) {
        // results.add(String.format(cdkey_tpl, -2, cdkey));
        // }
        //
        org.apache.commons.io.FileUtils.writeLines(new File("D://new 8.sql"), results);
        System.out.println("over");
    }
}
