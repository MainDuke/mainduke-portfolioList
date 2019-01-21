package com.zeroad.spring.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;






import com.zeroad.spring.hello.HelloService;

//Ŭ���̾�Ʈ
public class HelloClient {

	 
//Ŭ���̾�Ʈ
 public static void main(String args[]){
	 
	 //1. BeanFactory�� �̿���  Container ����
	 BeanFactory factory= new XmlBeanFactory(new ClassPathResource("hello.xml"));
	 HelloService service=(HelloService)factory.getBean("helloService");//�� ���
	 service.sayHello();
	 //����
	 //===========================================================================
	 
	 //2.ApplicationContext�� �̿��� Container ����
	 //FileSystemXmlApplicationContext�� �̿��� �� ����, ��� �� Ȯ��!!!!
	 //C:\\00_han\\_spring\\15_Spring_DI\\xml
	 String xmlFile="C:\\00_han\\_spring\\15_Spring_DI\\xml\\hello.xml";

	 ApplicationContext fileCtx= new FileSystemXmlApplicationContext(xmlFile);
	 HelloService service1=(HelloService)fileCtx.getBean("helloService");
	 service1.sayHello();
	 //����
	//===========================================================================
	 
	 //3.ClassPathXmlApplicationContext �� �̿��� �� ����.
	 ApplicationContext classCtx= new ClassPathXmlApplicationContext("hello.xml");
	 HelloService service2=(HelloService)classCtx.getBean("helloService"); 
	 service2.sayHello();
	//===========================================================================
	 
	 
	 //Spring.xml �����.
	 //hello.xml�� spring.xml ���� import �Ѵ�.
	 
	 //4. ���� ������ ����
	 
	 ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
	 HelloService hello=(HelloService)classCtx.getBean("helloService"); 
	 hello.sayHello();
	 
	 
	 
 }//main
	
}//class
