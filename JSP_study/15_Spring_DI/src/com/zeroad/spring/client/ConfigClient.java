package com.zeroad.spring.client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zeroad.spring.model.Config;

public class ConfigClient {
	public static void main(String[] args) {
		
		AbstractApplicationContext ct=new ClassPathXmlApplicationContext("config.xml");
		Config cart=(Config)ct.getBean("config");
		
		System.out.println(cart.toString()); //½ÇÇà
		
		
		
	}//main
}//class end
