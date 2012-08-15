package org.usc.weibo.cache;

import java.util.Date;

import org.usc.weibo.util.Constants;

import weibo4j.model.WeiboException;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

public class CacheService {
    private static final String poolName = "youxinetbarprivilegepoolname";

    private static CacheService instance = new CacheService();
    private static MemCachedClient mc = new MemCachedClient(poolName);
    private SockIOPool pool = null;

    public static CacheService instance() {
        return instance;
    }
    private CacheService() {
        String serverlist = "127.0.0.1:11211";
        serverlist = Constants.SERVERLIST;
        String[] servers = serverlist.split(",");
        pool = SockIOPool.getInstance(poolName);
        pool.setWeights(new Integer[] { 4, 1 });
        pool.setServers(servers);
        pool.setFailover(true);
        pool.setInitConn(10);
        pool.setMinConn(5);
        pool.setMaxConn(250);
        pool.setMaintSleep(30);
        pool.setNagle(false);
        pool.setSocketTO(3000);
        pool.setMaxIdle(6 * 60 * 60 * 1000);
        pool.setAliveCheck(true);
        pool.initialize();
    }

    public MemCachedClient getClient() {
        return mc;
    }

    @Override
    protected void finalize() {
        if (this.pool != null) {
            this.pool.shutDown();
        }
    }
    public <T> void saveObj(String key, T obj) {
        if (this.getClient().keyExists(key)) {
            this.replaceObj(key, obj);
        } else {
            this.getClient().add(key, obj);
        }
    }
    public <T> void saveObj(String key, T obj, Date date) {
        if (this.getClient().keyExists(key)) {
            this.replaceObj(key, obj, date);
        } else {
            this.getClient().add(key, obj, date);
        }
    }
    public <T> void saveObj(String key, T obj, long timestamp) {
        Date date = new Date();
        date.setTime(date.getTime() + timestamp);
        this.saveObj(key, obj, date);
    }

    public <T> void replaceObj(String key, T obj) {
        this.getClient().replace(key, obj);
    }
    public <T> void replaceObj(String key, T obj, Date date) {
        this.getClient().replace(key, obj, date);
    }

    public void delete(String key) {
        this.getClient().delete(key);
    }

    public <T> void addOnly(String key, T obj, long timestamp) {
        if (!this.getClient().keyExists(key)) {
            Date date = new Date();
            date.setTime(date.getTime() + timestamp);
            this.getClient().add(key, obj, date);
        }
    }
    @SuppressWarnings("unchecked")
    public <T> T getObj(String key, Class<T> clazz) {
        Object o = this.getClient().get(key);
        if (o == null)
            return null;
        return (T) o;
    }

    public boolean existKey(String key) {
        return this.getClient().keyExists(key);
    }

    public static void main(String[] args) throws WeiboException {
//        instance.delete("WEIBO_1");
//        instance.delete("WEIBO_2");
        System.out.println(instance.getObj("WEIBO_1", Object.class));
        System.out.println(instance.getObj("WEIBO_2", Object.class));
    }
}
