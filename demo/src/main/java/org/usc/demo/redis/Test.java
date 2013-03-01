package org.usc.demo.redis;

import java.util.Date;

import com.alibaba.fastjson.JSON;

/**
 *
 * @author Shunli
 */
public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(null));

        System.out.println(JSON.parseObject("1362118845899", Date.class));
    }

}
