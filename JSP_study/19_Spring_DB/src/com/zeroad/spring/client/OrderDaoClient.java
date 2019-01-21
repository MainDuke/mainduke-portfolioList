package com.zeroad.spring.client;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zeroad.spring.dao.order.OrderDAOImpl;
import com.zeroad.spring.dao.order.OrderDAO;
import com.zeroad.spring.model.order.OrderInfo;

public class OrderDaoClient {
	public static void main(String[] args) throws Exception{
		//ApplicationContext ct= new ClassPathXmlApplicationContext("spring-dao.xml");
		//DataSource dataSource= (DataSource)ct.getBean("dataSource");
		//DataSource dataSource= (DataSource)ct.getBean("dataSource2");
		//System.out.println(dataSource.getConnection());
		
		ApplicationContext ct= new ClassPathXmlApplicationContext("spring app.xml");
		OrderDAO orderDAO= (OrderDAO)ct.getBean("orderDao"); //빈 얻기
		
		//1. 주문 처리
		long newOrdNo=orderDAO.getOrderSeq(); //dao 메서드 호출
		System.out.println("no : "+newOrdNo);
		
		//2. orderinfo 테이블에 insert
		OrderInfo newInfo=(OrderInfo)ct.getBean("orderInfo");
		newInfo.setOrdNo(newOrdNo);
		long ordNo=orderDAO.insertOrder(newInfo);
		//실행
		//DB에서 select * from orderinfo;
		
	}//main end
}//class end
