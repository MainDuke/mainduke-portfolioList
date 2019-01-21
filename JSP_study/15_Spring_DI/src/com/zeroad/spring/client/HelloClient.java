package com.zeroad.spring.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;






import com.zeroad.spring.hello.HelloService;

//클라이언트
public class HelloClient {

	 
//클라이언트
 public static void main(String args[]){
	 
	 //1. BeanFactory를 이용한  Container 생성
	 BeanFactory factory= new XmlBeanFactory(new ClassPathResource("hello.xml"));
	 HelloService service=(HelloService)factory.getBean("helloService");//빈 얻기
	 service.sayHello();
	 //실행
	 //===========================================================================
	 
	 //2.ApplicationContext를 이용한 Container 생성
	 //FileSystemXmlApplicationContext를 이용한 빈 참조, 경로 꼭 확인!!!!
	 //C:\\00_han\\_spring\\15_Spring_DI\\xml
	 String xmlFile="C:\\00_han\\_spring\\15_Spring_DI\\xml\\hello.xml";

	 ApplicationContext fileCtx= new FileSystemXmlApplicationContext(xmlFile);
	 HelloService service1=(HelloService)fileCtx.getBean("helloService");
	 service1.sayHello();
	 //실행
	//===========================================================================
	 
	 //3.ClassPathXmlApplicationContext 를 이용한 빈 참조.
	 ApplicationContext classCtx= new ClassPathXmlApplicationContext("hello.xml");
	 HelloService service2=(HelloService)classCtx.getBean("helloService"); 
	 service2.sayHello();
	//===========================================================================
	 
	 
	 //Spring.xml 만든다.
	 //hello.xml를 spring.xml 에서 import 한다.
	 
	 //4. 빈의 생성과 선언
	 
	 ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
	 HelloService hello=(HelloService)classCtx.getBean("helloService"); 
	 hello.sayHello();
	 
	 
	 
 }//main
	
}//class
