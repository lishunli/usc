package org.usc.demo.el;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.simpleEL.dialect.tiny.TinyELEvalService;

/**
 *
 * @author Shunli
 */
public class ELDemo2 {
    public static void main(String[] args) {
        TinyELEvalService service = new TinyELEvalService();
        service.setAllowMultiStatement(true);
        service.regsiterVariant(int.class, "a", "b");

        Map<String, Object> ctx = new HashMap<String, Object>();
        ctx.put("a", 3);
        ctx.put("b", 4);

        System.out.println(service.eval(ctx, "if (a > b) { return a - b; } else {return b - a; }"));
    }

}
