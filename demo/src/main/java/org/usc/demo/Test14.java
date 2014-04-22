package org.usc.demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.xunlei.youxi.core.util.FileUtil;

/**
 * 
 * @author Shunli
 */
public class Test14 {
    public static void main(String[] args) throws IOException {
        List<String> keys = FileUtil.readLines("D://fab//keyinfo.txt");

        List<String> notIncludes = new ArrayList<String>();
        for (String reservation : FileUtil.readLines("D://fab//rh_12.txt")) {
            String[] content = reservation.split("\t");
            String userId = content[1];
            // System.out.println(userId);
            if (keys.contains(userId)) {
                continue;
            }
            String oldName = StringUtils.defaultIfEmpty(content[2], content[3]);
            notIncludes.add(userId + "\t" + oldName);
        }

        for (String reservation : FileUtil.readLines("D://fab//youxireservation.txt")) {
            String[] content = reservation.split(" ");
            String userId = content[0];
            // System.out.println(userId);
            if (keys.contains(userId)) {
                continue;
            }

            notIncludes.add(userId + "\t" + content[1]);
        }

        org.apache.commons.io.FileUtils.writeLines(new File("D://fab//cdkeys.txt"), notIncludes);
        System.out.println("over");
    }
}
