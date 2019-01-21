package com.zeroad.spring.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zeroad.spring.model.product.Computer;
import com.zeroad.spring.model.product.Seller;

public class SellerClient {

	public static void main(String[] args) {
		
		//xml 파일 import
		ApplicationContext ctx = new ClassPathXmlApplicationContext("seller.xml");
		
		//pc3 찾기
		Computer pc3 = (Computer)ctx.getBean("pc3");
		System.out.println(pc3.getContents()+"\n");
		
		
		//pc4 제공해준 라이브러리로 대체
		Computer pc4 = (Computer)ctx.getBean("pc4");
		System.out.println(pc4.getContents()+"\n");
		
		
		//프로그래머가 메서드 대체
		Seller seller = (Seller)ctx.getBean("seller");
		seller.sell();
		
		
	}//main
	
}//main
