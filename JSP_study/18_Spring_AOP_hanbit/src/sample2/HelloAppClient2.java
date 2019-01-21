package sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloAppClient2 {
	
	public static void main(String[] args) {
		
		ApplicationContext ct=new ClassPathXmlApplicationContext("beans2.xml");
		MessageBean bb=(MessageBean)ct.getBean("target");
		bb.sayHello();
		
		// <aop:config>��Ҹ� ����ؼ� AOP�� �����ϴ� �����Դϴ�.
		// �ڽ� ��Ҵ� <aop:aspect> ��Ұ� �ֽ��ϴ�.
		// ���⼭ advice�� ���� �մϴ�
		// ref �Ӽ����� advice�� ���� �մϴ� =>  ref="loggingAdvice"
		
		// <aop:pointcut>��ҿ� pointcut�� �����ϰ�
		// <aop:around>��ҿ� 
		// AroundAdvice(Joinpoint �յڿ��� ����Ǵ� Advice �ΰ��� ����մϴ�)
		// <aop:around>����� pointcut-ref �Ӽ��� �տ��� ������ pointcut�� �����ϰ�
		// method �Ӽ��� Advice Ŭ���� ���� �޼��带 �����մϴ�
		
	}//main

}//class
