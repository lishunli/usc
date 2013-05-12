package org.usc.demo;

import com.xunlei.youxi.act.frm.vo.TwoTuple;

public class Test {
    public static void main(String[] args) {
        TwoTuple<String, String> paramAndResult = new TwoTuple<String, String>();
        paramAndResult.setFirst("8");

        test(paramAndResult);

        System.out.println(paramAndResult);
    }

    private static void test(TwoTuple<String, String> paramAndResult) {
        paramAndResult.setSecond("1370000000");
    }
}
