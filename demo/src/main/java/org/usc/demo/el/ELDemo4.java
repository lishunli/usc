package org.usc.demo.el;

import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;

import com.alibaba.simpleEL.dialect.tiny.TinyELEvalService;
import com.google.common.collect.ImmutableMap;

/**
 *
 * @author Shunli
 */
public class ELDemo4 {
    public static void main(String[] args) throws SecurityException, NoSuchMethodException {
        TinyELEvalService service = new TinyELEvalService();
        service.setAllowMultiStatement(true);
        service.regsiterVariant(ELDemoObj.class, "task");
        service.registerFunction("toInt", NumberUtils.class.getMethod("toInt", String.class, int.class));

        for (int i = 0; i < 10; i++) {
            ELDemoObj task = new ELDemoObj(i + "", i + 1 + "");
            System.out.println(getResult(service, ImmutableMap.<String, Object> of("task", task)));
        }

    }

    private static String getResult(TinyELEvalService service, Map<String, Object> ctx) {
        try {
            return service.eval(ctx, "return toInt(task.getRemark(), 1) + 1000;") + "";
        } catch (Exception e) {
            return "";
        }
    }

}
