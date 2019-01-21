package com.zeroad.spring.hello;

public class HelloServiceManager {

	public static HelloService getInstance(){
		
		return new HelloServiceImpl();
		
	}// end
	
}//class
