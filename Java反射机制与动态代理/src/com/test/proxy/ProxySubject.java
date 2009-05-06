package com.test.proxy;

//�����ɫ

public class ProxySubject extends Subject

{
    private RealSubject realSubject; // ����ʵ��ɫ��Ϊ�����ɫ������

    public ProxySubject()
    {
    }

    public void request() // �÷�����װ����ʵ�����request����

    {
        preRequest();// something you want to do before requesting


        if (realSubject == null)
        {
            realSubject = new RealSubject();
        }

        realSubject.request(); // �˴�ִ����ʵ�����request����

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
