package com.zeroad.spring.client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CartClient {

	public static void main(String args[]){
		
		AbstractApplicationContext ct= new ClassPathXmlApplicationContext("cart.xml");
		ct.registerShutdownHook();
		
	}//end main
	
}//class ed
