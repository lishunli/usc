package org.usc.demo;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyAccessorFactory;

/**
 *
 * @author ShunLi
 */
public class BeanWrapperTest {
    public static void main(String[] args) {
        Object target = new Foo();

        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(target);
        MutablePropertyValues pvs = new MutablePropertyValues();

        Map<String, Object> processorProperties = new HashMap<String, Object>();
        processorProperties.put("name", "lishunli");
        processorProperties.put("age", 11L);
        processorProperties.put("birthDay", new GregorianCalendar(2000,1,1).getTime());

        pvs.addPropertyValues(processorProperties);
        beanWrapper.setPropertyValues(pvs, true);

        System.out.println(((Foo) target));
    }

    public static class Foo {
        private String name;
        private Long age;
        private Date birthDay;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getAge() {
            return age;
        }

        public void setAge(Long age) {
            this.age = age;
        }

        public Date getBirthDay() {
            return birthDay;
        }

        public void setBirthDay(Date birthDay) {
            this.birthDay = birthDay;
        }

        public Foo() {
            super();
        }

        public Foo(String name, Long age, Date birthDay) {
            this.name = name;
            this.age = age;
            this.birthDay = birthDay;
        }

        @Override
        public String toString() {
            return "Foo [" + (name != null ? "name=" + name + ",\n" : "") + (age != null ? "age=" + age + ",\n" : "") + (birthDay != null ? "birthDay=" + birthDay : "") + "]";
        }
    }

}
