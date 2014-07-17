package org.usc.demo.el;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;

import com.alibaba.simpleEL.dialect.tiny.TinyELEvalService;
import com.google.common.base.Stopwatch;

/**
 *
 * @author Shunli
 */
public class ELDemo3 {
    public static void main(String[] args) {
        TinyELEvalService service = new TinyELEvalService();
        service.setAllowMultiStatement(true);
        service.regsiterVariant(ELDemoObj.class, "task");

        Map<String, Object> ctx = new HashMap<String, Object>();
        ELDemoObj task = new ELDemoObj("1", "50");
        ctx.put("task", task);

        System.out.println(service.eval(ctx, "return task.getRemark();"));
        // System.out.println(service.eval(ctx,
        // "String remark = task.getRemark();if(\"1\".equals(remark)){return \"10\";} else if(\"2\".equals(remark)){return \"20\";} else {return \"30\";}"));
        // System.out.println(service.eval(ctx, "if(1 > 2){return 3;} elseif(5> 4){return 4;} else {return 5;}"));

        System.out.println(service.eval(ctx, "return 1 > 2 ? 3 : (4 > 3 ? 5 :6) ;"));
        System.out.println(service.eval(ctx, "return \"1\".equals(task.getRemark()) ? \"10\" : (\"2\".equals(task.getRemark()) ? \"20\" : \"30\");"));

        Stopwatch watch = Stopwatch.createStarted();
        for (int i = 0; i < 10000000; i++) {
            ELDemoObj task2 = new ELDemoObj("1", RandomStringUtils.randomNumeric(1));
            ctx.put("task", task2);
            service.eval(ctx, "return \"1\".equals(task.getRemark()) ? \"10\" : (\"2\".equals(task.getRemark()) ? \"20\" : \"30\");");
            // System.out.println(service.eval(ctx, "return \"1\".equals(task.getRemark()) ? \"10\" : (\"2\".equals(task.getRemark()) ? \"20\" : \"30\");"));
        }
        watch.stop();
        System.out.println(watch.elapsed(TimeUnit.MILLISECONDS));
    }

    // private static String getRtn(ELDemoObj task) {
    // return "1".equals(task.getRemark()) ? "10" : ("2".equals(task.getRemark()) ? "20" : "30");
    // }
}
