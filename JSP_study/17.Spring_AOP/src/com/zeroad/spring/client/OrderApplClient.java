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
			//1. �ֹ� ����
			long ordNo=orderService.createOrder(newOrder, newItems);
			System.out.println("---�ֹ����� :"+ordNo );
			//2.�ֹ� ��ȸ
			OrderInfo order=orderService.getOrder(ordNo);
			System.out.println("----�ֹ� ���� ���� ��ȸ");
			System.out.println(order);
			
			//3.�ֹ� �׸� ��ȸ
			List<OrderItem> items=orderService.getOrderItem(ordNo);
			for(OrderItem item: items ){
				System.out.println(item);
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		
		
		
		
	}//main
}//class end
