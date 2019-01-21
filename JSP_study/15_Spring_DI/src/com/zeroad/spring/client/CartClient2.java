package com.zeroad.spring.client;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.zeroad.spring.model.MyPostProcessor;
import com.zeroad.spring.service.order.CartService;

public class CartClient2 {

	public static void main(String[] args) {
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("cart.xml"));
		BeanPostProcessor postProcessor=new MyPostProcessor();
		
		factory.addBeanPostProcessor(postProcessor);
		
		//MyPostProcessor my=(MyPostProcessor)factory.getBean("cart");
		
		CartService cart=(CartService)factory.getBean("cart");
		
	
	}
	
	
	
}//class end
