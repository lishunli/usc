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
public class BuildSqlStatement12 {
    // cdkey
    // media cdkey
    private static String cdkey_tpl = "insert into mediapagecdkey values(null, '%s','10130', '1002','%s',1,now(),'','%s');";
    private static String keyinfo_tpl = "insert into keyinfo_2n values(null, '10130', '1002','%s','2013-06-10 00:00:00','2014-06-10 00:00:00','%s','%s','','','','','',now(),'119.145.40.161','','','','','',1,'','','','','','','SYSTEM',now(),'','',2,1,'','','');";

    public static void main(String[] args) throws IOException {
        // System.out.println(CdkeyGenerator.genCdkey(20, "", "2n"));

        List<String> lines = FileUtil.readLines("D://fab//cdkeys.txt");
        List<String> results = new ArrayList<String>();
        for (String line : lines) {
            String[] content = line.split("\\t");
            String cdkey = CdkeyGenerator.genCdkey(20, "", "2n");
            String userId = content[0];
//            String oldName = StringUtils.defaultIfEmpty(content[2], content[3]);
            String oldName = content[1];

            results.add(String.format(keyinfo_tpl, cdkey, userId, oldName));
            results.add(String.format(cdkey_tpl, cdkey, userId, oldName));
        }

        org.apache.commons.io.FileUtils.writeLines(new File("D://fab//fab.txt"), results);
        System.out.println("over");
    }
}
