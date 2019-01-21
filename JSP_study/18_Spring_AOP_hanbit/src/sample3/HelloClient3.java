package sample3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloClient3 {

	public static void main(String[] args) {
		ApplicationContext ct=new ClassPathXmlApplicationContext("beans3.xml");
		
		MessageBean msg=(MessageBean)ct.getBean("target");
		
		msg.sayHello();
		
	}//ed
	
}//class end
