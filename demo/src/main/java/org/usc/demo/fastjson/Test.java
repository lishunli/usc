package org.usc.demo.fastjson;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

/**
 *
 * @author Shunli
 */
public class Test {
    @SuppressWarnings("unused")
    private static final SerializerFeature[] features = { SerializerFeature.WriteMapNullValue, // 输出空置字段
            SerializerFeature.WriteNullListAsEmpty, // list字段如果为null，输出为[]，而不是null
            SerializerFeature.WriteNullNumberAsZero, // 数值字段如果为null，输出为0，而不是null
            SerializerFeature.WriteNullBooleanAsFalse, // Boolean字段如果为null，输出为false，而不是null
            SerializerFeature.WriteNullStringAsEmpty, // 字符类型字段如果为null，输出为""，而不是null
            SerializerFeature.WriteDateUseDateFormat // 对Date类型进行序列化的时候，输出为 yyyy-MM-dd HH:mm:ss,而不是long型时间戳
    };

    private static final SerializerFeature[] myFeatures = { SerializerFeature.WriteMapNullValue, // 输出空置字段
            SerializerFeature.WriteDateUseDateFormat // 对Date类型进行序列化的时候，输出为 yyyy-mm-dd HH:mm:ss,而不是long型时间戳
    };

    public static void main(String[] args) {
        Map<String, String> cahce = new HashMap<String, String>();
        cahce.put("2", "2a");
        // Entity entry = new Entity("1", 20, 100L, new Date(), Arrays.asList("lis", "sl", "李"), cahce);
        Entity entry = new Entity(null, 20, 100L, new Date(), null, cahce);
        // Entity entry = new Entity("1", 20, 100L, new Date(), Arrays.asList("lis", "sl", "李"), cahce, new SubEntity("test sub entity"));

        String jsonStr2 = JSON.toJSONString(entry, myFeatures);
        System.out.println(jsonStr2);

        Entity parseObject = JSON.parseObject(jsonStr2, Entity.class);
        System.out.println(ToStringBuilder.reflectionToString(parseObject));
        System.out.println(ToStringBuilder.reflectionToString(parseObject.getSubEntity()));
        // otherTest(entry);

        SerializeConfig mapping = new SerializeConfig();
        mapping.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd"));

        String jsonStringWithDateFormat = JSON.toJSONString(entry, mapping, myFeatures);
        // String jsonStringWithDateFormat = JSON.toJSONStringWithDateFormat(entry, "yyyy-MM-dd", myFeatures);
        System.out.println(jsonStringWithDateFormat);

        Entity parseObject2 = JSON.parseObject(jsonStringWithDateFormat, Entity.class);
        System.out.println(ToStringBuilder.reflectionToString(parseObject2));

    }
    public static void otherTest(Entity entry) {
        String jsonStr1 = JSON.toJSONString(entry, SerializerFeature.WriteClassName);
        System.out.println(jsonStr1);

        Entity parseObject3 = JSON.parseObject(jsonStr1, Entity.class);
        System.out.println(ToStringBuilder.reflectionToString(parseObject3));

        Entity parseObject2 = JSON.parseObject(jsonStr1, new TypeReference<Entity>() {
        });
        System.out.println(ToStringBuilder.reflectionToString(parseObject2));

    }
}
