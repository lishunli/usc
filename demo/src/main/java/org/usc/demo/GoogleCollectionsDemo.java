package org.usc.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;

public class GoogleCollectionsDemo {

    /**
     * 比较传统的JDK与Google Collections获取不可修改的List集合
     */
    public void testImmutableList() {
        // 1.JDK5.0 传统的方式
        System.out.println(StringUtils.center(" 1.JDK5.0 传统的方式 ", 60, "-"));
        List<String> names = new ArrayList<String>();
        names.add("james");
        names.add("bryant");
        List<String> immutableNamesJdk = Collections.unmodifiableList(names);
        System.out.println("JDK1.5方式:" + immutableNamesJdk);
        names.add("1");
        // System.out.println("JDK1.5方式:"+immutableNamesJdk);

        // 2.Google Collections 第一种方式获取
        List<String> immutableNamesGoogle1 = ImmutableList.copyOf(names);// of("james", "bryant");
        System.out.println("Google Collections获取方式1:" + immutableNamesGoogle1);

        // 2.Google Collections 第二种方式获取
        ImmutableList.Builder<String> builder = ImmutableList.builder();
        builder.addAll(names);
        // builder.add("james","bryant");
        ImmutableList<String> immutableNamesGoogle2 = builder.build();

        System.out.println("Google Collections获取方式2:" + immutableNamesGoogle2);
        names.add("1");
        System.out.println("Google Collections获取方式2:" + immutableNamesGoogle2);
    }

    /**
     * 测试Multiset的用法
     */
    public void testMultiset() {
        // 对比:
        // 1.JDK5.0 中的Set是一个无序不重复的集合
        // 2.Google Collections的MultiSet是一个无序但是可添加重复的元素的集合
        Multiset<String> multiSet = HashMultiset.create();
        multiSet.add("james");
        multiSet.add("bryant");
        multiSet.add("james");
        // MultiSet用来计数统计是很方便的,传统的需要用Map把值取出来+1再放回去
        System.out.println("获取Multiset中的james个数:" + multiSet.count("james"));
        System.out.println("Multiset中的元素:" + multiSet);
    }

    /**
     * 测试Multimap的用法
     */
    public void testMultimap() {
        // 对比:
        // Google Collections 的MultiMap<K,V> 类似于 Map<K ,Collection<V>>
        Multimap<String, String> multiMap = HashMultimap.create();
        multiMap.put("23", "james");
        multiMap.put("24", "bryant");
        multiMap.put(null, "jordan");
        multiMap.put("23", "jordan");
        multiMap.put(null, "james");
        // 注意,MultiMap取得的数据不是String类型,而是Collection类型
        Collection<String> collection = multiMap.get(null);

        System.out.println(multiMap.asMap().values());

        System.out.println("23号球员有:" + collection);
    }

    /**
     * 测试BiMap的用法
     */
    public void testBiMap() {
        // Google Collections 的BiMap 是一个双向的Map
        // 可以根据Key得到value，也可以根据value得到key
        // BiMap的健唯一、值也唯一
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("23Cel", "james");
        biMap.put("24Laker", "bryant");
        System.out.println("获取23Cel的值:" + biMap.get("23Cel"));

        // 将Map反向，即得到Map<V,K>
        BiMap<String, String> inverseMap = biMap.inverse();
        System.out.println("获取值为bryant的key值:" + inverseMap.get("bryant"));
    }

    /**
     * 测试MapMaker
     */
    /*
     * public void testMapMaker(){
     *
     * //MapMaker是对ConcurrentMap的建立，对传进来的Key进行一些列操作生成Value值 //当没有Put的时候，根据function传入的value值，计算出value值， //当有put的时候，对应的value值就是放入的value值
     *
     * //线程安全，高并发性能，异步超时清理，自定义构建元素等强大功能于一身 ConcurrentMap<String, Integer> mapMaker = new MapMaker() //这一串暂时不知是啥意思,根据给出的例子是这么写的。只知道运用了Builder模式 // new
     * MapMaker().weakKeys() // 指定Map保存的Key为WeakReference机制 // new MapMaker().weakValues() // 指定Map保存的Value为WeakReference机制
     * .concurrencyLevel(32).softKeys().weakValues().expiration(30, TimeUnit.MINUTES).makeComputingMap( new Function<String, Integer>() {
     *
     * @Override public Integer apply(String key) { return Integer.parseInt(key) + 100; } }); //如果沒有Put的时候,按照Function提供的算法
     * System.out.println("没有Put的情况下:"+mapMaker.get("111"));
     *
     * //如果有Put的情况下,按照指定的值赋予Value值 mapMaker.put("111", 123); System.out.println("有Put的情况下:"+mapMaker.get("111")); }
     */

    public static void main(String[] args) {
        GoogleCollectionsDemo demo = new GoogleCollectionsDemo();
        demo.testImmutableList();
        demo.testMultiset();
        demo.testMultimap();
        demo.testBiMap();
        // demo.testMapMaker();
    }
}
