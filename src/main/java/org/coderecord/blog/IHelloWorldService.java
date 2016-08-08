package org.coderecord.blog;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;


@WebService(targetNamespace = "org.coderecord.blog")
@SOAPBinding(style = Style.RPC)
public interface IHelloWorldService {
	
	 @WebMethod
	public void sayHello();

}
