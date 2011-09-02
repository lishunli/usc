package org.usc.demo.dynamic.proxy;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Foo foo1 = new FooImpl1();

        DynamicProxyHandler h = new DynamicProxyHandler(foo1);


        Foo foo = (Foo) Proxy.newProxyInstance(foo1.getClass().getClassLoader(), foo1.getClass().getInterfaces(), h);
        Foo cast = Foo.class.cast(Proxy.newProxyInstance(foo1.getClass().getClassLoader(), foo1.getClass().getInterfaces(), h));
        System.out.println(cast);
        foo.doSomething("lishunli");
        cast.doSomething("lishunli");

        h.setObj(new FooImpl2());
        foo.doSomething("shumn");
        cast.doSomething("shumn");

    }
}
