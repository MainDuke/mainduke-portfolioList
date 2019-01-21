package com.zeroad.spring.model.product;

public class Notebook extends Computer{

	String battery; //º¯¼ö
	
	public Notebook(String name){
		super(name);
	}//end
	
	//set, get
	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}
	
	//etc
	public String getContents(){
		
		return super.getContents()+"\n battery : "+ battery;
		
	}//end getcon
	
	
	
}
