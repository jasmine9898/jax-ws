
package org.coderecord.blog.client;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "HelloWorldService", targetNamespace = "org.coderecord.blog")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloWorldService {


    /**
     * 
     */
    @WebMethod
    public void sayHello();

}
