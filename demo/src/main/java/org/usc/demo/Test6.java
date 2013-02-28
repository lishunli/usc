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

    public static void main(String[] args) throws IOException, SecurityException, NoSuchMethodException {
        // Map<String, String> map = new HashMap<String, String>();
        // map.put("1", "11");
        // System.out.println(map);
        //
        // Child child = new Child();
        // child.doAction1();
        // Method method1 = Child.class.getMethod("doAction3");
        // System.out.println(method1);
        // Method method2 = Child.class.getDeclaredMethod("doAction2");
        // System.out.println(method2);
        List<String> lines = FileUtils.readLines(new File("D:\\gifts.txt"));
        // int i = 461;
        for (String line : lines) {
            String[] split = line.split("\t");
            // System.out.println(split[0] + "==" + split[1] + "==" + split[2] + "==" + (i--));
            System.out.println(split[0] + "==" + split[1] + "==" + split[2] + "==" + split[3]);
        }

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
        // List<String> readLines = FileUtils.readLines(new File(""));
        // try {
        // // test();
        // } catch (Exception e) {
        // if (e instanceof IllegalArgumentException) {
        // System.out.println("hi");
        // }
        // }

        // StringBuffer sb = new StringBuffer();
        // sb.append("hello world.");
        // sb.insert(0, "test dddddddddd ");
        // System.out.println(sb );
        // Date date = new Date();
        // // date = DateUtils.addMonths(date, 1);
        // date = DateUtils.addDays(date, -1);
        // SimpleDateFormat format = new SimpleDateFormat("yyyy.M.d");
        //
        // System.out.println(format.format(date));

        // System.out.println(System.currentTimeMillis());
        // System.out.println(new Date(1348744412000L));
    }
    // private static void test() {
    // throw new IllegalArgumentException("test");
    // }
}
