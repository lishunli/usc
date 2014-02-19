package org.usc.demo.beanutils.test;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;
import org.usc.demo.beanutils.convert.SimpleListConverter;
import org.usc.demo.beanutils.convert.SimpleMapConverter;
import org.usc.demo.beanutils.model.UserForType;

public class UserForTypeTest {
    static {
        DateTimeConverter dateConverter = new DateConverter();
        dateConverter.setPattern("yyyy-MM-dd hh:mm:ss");

        ConvertUtils.register(dateConverter, java.util.Date.class);
        ConvertUtils.register(new SimpleListConverter(), List.class);
        ConvertUtils.register(new SimpleMapConverter(), Map.class);
        // ConvertUtils.register(new SimpleListConverter(Collections.EMPTY_LIST), List.class);
        // ConvertUtils.register(new SimpleMapConverter(Collections.EMPTY_MAP), Map.class);
    }

    public static void main(String[] args) throws Exception {
        UserForType ut = new UserForType();

        BeanUtils.setProperty(ut, "sS", "s");
        BeanUtils.setProperty(ut, "i", "1");
        BeanUtils.setProperty(ut, "b", "1");
        BeanUtils.setProperty(ut, "l", "10000000");
        BeanUtils.setProperty(ut, "d", "100.0");
        BeanUtils.setProperty(ut, "f", "100.0");
        BeanUtils.setProperty(ut, "de", "2013-05-12 12:01:02");
        BeanUtils.setProperty(ut, "sa", "1.0,2-3,3");
        BeanUtils.setProperty(ut, "sl", "1.0,2-3,3=4,5 6*7,2|3");
        BeanUtils.setProperty(ut, "m", "1.0=2-0,2-3=4,3,1=2|3|4");
        // BeanUtils.setProperty(ut, "sl", null);
        // BeanUtils.setProperty(ut, "m", null);
        // BeanUtils.setProperty(ut, "sl", Arrays.asList("1", "2"));
        // Map<String, String> map = new HashMap<String, String>();
        // map.put("1", "2");
        // BeanUtils.setProperty(ut, "m", map);
        BeanUtils.setProperty(ut, "xxoo", "nofiled");

        System.out.println(ut);
//        System.out.println(ut.getSa().length);
//        // System.out.println(ut.getSl().size());
//        System.out.println(ut.getM().size());
//
//        Map<String, String> properties = new HashMap<String, String>();
//        properties.put("s", "s");
//        properties.put("i", "1");
//        properties.put("b", "1");
//        properties.put("l", "10000000");
//        properties.put("d", "100.0");
//        properties.put("f", "100.0");
//        properties.put("de", "2013-05-12 12:00:00");
//        properties.put("sa", "1.0,2-3,3");
//        properties.put("sl", null);
//        properties.put("m", "1.0=2-0,2-3=4,3,1=2|3|4");
//
//        UserForType newUT = new UserForType();
//        BeanUtils.populate(newUT, properties);
//
//        System.out.println(newUT);
    }
}
