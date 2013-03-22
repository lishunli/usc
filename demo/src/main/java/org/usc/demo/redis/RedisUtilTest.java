package org.usc.demo.redis;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.usc.demo.fastjson.Entity;
import org.usc.demo.fastjson.SubEntity;

/**
 *
 * @author Shunli
 */
public class RedisUtilTest {
    private final static String KEY_PREFIX = "jedis:lishunli:test:";

    public static void main(String[] args) {
        setGet();
        setnx();
        setexTtl();
        existsDel();
        // incr();
        // decr();
        // setGetObject1();
        // setGetObject2();
    }

    public static void setGet() {
        System.out.println(StringUtils.center(" setGet ", 60, "="));

        String key = KEY_PREFIX + RandomStringUtils.randomAlphabetic(6);
        String value = "test";

        System.out.println(key);
        RedisUtil.set(key, value);
        System.out.println(RedisUtil.get(key));
    }

    public static void setnx() {
        System.out.println(StringUtils.center(" setnx ", 60, "="));

        String key = KEY_PREFIX + RandomStringUtils.randomAlphabetic(6);
        String value = "test";

        System.out.println(key);
        System.out.println(RedisUtil.setnx(key, value));
        System.out.println(RedisUtil.setnx(key, value));
    }

    public static void setexTtl() {
        System.out.println(StringUtils.center(" setexTtl ", 60, "="));

        String key = KEY_PREFIX + RandomStringUtils.randomAlphabetic(6);
        String value = "test";

        RedisUtil.setex(key, value, 10);

        System.out.println(key);
        System.out.println();
        System.out.println(RedisUtil.ttl(key));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(RedisUtil.ttl(key));
    }

    public static void existsDel() {
        System.out.println(StringUtils.center(" del ", 60, "="));

        String key = KEY_PREFIX + RandomStringUtils.randomAlphabetic(6);
        String value = "test";

        System.out.println(key);
        RedisUtil.set(key, value);
        System.out.println(RedisUtil.get(key));

        System.out.println(RedisUtil.exists(key));
        System.out.println(RedisUtil.del(key));
        System.out.println(RedisUtil.exists(key));
        System.out.println(RedisUtil.del(key));
    }

    public static void incr() {
        System.out.println(StringUtils.center(" incr ", 60, "="));

        String key = KEY_PREFIX + RandomStringUtils.randomAlphabetic(6);

        System.out.println(key);
        System.out.println(RedisUtil.incr(key));
        System.out.println(RedisUtil.incr(key));
        System.out.println(RedisUtil.del(key));
        System.out.println(RedisUtil.exists(key));
        System.out.println(RedisUtil.incr(key));
        System.out.println(RedisUtil.incrBy(key, 100));

        RedisUtil.set(key, "test");
        System.out.println(RedisUtil.incr(key));
    }

    public static void decr() {
        System.out.println(StringUtils.center(" decr ", 60, "="));

        String key = KEY_PREFIX + RandomStringUtils.randomAlphabetic(6);

        System.out.println(key);
        System.out.println(RedisUtil.decr(key));

        RedisUtil.set(key, "100");
        System.out.println(RedisUtil.decr(key));
        System.out.println(RedisUtil.decr(key));
        System.out.println(RedisUtil.decrBy(key, 50));

        RedisUtil.set(key, "test");
        System.out.println(RedisUtil.incr(key));
    }

    public static void setGetObject1() {
        System.out.println(StringUtils.center(" setGetObject1 ", 60, "="));

        String key = KEY_PREFIX + RandomStringUtils.randomAlphabetic(6);
        Date object = new Date();
        RedisUtil.setObject(key, object);

        System.out.println(key);
        System.out.println(RedisUtil.get(key));
        System.out.println(RedisUtil.getObject(key, Date.class));
    }

    public static void setGetObject2() {
        System.out.println(StringUtils.center(" setGetObject2 ", 60, "="));

        String key = KEY_PREFIX + RandomStringUtils.randomAlphabetic(6);

        Map<String, String> cahce = new HashMap<String, String>();
        cahce.put("2", "2a");
        Entity entry = new Entity("1", 20, 100L, new Date(), Arrays.asList("lis", "sl", "李"), cahce, new SubEntity("test sub entity"));

        RedisUtil.setObject(key, entry);

        System.out.println(key);
        System.out.println(RedisUtil.get(key));
        System.out.println(ToStringBuilder.reflectionToString(RedisUtil.getObject(key, Entity.class)));
    }
}
