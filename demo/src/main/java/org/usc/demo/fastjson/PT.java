package org.usc.demo.fastjson;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.xunlei.youxi.act.frm.vo.result.SuccessJsonResult;

/**
 *
 * @author Shunli
 */
public class PT {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int count = 1000000;

        SuccessJsonResult success = new SuccessJsonResult();

        for (int j = 0; j < 10; j++) {
            long start = System.nanoTime();
            for (int i = 0; i < count; i++) {
                success.toJsonString();
                // System.out.println(success.toJsonString());
            }
            System.out.println("old-escaped-time:" + (System.nanoTime() - start));

            start = System.nanoTime();
            for (int i = 0; i < count; i++) {
                // success.toJsonString2();
                JSON.toJSON(success);
                // System.out.println(JSON.toJSON(success));
            }
            System.out.println("new-escaped-time:" + (System.nanoTime() - start));
        }

        System.out.println(StringUtils.center("我是分割线", 60, "="));

        for (int j = 0; j < 10; j++) {
            long start = System.nanoTime();
            for (int i = 0; i < count; i++) {
                // success.toJsonString2();
                JSON.toJSON(success);
                // System.out.println(success.toJsonString());
            }
            System.out.println("new-escaped-time:" + (System.nanoTime() - start));

            start = System.nanoTime();
            for (int i = 0; i < count; i++) {
                success.toJsonString();
                // System.out.println(JSON.toJSON(success));
            }
            System.out.println("old-escaped-time:" + (System.nanoTime() - start));
        }

    }
}
