package sample1;


import org.aspectj.bridge.Message;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HelloClient {

	public static void main(String[] args) {
		ApplicationContext ct= new ClassPathXmlApplicationContext("bean.xml");
		
		MessageBean bean = (MessageBean)ct.getBean("proxy");
		bean.sayHello(); //½ÇÇà
		
	}
	
}//class
