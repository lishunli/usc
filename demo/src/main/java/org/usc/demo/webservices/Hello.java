package org.usc.demo.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(targetNamespace = "http://webservices.demo.usc.org/client")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Hello {
    @WebMethod
    public String sayHello(String name) {
        return "hello: " + name;
    }
}
