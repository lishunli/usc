package com.test.proxy;

//代理角色

public class ProxySubject extends Subject

{
    private RealSubject realSubject; // 以真实角色作为代理角色的属性

    public ProxySubject()
    {
    }

    public void request() // 该方法封装了真实对象的request方法

    {
        preRequest();// something you want to do before requesting


        if (realSubject == null)
        {
            realSubject = new RealSubject();
        }

        realSubject.request(); // 此处执行真实对象的request方法

        postRequest();//something you want to do after requesting
    }

    private void preRequest()
    {
    	System.out.println("hello");

        // something you want to do before requesting

    }

    private void postRequest()
    {
    	System.out.println("world");

        // something you want to do after requesting

    }

}
