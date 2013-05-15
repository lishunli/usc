package org.usc.demo;

/**
 *
 * @author Shunli
 */
public class BuildSqlStatement9 {

    public static void main(String[] args) {
        String sqlTpt = "INSERT INTO `sendbill` VALUES (null, '%s', 'lishunli%s', '', '', '', '1', '', '13700000000', now(), '');";

        for (int i = 1; i <= 120; i++) {
            System.out.println(String.format(sqlTpt, i, i));
        }

    }
}
