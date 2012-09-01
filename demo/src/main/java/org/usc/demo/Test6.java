package org.usc.demo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 *
 * @author Shunli
 */
public class Test6 {

    public static void main(String[] args) throws IOException {
        // File file = new File("E:\\Source\\XLAct\\V2\\xlgame_dachongfeng\\dcfpaygift\\etc\\doc\\paydrawgift.txt");
        // List<String> lines = FileUtils.readLines(file);
        // int i = 461;
        // for (String line : lines) {
        // String[] split = line.split("==");
        // // System.out.println(split[0] + "==" + split[1] + "==" + split[2] + "==" + (i--));
        // System.out.println(split[1] + "==" + split[3]);
        // }

        // String fileName1 = "/usr/local/gameact/xlgame_dachongfeng/logs/xxx.log";
        // String fileName2 = "/usr/local2/gameact/xlgame_dachongfeng/logs/xxx.log";
        // // System.out.println(FilenameUtils.getFullPathNoEndSeparatorsw(fileName1));
        //
        // if(fileName1.startsWith("/usr/local/gameact/")){
        // fileName1.substring("/usr/local/gameact/".length());
        // System.out.println(fileName1);
        // }

        // Date date = new Date(1345020143000L);
        // System.out.println(date);

        // for (int i = 0; i < 200; i++) {
        // String randomNumeric = RandomStringUtils.randomAlphanumeric(13);
        // System.out.println(("XIUMO61" + randomNumeric).toUpperCase());
        // }
        //
        // List<String> usres = new ArrayList<String>();// Arrays.asList("1","2","3","4","5");
        // Random random = new Random();

        // for (int i = 0; i < 200; i++) {
        // System.out.println(usres.get(random.nextInt(usres.size())));
        // System.out.println(RandomStringUtils.randomNumeric(2) + " " + RandomStringUtils.randomNumeric(4) + " " + RandomStringUtils.randomNumeric(4) + " " +
        // RandomStringUtils.randomNumeric(4) + " " + RandomStringUtils.randomNumeric(4));
        // }
        List<String> readLines = FileUtils.readLines(new File(""));
        try {
//            test();
        } catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                System.out.println("hi");
            }
        }
    }

    private static void test() {
        throw new IllegalArgumentException("test");
    }
}
