package com.zeroad.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SangpumClient {

	public static void main(String[] args) {
		ApplicationContext ct= new ClassPathXmlApplicationContext("sangpum.xml");
		
		Sangpum sp=(Sangpum)ct.getBean("sp");
		
		System.out.println(sp.getContents());
		
	}
	
}//class
