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
    private static final PropertiesConfiguration config = ReloadingPropConfig.getConfig("config.properties");

    // private static JedisPool jedisPool = null;

    public static void main(String[] args) {
        String redisHost = config.getString("redis_host", "localhost");
        int redisPort = config.getInt("redis_port", 6379);

        JedisPool pool = new JedisPool(new JedisPoolConfig(), redisHost, redisPort);

        Jedis jedis = pool.getResource();
        try {
            // jedis.set("foo", "bar");
            // String value = jedis.get("foo");

            // jedis.expire("foo", 10);

            // jedisPool = new JedisPool(config, address, port, timeout);

            // jedis.setex("foo", 10, "bar");

            String value = jedis.get("foo");
            System.out.println(value);

            Map<String, String> cahce = new HashMap<String, String>();
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
