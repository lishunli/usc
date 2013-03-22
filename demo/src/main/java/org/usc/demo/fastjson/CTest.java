package org.usc.demo.fastjson;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xunlei.youxi.act.frm.vo.result.SuccessJsonResult;

/**
 *
 * @author Shunli
 */
public class CTest {
    private static final SerializeConfig mapping;
    static {
        mapping = new SerializeConfig();
        mapping.put(Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
    }

    private static final SerializerFeature[] myFeatures = { SerializerFeature.WriteMapNullValue, // 输出空置字段
            SerializerFeature.WriteDateUseDateFormat // 对Date类型进行序列化的时候，输出为 yyyy-mm-dd HH:mm:ss,而不是long型时间戳
    };

    /**
     * @param args
     */
    public static void main(String[] args) {
        // SuccessJsonResult success = new SuccessJsonResult("test", new LotteryGift(1, "g", "g", 0.2d));
        // System.out.println(new JSONObject(success).toString());
        // System.out.println(success.toJsonString());
        // System.out.println(JSON.toJSONString(success));
        //
        SuccessJsonResult object1 = new SuccessJsonResult("test", new Date());
        SuccessJsonResult object2 = new SuccessJsonResult();
        System.out.println(JSON.toJSONString(object1, mapping, myFeatures));
        System.out.println(object1.toJsonString());

        System.out.println(JSON.toJSONString(object2, myFeatures));
        System.out.println(object2.toJsonString());

        List<String> list = null;
        SuccessJsonResult object3 = new SuccessJsonResult("test", list);
        System.out.println(JSON.toJSONString(object3, myFeatures));
        System.out.println(object3.toJsonString());

    }
}
