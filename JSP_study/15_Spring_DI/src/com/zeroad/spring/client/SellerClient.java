package com.zeroad.spring.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zeroad.spring.model.product.Computer;
import com.zeroad.spring.model.product.Seller;

public class SellerClient {

	public static void main(String[] args) {
		
		//xml ���� import
		ApplicationContext ctx = new ClassPathXmlApplicationContext("seller.xml");
		
		//pc3 ã��
		Computer pc3 = (Computer)ctx.getBean("pc3");
		System.out.println(pc3.getContents()+"\n");
		
		
		//pc4 �������� ���̺귯���� ��ü
		Computer pc4 = (Computer)ctx.getBean("pc4");
		System.out.println(pc4.getContents()+"\n");
		
		
		//���α׷��Ӱ� �޼��� ��ü
		Seller seller = (Seller)ctx.getBean("seller");
		seller.sell();
		
		
	}//main
	
}//main
