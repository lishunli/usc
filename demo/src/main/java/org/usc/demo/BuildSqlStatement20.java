package org.usc.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Splitter;
import com.xunlei.youxi.core.util.FileUtil;

/**
 *
 * @author Shunli
 */
public class BuildSqlStatement20 {
    private static final Splitter splitter = Splitter.on("\t");
    private static final String tpl = "insert into groupbuyingprop values(null, '%1$s', '%2$s', '%3$s', %4$s, '%5$s', %6$s, 0, 1, 1000, 'lishunli', now(), '', '');";

    public static void main(String[] args) throws IOException {
        List<String> results = new ArrayList<String>();
        for (String line : FileUtil.readLines("D://props.txt")) {
            results.add(String.format(tpl, splitter.splitToList(line).toArray()));
        }

        for (String string : results) {
            System.out.println(string);
        }

        // org.apache.commons.io.FileUtils.writeLines(new File("D://monopolyroleinfo_patch.sql"), results);
        // System.out.println("over");
    }
}
