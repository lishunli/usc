package org.usc.demo.guava;

import java.util.List;
import java.util.Map;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 *
 * @author Shunli
 */
public class GuavaTest1 {

    /**
     * @param args
     */
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Map<String, Map<Long, List<String>>> map1 = Maps.newHashMap();
        Lists.newArrayList();
        Sets.newHashSet();

        ImmutableList<String> list = ImmutableList.of("a", "b", "c", "d");

        ImmutableMap<String, String> map = ImmutableMap.of("key1", "value1", "key2", "value2");
        System.out.println(list);
        System.out.println(map);

        HashMultimap<String, String> map2 = HashMultimap.create();
        map2.put("1", "test1");
        map2.put("1", "test1");
        map2.put("2", "test1");

        System.out.println(map2);
    }

}
