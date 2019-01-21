package com.zeroad.spring.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zeroad.spring.model.CollectionBean;
import com.zeroad.spring.model.product.Computer;
import com.zeroad.spring.model.product.Notebook;

public class AbstractClient {
	
	public static void main(String[] args) {
		ApplicationContext ct= new ClassPathXmlApplicationContext("abstract.xml");
		
		//1.pc1 빈 참조
		
		Computer pc1=(Computer)ct.getBean("pc1");
		System.out.println(pc1.getContents()+"\n");
		
		//2. note1 참조
		
		Notebook note1=(Notebook)ct.getBean("note1");
		System.out.println(note1.getContents()+"\n");
		
		//3. pc2 참조
		
		Computer pc2=(Computer)ct.getBean("pc2");
		System.out.println(pc2.getContents()+"\n");
				
		//4. note1 참조
			
		Notebook note2=(Notebook)ct.getBean("note2");
		System.out.println(note2.getContents()+"\n");
				
		
	}//main end
	

}//class end
