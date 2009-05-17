
package com.test;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.HashMap;
import javax.xml.namespace.QName;
import org.codehaus.xfire.XFireRuntimeException;
import org.codehaus.xfire.aegis.AegisBindingProvider;
import org.codehaus.xfire.annotations.AnnotationServiceFactory;
import org.codehaus.xfire.annotations.jsr181.Jsr181WebAnnotations;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.jaxb2.JaxbTypeRegistry;
import org.codehaus.xfire.service.Endpoint;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.soap.AbstractSoapBinding;
import org.codehaus.xfire.transport.TransportManager;

public class HelloClient {

    private static XFireProxyFactory proxyFactory = new XFireProxyFactory();
    @SuppressWarnings("unchecked")
	private HashMap endpoints = new HashMap();
    private Service service0;

    @SuppressWarnings("unchecked")
	public HelloClient() {
        create0();
        Endpoint HelloPortTypeLocalEndpointEP = service0 .addEndpoint(new QName("http://hello.com", "HelloPortTypeLocalEndpoint"), new QName("http://hello.com", "HelloPortTypeLocalBinding"), "xfire.local://Hello");
        endpoints.put(new QName("http://hello.com", "HelloPortTypeLocalEndpoint"), HelloPortTypeLocalEndpointEP);
        Endpoint HelloHttpPortEP = service0 .addEndpoint(new QName("http://hello.com", "HelloHttpPort"), new QName("http://hello.com", "HelloHttpBinding"), "http://localhost:8080/WebService/services/Hello");
        endpoints.put(new QName("http://hello.com", "HelloHttpPort"), HelloHttpPortEP);
    }

    public Object getEndpoint(Endpoint endpoint) {
        try {
            return proxyFactory.create((endpoint).getBinding(), (endpoint).getUrl());
        } catch (MalformedURLException e) {
            throw new XFireRuntimeException("Invalid URL", e);
        }
    }

    public Object getEndpoint(QName name) {
        Endpoint endpoint = ((Endpoint) endpoints.get((name)));
        if ((endpoint) == null) {
            throw new IllegalStateException("No such endpoint!");
        }
        return getEndpoint((endpoint));
    }

    @SuppressWarnings("unchecked")
	public Collection getEndpoints() {
        return endpoints.values();
    }

    @SuppressWarnings("unchecked")
	private void create0() {
        TransportManager tm = (org.codehaus.xfire.XFireFactory.newInstance().getXFire().getTransportManager());
        HashMap props = new HashMap();
        props.put("annotations.allow.interface", true);
        AnnotationServiceFactory asf = new AnnotationServiceFactory(new Jsr181WebAnnotations(), tm, new AegisBindingProvider(new JaxbTypeRegistry()));
        asf.setBindingCreationEnabled(false);
        service0 = asf.create((com.test.HelloPortType.class), props);
        {
            @SuppressWarnings("unused")
			AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://hello.com", "HelloPortTypeLocalBinding"), "urn:xfire:transport:local");
        }
        {
            @SuppressWarnings("unused")
			AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://hello.com", "HelloHttpBinding"), "http://schemas.xmlsoap.org/soap/http");
        }
    }

    public HelloPortType getHelloPortTypeLocalEndpoint() {
        return ((HelloPortType)(this).getEndpoint(new QName("http://hello.com", "HelloPortTypeLocalEndpoint")));
    }

    public HelloPortType getHelloPortTypeLocalEndpoint(String url) {
        HelloPortType var = getHelloPortTypeLocalEndpoint();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

    public HelloPortType getHelloHttpPort() {
        return ((HelloPortType)(this).getEndpoint(new QName("http://hello.com", "HelloHttpPort")));
    }

    public HelloPortType getHelloHttpPort(String url) {
        HelloPortType var = getHelloHttpPort();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

    public static void main(String[] args) {
        

        HelloClient client = new HelloClient();
        
		//create a default service endpoint
        HelloPortType service = client.getHelloHttpPort();

        
        System.out.println(service.example("jsjmz"));
        
		System.out.println("test client completed");
        		System.exit(0);
    }

}
