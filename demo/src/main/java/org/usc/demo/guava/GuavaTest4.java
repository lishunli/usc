package org.usc.demo.guava;

import java.nio.charset.Charset;

import org.apache.commons.codec.digest.DigestUtils;

import com.google.common.collect.HashBasedTable;
import com.google.common.hash.Hashing;

/**
 *
 * @author Shunli
 */
public class GuavaTest4 {

    public static void main(String[] args) {
        HashBasedTable<String, String, String> table = HashBasedTable.create();
        table.put("104001", "001", "god001");
        table.put("104001", "002", "god002");
        table.put("104001", "003", "god003");
        table.put("106001", "001", "test001");
        table.put("106001", "002", "test002");
        table.put("106001", "003", "test003");

        System.out.println(table.get("104001", "001"));

        // 太挫了，小心guava的md5，像这样的是有问题的：Hashing.md5().hashString("lishunli")，推荐使用 Hashing.md5().hashBytes("lishunli".getBytes())
        System.out.println(DigestUtils.md5Hex("lishunli"));
        System.out.println(Hashing.md5().hashBytes("lishunli".getBytes()));
        System.out.println(Hashing.md5().hashString("lishunli", Charset.forName("UTF-8")));
        System.out.println(Hashing.md5().hashString("lishunli", Charset.forName("GBK")));
        System.out.println(Hashing.md5().hashString("lishunli", Charset.forName("ISO-8859-1")));
        System.out.println(Hashing.md5().hashUnencodedChars("lishunli"));

        System.out.println("==========");

        System.out.println(DigestUtils.md5Hex("中文"));
        System.out.println(Hashing.md5().hashBytes("中文".getBytes()));
        System.out.println(Hashing.md5().hashString("中文", Charset.forName("UTF-8")));
        System.out.println(Hashing.md5().hashString("中文", Charset.forName("GBK")));
        System.out.println(Hashing.md5().hashString("中文", Charset.forName("ISO-8859-1")));
        System.out.println(Hashing.md5().hashUnencodedChars("中文"));

    }
}
