package org.usc.demo;

import java.io.IOException;
import java.util.List;

import com.xunlei.youxi.core.util.FileUtil;

/**
 *
 * @author Shunli
 */
public class BuildSqlStatement10 {

    public static void main(String[] args) throws IOException {
        // String sqlTpt = "select * from answerdetail_198 where userid in '%s';";

        StringBuffer sb = new StringBuffer("select * from answerdetail_198 where userid in (");
        List<String> lines = FileUtil.readLines("D:\\uid.txt");
        for (String string : lines) {
            sb.append("'").append(string).append("', ");
            // System.out.println(String.format(sqlTpt, string));
        }
        sb.append(");");

        System.out.println(sb.toString());
    }
}
