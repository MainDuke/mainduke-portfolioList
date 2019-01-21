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
		OrderDAO orderDAO= (OrderDAO)ct.getBean("orderDao"); //�� ���
		
		//1. �ֹ� ó��
		long newOrdNo=orderDAO.getOrderSeq(); //dao �޼��� ȣ��
		System.out.println("no : "+newOrdNo);
		
		//2. orderinfo ���̺� insert
		OrderInfo newInfo=(OrderInfo)ct.getBean("orderInfo");
		newInfo.setOrdNo(newOrdNo);
		long ordNo=orderDAO.insertOrder(newInfo);
		//����
		//DB���� select * from orderinfo;
		
	}//main end
}//class end
