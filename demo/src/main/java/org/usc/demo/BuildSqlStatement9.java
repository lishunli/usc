package org.usc.demo;


/**
 *
 * @author Shunli
 */
public class BuildSqlStatement9 {

    public static void main(String[] args) {
//        String sqlTpt = "INSERT INTO `signin_5` VALUES (null, '48320070404832', 'lishunli1', '0', '%s', now(), '192.168.200.110');";
//
//        for (int i = 1; i <= 48; i++) {
//            System.out.println(String.format(sqlTpt, DateUtil.formatDate(DateUtil.addDays(i), "yyyy-MM-dd")));
//        }
        String tpt = "您的cdkey是：%1$s \r\n请领取\r\nhttp://rh.xunlei.com/act/cdkey/";
        System.out.println(String.format(tpt, "1234"));

    }
}
