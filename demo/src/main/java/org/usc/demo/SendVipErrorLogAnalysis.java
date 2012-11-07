package org.usc.demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 *
 * @author Shunli
 */
public class SendVipErrorLogAnalysis {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Shunli\\Downloads\\xmlevelingsendvip_Error.log");
        List<String> lines = FileUtils.readLines(file);

        List<String> userIdList = new ArrayList<String>();
        for (String line : lines) {
            String userId = line.split(",")[0];
            if (!userIdList.contains(userId)) {
                userIdList.add(userId);
            }
            // System.out.println(userid);
        }

        Collections.sort(userIdList);
        // for (String userId : userIdList) {
        // System.out.println(userId);
        // }

        System.out.println("--------------------");

        String fileNames = " xmlevelingsendvip.log2012-10-02 xmlevelingsendvip.log2012-10-03 xmlevelingsendvip.log2012-10-04 ";
        boolean isFrist = true;
        StringBuffer sb = new StringBuffer("egrep -E '(");
        for (String userId : userIdList) {
            if (!isFrist) {
                sb.append("|");
            } else {
                isFrist = false;
            }

            sb.append(userId);
        }
        sb.append(")' " + fileNames + " -a | egrep sendThunderVip-success -a");
        System.out.println(sb);
        System.out.println("--------------------");

        file = new File("D:\\log_result.txt");
        lines = FileUtils.readLines(file);

        List<String> successUserIdList = new ArrayList<String>();
        for (String line : lines) {
            String userId = line.split(",")[0];
            successUserIdList.add(userId);
            userIdList.remove(userId);
        }

        System.out.println(userIdList);
        System.out.println("--------------------");
        for (String userId : userIdList) {
            System.out.println(userId);
        }
        System.out.println("--------------------");

        isFrist = true;
        sb = new StringBuffer("egrep -E '(");
        for (String userId : userIdList) {
            if (!isFrist) {
                sb.append("|");
            } else {
                isFrist = false;
            }

            sb.append(userId);
        }
        sb.append(")' " + fileNames + " -a | egrep sendThunderVip-success -a");
        System.out.println(sb);
        System.out.println("--------------------");

        // System.out.println(successUserIdList);
    }
}
