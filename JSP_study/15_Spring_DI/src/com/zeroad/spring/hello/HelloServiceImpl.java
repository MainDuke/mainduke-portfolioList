package com.zeroad.spring.hello;

public class HelloServiceImpl implements HelloService{
	
	//Àü¿ªº¯¼ö
	private String name;
	
	public HelloServiceImpl(){}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void sayHello() {
		System.out.println("hello!!!"+name+"´Ô");
	}
	
}//class
