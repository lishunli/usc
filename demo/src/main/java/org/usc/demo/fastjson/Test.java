package org.usc.demo.fastjson;

import java.util.Arrays;
import java.util.HashMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 *
 * @author Shunli
 */
public class Test {

	public static void main(String[] args) {
		Entity entry = new Entity("1", 20, 100L, Arrays.asList("lis", "sl", "李"), new HashMap<String, String>() {
			private static final long serialVersionUID = -2577535685906051546L;

			{
				put("2", "2a");
			}
		});
		String jsonStr1 = JSON.toJSONString(entry, SerializerFeature.WriteClassName);
		System.out.println(jsonStr1);

		String jsonStr2 = JSON.toJSONString(entry);
		System.out.println(jsonStr2);

		JSON.parse(jsonStr1);
		// JSON.parseObject(jsonStr1, Entry.class);

	}
}
