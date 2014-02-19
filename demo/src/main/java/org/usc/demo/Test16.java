package org.usc.demo;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Shunli
 */
public class Test16 {
//    private static final String ORDER_ID_PREFIX = "54";

    public static void main(String[] args) {
        // for (int i = 0; i < 10000000; i++) {
        // // String uuid = UUID.randomUUID().toString();
        // //
        // // System.out.println(uuid);
        // // System.out.println(StringUtils.overlay(uuid, ORDER_ID_PREFIX, 0, ORDER_ID_PREFIX.length()));
        // // System.out.println(RandomUtils.nextInt(10));
        // System.out.println(RandomStringUtils.randomNumeric(4));
        // }

        // String list = "1";
        // for (String string : list.split("1")) {
        // System.out.println(string);
        // }

        // System.out.println(StringUtils.substringAfterLast("", "."));

        String gameid = "000076";
        int countByGameId = 3;

        String gameShortId = StringUtils.substring(gameid, gameid.length() - 3);
        String index = StringUtils.leftPad((countByGameId + 1) + "", 3, "0");
        String result = StringUtils.join(gameShortId, index);
        System.out.println(result);
    }
}

// System.out.println(StringUtils.overlay(UUID.randomUUID().toString(), "54", 0, 2));
