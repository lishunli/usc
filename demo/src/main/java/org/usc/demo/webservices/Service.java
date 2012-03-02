package org.usc.demo.webservices;
import javax.xml.ws.Endpoint;

public class Service {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/HelloService", new Hello());
    }
}
