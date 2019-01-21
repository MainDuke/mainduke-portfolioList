package com.zeroad.spring.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zeroad.spring.model.CollectionBean;



public class CollectionClient {

	public static void main(String[] args) {
		ApplicationContext ct= new ClassPathXmlApplicationContext("collection.xml");
		
		CollectionBean listRefBean=(CollectionBean)ct.getBean("listRefBean");
		listRefBean.printItemList();
		
		System.out.println();
		
		CollectionBean setRefBean=(CollectionBean)ct.getBean("setRefBean");
		setRefBean.printItemSet();
		
		System.out.println();
		
		
		CollectionBean mapRefBean=(CollectionBean)ct.getBean("mapRefBean");
		mapRefBean.printItemMap();
		
		
	}//main end
	
}//class end
