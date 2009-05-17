
package com.test;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "HelloPortType", targetNamespace = "http://hello.com")
@SOAPBinding(use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface HelloPortType
{

	@WebMethod(operationName = "example", action = "")
	@WebResult(name = "out", targetNamespace = "http://hello.com")
	public String example(
			@WebParam(name = "in0", targetNamespace = "http://hello.com") String in0);

}
