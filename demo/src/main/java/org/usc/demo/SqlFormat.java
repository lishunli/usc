package org.usc.demo;

import java.util.Scanner;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.util.JdbcUtils;

/**
 *
 * @author Shunli
 */
public class SqlFormat {
    public static void main(String[] args) {
        System.out.println("please input sql:");

        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        String sql = in.nextLine();

        String formatedSQL = SQLUtils.format(sql, JdbcUtils.MYSQL);

        System.out.println("\r\nafter format:\r\n\r\n" + formatedSQL);
    }
}
