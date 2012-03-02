package org.usc.demo.webservices.client;



public class Client {
    public static void main(String[] args) {
        HelloService service = new HelloService();
        Hello _hello = service.getHelloPort();
        System.out.println(_hello.sayHello("Shunli Lee"));
    }
}
