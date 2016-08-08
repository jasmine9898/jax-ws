package com.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.coderecord.blog.client.HelloWorldService;
import org.coderecord.blog.client.HelloWorldServiceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jax.server.client.MyServiceImpl;
import com.jax.server.client.MyServiceImplService;


@Controller
public class TestController {

	@RequestMapping("hello.do")
	public void hello(){
	}
//http://localhost:8280/jax-ws/service/hello?wsdl
	public static void main1(String[] args) throws MalformedURLException, RemoteException{
		URL url = new URL("http://localhost:8080/jax-ws/service/hello?wsdl");  
		QName serviceName  = new QName("org.coderecord.blog","HelloWorldServiceService");
		QName portName = new QName("org.coderecord.blog", "HelloWorldServicePort");
		Service service = Service.create(url, serviceName );
		HelloWorldService hello=service.getPort(portName,HelloWorldService.class);
		hello.sayHello();			
	}
	
	public static void main2(String[] args) {
		HelloWorldServiceService hws=new HelloWorldServiceService();
		HelloWorldService hw=hws.getHelloWorldServicePort();
		hw.sayHello();
	}
	public static void main(String[] args) {
		MyServiceImplService mys=new MyServiceImplService();
		MyServiceImpl my=mys.getMyServiceImplPort();
		System.out.println(my.add(2,5));
	}
	@RequestMapping("client2.do")
	@ResponseBody
	public String myserviceclient(){
		MyServiceImplService mys=new MyServiceImplService();
		MyServiceImpl my=mys.getMyServiceImplPort();
		return "myservice :"+my.add(2,5);
	}
	@RequestMapping("client.do")
	@ResponseBody
	public String myserviceclient2() throws MalformedURLException{
	URL url = new URL("http://localhost:8080/jaxws-spring/service/myservice?wsdl");  
	QName serviceName  = new QName("http://server.jax.com/","MyServiceImplService");
	QName portName = new QName("http://server.jax.com/", "MyServiceImplPort");
	Service service = Service.create(url, serviceName );
	MyServiceImpl my=service.getPort(portName,MyServiceImpl.class);
	return "myservice add  "+my.add(11,100);
	}
}
