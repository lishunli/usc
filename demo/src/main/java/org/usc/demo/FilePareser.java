package org.usc.demo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 *
 * @author Shunli
 */
public class FilePareser {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\user.txt");
        List<String> useres = FileUtils.readLines(file, "utf-8");

        String tmp1 = "INSERT INTO `customers` VALUES ('%s', '%s', '%s', '%s', '', '', '', '', '1', '0', '', '2012-06-03 00:01:00', '', '0000', '', '0000000000', '', '', null);";
        int i = 1;
        for (String user : useres) {
            // System.out.println(user);
            String[] split = user.split(",");
            // System.out.println(split.length);
            String userId = split[2].trim();
            // System.out.println(userId);
            // System.out.println(split[2].trim()+","+split[3].trim()+","+split[4].trim());
            // System.out.println(" select * from customeCrmap where userid = '" + userId + "';");
            System.out.println(String.format(tmp1, i++, userId, split[3].trim(), split[4].trim()));
        }

        file = new File("D:\\cid.txt");
        List<String> cids = FileUtils.readLines(file, "utf-8");

        String tmp2 = "INSERT INTO `customermap` VALUES ('%s', '%s', '%s', '%s');";
        int j = 1;
        for (String user : cids) {
            // System.out.println(user);
            String[] split = user.split(",");
            // System.out.println(split.length);
            // String userId = split[2].trim();
            // System.out.println(userId);
            // System.out.println(split[2].trim()+","+split[3].trim()+","+split[4].trim());
            // System.out.println(" select * from customermap where userid = '" + userId + "';");
            System.out.println(String.format(tmp2, j++, split[2].trim(), split[3].trim(), split[4].trim()));
        }

    }

}
