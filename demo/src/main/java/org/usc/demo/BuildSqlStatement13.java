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
public class BuildSqlStatement13 {
    private static String cdkey_tpl = "update mediapagecdkey set status = %d where cdkey = '%s';";

    public static void main(String[] args) throws IOException {
        List<String> lines = FileUtil.readLines("D://key-had-actived.txt");
        List<String> results = new ArrayList<String>();
        for (String cdkey : lines) {
            results.add(String.format(cdkey_tpl, -1, cdkey));
        }

        lines = FileUtil.readLines("D://duplicat-send.txt");
        for (String cdkey : lines) {
            results.add(String.format(cdkey_tpl, -2, cdkey));
        }

        org.apache.commons.io.FileUtils.writeLines(new File("D://cdkeys_tuning.sql"), results);
        System.out.println("over");
    }
}
