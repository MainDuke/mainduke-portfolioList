package sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloAppClient2 {
	
	public static void main(String[] args) {
		
		ApplicationContext ct=new ClassPathXmlApplicationContext("beans2.xml");
		MessageBean bb=(MessageBean)ct.getBean("target");
		bb.sayHello();
		
		// <aop:config>요소를 사용해서 AOP를 설정하는 예제입니다.
		// 자식 요소는 <aop:aspect> 요소가 있습니다.
		// 여기서 advice를 정의 합니다
		// ref 속성에서 advice를 참조 합니다 =>  ref="loggingAdvice"
		
		// <aop:pointcut>요소에 pointcut을 정의하고
		// <aop:around>요소에 
		// AroundAdvice(Joinpoint 앞뒤에서 실행되는 Advice 인것을 기술합니다)
		// <aop:around>요소의 pointcut-ref 속성은 앞에서 정의한 pointcut을 설정하고
		// method 속성은 Advice 클래스 내의 메서드를 설정합니다
		
	}//main

}//class
