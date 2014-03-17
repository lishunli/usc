package org.usc.demo.el;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.alibaba.simpleEL.dialect.tiny.TinyELEvalService;
import com.google.common.collect.ImmutableMap;

/**
 *
 * @author Shunli
 */
public class ELDemo5 {
    public static void main(String[] args) throws SecurityException, NoSuchMethodException {
        ELDemoObj task = new ELDemoObj("test", "10", "", "return toInt(task.getRemark(), 1) + 1000;");
        System.out.println(getGift(task));
        System.out.println("end");

    }

    private static String getGift(ELDemoObj task) {
        String giftId = task.getGiftId();
        if (StringUtils.isNotEmpty(giftId)) {
            return giftId;
        }

        return getGiftFromExp(task);
    }

    private static String getGiftFromExp(ELDemoObj task) {
        try {
            TinyELEvalService service = new TinyELEvalService();
            service.setAllowMultiStatement(true);
            service.regsiterVariant(ELDemoObj.class, "task");
            service.registerFunction("toInt", NumberUtils.class.getMethod("toInt", String.class, int.class));

            Map<String, Object> ctx = ImmutableMap.<String, Object> of("task", task);
            return service.eval(ctx, task.getGiftIdExp()) + "";
        } catch (Exception e) {
        }

        return "";
    }
}
