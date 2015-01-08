package org.usc.demo.fastjson;

import java.util.List;

import org.usc.demo.guava.Ccy;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableList;

/**
 *
 * @author Shunli
 */
public class Test3 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Ccy> ccys1 = ImmutableList.of(new Ccy("i1", "a", 1), new Ccy("i2", "b", 2), new Ccy("i3", "c", 3));

        System.out.println(JSON.toJSONString(ccys1));
    }

}
