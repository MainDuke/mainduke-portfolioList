package com.zeroad.spring.client;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zeroad.spring.model.order.OrderInfo;
import com.zeroad.spring.model.order.OrderItem;
import com.zeroad.spring.service.order.OrderService;

public class OrderApplClient {
	public static void main(String[] args) {
		ApplicationContext ct= new ClassPathXmlApplicationContext("spring app.xml");
		
		OrderService orderService=(OrderService)ct.getBean("orderService");
		OrderInfo newOrder=(OrderInfo)ct.getBean("orderInfo");
		OrderItem newItem=(OrderItem)ct.getBean("orderItem");
		
		List<OrderItem> newItems=new ArrayList<OrderItem>();
		newItems.add(newItem);
		
		try{
			//1. 주문 생성
			long ordNo=orderService.createOrder(newOrder, newItems);
			System.out.println("---주문생성 :"+ordNo );
			//2.주문 조회
			OrderInfo order=orderService.getOrder(ordNo);
			System.out.println("----주문 생성 정보 조회");
			System.out.println(order);
			
			//3.주문 항목 조회
			List<OrderItem> items=orderService.getOrderItem(ordNo);
			for(OrderItem item: items ){
				System.out.println(item);
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		
		
		
		
	}//main
}//class end
