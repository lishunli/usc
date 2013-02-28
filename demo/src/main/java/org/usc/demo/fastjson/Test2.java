package org.usc.demo.fastjson;

import java.util.Date;

import com.alibaba.fastjson.JSON;

/**
 *
 * @author Shunli
 */
public class Test2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Date now = new Date();
        System.out.println(JSON.toJSONStringWithDateFormat(now, "yyyy-MM-dd"));
    }

}
