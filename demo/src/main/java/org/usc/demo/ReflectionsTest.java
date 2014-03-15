package org.usc.demo;

import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.usc.demo.guava.cache.AbstractCache1;
import org.usc.demo.guava.cache.CacheFactory3;

/**
 *
 * @author Shunli
 */
public class ReflectionsTest {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) {
        Reflections reflection = new Reflections("org.usc.demo");
        Set<Class<? extends AbstractCache1>> subTypesOf = reflection.getSubTypesOf(AbstractCache1.class);
        System.out.println(subTypesOf);
        System.out.println(reflection.getStore().getSubTypesOf("org.usc.demo.guava.AbstractCache1"));

        for (Class<? extends AbstractCache1> clazz : subTypesOf) {
            System.out.println(CacheFactory3.getInstance(clazz).getUnchecked("1"));
            System.out.println(CacheFactory3.getInstance(clazz).getUnchecked("1"));
        }

        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .addUrls(/* ClasspathHelper.forPackage("org.usc.demo"), */ClasspathHelper.forClass(AbstractCache1.class))
                // .addUrls(ClasspathHelper.forPackage("org.usc.demo"))
                .setScanners(/* new TypeAnnotationsScanner(), */new SubTypesScanner()));
        System.out.println(reflections.getSubTypesOf(AbstractCache1.class));
    }

}
