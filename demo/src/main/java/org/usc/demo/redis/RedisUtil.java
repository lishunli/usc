package org.usc.demo.redis;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.alibaba.fastjson.JSON;
import com.xunlei.youxi.core.kit.config.ReloadingPropConfig;
import com.xunlei.youxi.core.log.LoggerFactory;

public class RedisUtil {
    private static Logger log = LoggerFactory.getLogger(RedisUtil.class);

    private static final PropertiesConfiguration REDIS_CONFIG = ReloadingPropConfig.getConfig("redis.properties");
    private static JedisPool jedisPool = null;

    /**
     * 初始化jedisPool
     */
    private static void initialPool() {
        String host = REDIS_CONFIG.getString("redis_host", "localhost");
        int port = REDIS_CONFIG.getInt("redis_port", 6379);

        try {
            JedisPoolConfig config = new JedisPoolConfig();

            config.setMaxActive(REDIS_CONFIG.getInt("redis_pool_max_active", config.getMaxActive()));
            config.setMaxIdle(REDIS_CONFIG.getInt("redis_pool_max_idle", config.getMaxIdle()));
            config.setMaxWait(REDIS_CONFIG.getLong("redis_pool_max_wait", config.getMaxWait()));
            config.setTestOnBorrow(false);
            int timeout = REDIS_CONFIG.getInt("redis_pool_connection_timeout", 2000);

            jedisPool = new JedisPool(config, host, port, timeout);
        } catch (Exception e) {
            log.error("initialPool-failed:" + host + ":" + port, e);
        }

    }

    /**
     * 获得jedis客户端
     *
     * @return
     */
    public synchronized static Jedis getJedisClient() {
        if (jedisPool == null) {
            initialPool();
        }

        // double check
        if (jedisPool == null) {
            log.error("getJedisInstance-no-instance");
            return null;
        }

        try {
            return jedisPool.getResource();
        } catch (Exception e) {
            log.error("getJedisInstance-failed", e);
            return null;
        }
    }

    /**
     * 释放jedis到pool中
     *
     * @param jedis
     */
    public static void returnResource(final Jedis jedis) {
        if (jedis != null && jedisPool != null) {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * set key value
     *
     * @param key
     * @param value
     */
    public static void set(String key, String value) {
        Jedis jedis = getJedisClient();
        try {
            jedis.set(key, value);
        } catch (Exception e) {
            log.error("set-string-failed:" + key + "," + value, e);
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * setnx key value, 不存在则保存成功返回1，存在或者异常则失败返回0
     *
     * @param key
     * @param value
     * @return
     */
    public static long setnx(String key, String value) {
        Jedis jedis = getJedisClient();
        try {
            return jedis.setnx(key, value);
        } catch (Exception e) {
            log.error("setnx-string-failed:" + key + "," + value, e);
            return 0;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * setex key seconds value, 设置过期时间
     *
     * @param key
     * @param value
     * @param seconds
     */
    public static void setex(String key, String value, int seconds) {
        Jedis jedis = getJedisClient();
        try {
            jedis.setex(key, seconds, value);
        } catch (Exception e) {
            log.error("setex-string-failed:" + key + "," + value + "," + seconds, e);
        } finally {
            returnResource(jedis);
        }
    }

    public static long setnxex(String key, String value, int seconds) {
        Jedis jedis = getJedisClient();
        try {

            return 0;
        } catch (Exception e) {
            log.error("setnxex-string-failed:" + key + "," + value, e);
            return 0;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * get key
     *
     * @param key
     * @return
     */
    public static String get(String key) {
        Jedis jedis = getJedisClient();
        try {
            return jedis.get(key);
        } catch (Exception e) {
            log.error("get-string-failed:" + key, e);
            return null;
        } finally {
            returnResource(jedis);
        }
    }

    public static long ttl(String key) {
        Jedis jedis = getJedisClient();
        try {
            return jedis.ttl(key);
        } catch (Exception e) {
            log.error("ttl-failed:" + key, e);
            return -1;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * set key object（使用fastjson序列化成String保存）
     *
     * @param key
     * @param object
     */
    public static void setObject(String key, Object object) {
        set(key, JSON.toJSONString(object));
    }

    /**
     * get key，获得object序列化的值再使用fastjson进行反序列化，进而返回clazz类型的对象
     *
     * @param key
     * @param clazz
     * @return
     */
    public static <T> T getObject(String key, Class<T> clazz) {
        return JSON.parseObject(get(key), clazz);
    }

}
