package org.usc.demo.redis;

import redis.clients.jedis.Jedis;

public class RedisDemo {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.1.105");
        jedis.set("foo", "bar");
        String value = jedis.get("foo");
        System.out.println(value);
    }
}
