package org.usc.demo.redis;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.usc.demo.fastjson.Entity;
import org.usc.demo.fastjson.SubEntity;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.alibaba.fastjson.JSON;
import com.xunlei.youxi.core.kit.config.ReloadingPropConfig;

public class RedisDemo {
    private static final PropertiesConfiguration config = ReloadingPropConfig.getConfig("redis.properties");

    // private static JedisPool jedisPool = null;

    public static void main(String[] args) {
        String redisHost = config.getString("redis_host", "localhost");
        int redisPort = config.getInt("redis_port", 6379);

        JedisPool pool = new JedisPool(new JedisPoolConfig(), redisHost, redisPort);

        Jedis jedis = pool.getResource();
        try {
//            jedis.set("foo", "");
            // String value = jedis.get("foo");

            // jedis.expire("foo", 10);

            // jedisPool = new JedisPool(config, address, port, timeout);

            // jedis.setex("foo", 10, "bar");

            // jedis.setex(key, seconds, value)
            HashMap<String, String> hash = new HashMap<String, String>();
            hash.put("username", "lishunli");
            hash.put("age", "18");
            jedis.hmset("test:hash", hash);

            System.out.println(jedis.hgetAll("test:hash"));

            String value = jedis.get("foo");
            System.out.println(value);

            Map<String, String> cahce = hash;
            cahce.put("2", "2a");
            Entity entry = new Entity("1", 20, 100L, new Date(), Arrays.asList("lis", "sl", "李"), cahce, new SubEntity("test sub entity"));

            String entryJsonStr = JSON.toJSONString(entry);

            jedis.set("test:object", entryJsonStr);

            String jsonStrFromRedis = jedis.get("test:object");
            System.out.println(jsonStrFromRedis);

            Entity parseObject = JSON.parseObject(jsonStrFromRedis, Entity.class);
            System.out.println(ToStringBuilder.reflectionToString(parseObject));
        } finally {
            pool.returnResource(jedis);
        }

    }
}
