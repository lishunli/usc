package org.usc.demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author Shunli
 */
public class RandomIDGenerator {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\rh.txt");
        List<String> lines = new ArrayList<String>();

        for (int i = 0; i < 100; i++) {
            String cdkey = "RHXJ" + RandomStringUtils.randomAlphanumeric(13).toUpperCase();
            lines.add(cdkey);
            System.out.println(cdkey);
        }

        FileUtils.writeLines(file, lines);
    }

}
