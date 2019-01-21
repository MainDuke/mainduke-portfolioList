package com.zeroad.spring.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyPostProcessor implements BeanPostProcessor{
	
	@Override //before 빈초기화 전에 실행되는 메서드.
	public Object postProcessBeforeInitialization(Object bean, String name)
			throws BeansException {
		
		System.out.println("\n번 초기화 전에 실행되는 메서드 PostProcessBeforeInitialization");
		System.out.println("\n"+name+", "+bean.getClass().getName());
		
		return bean;
	}
	
	@Override //after 빈 초기화 후에 실행되는 메서드.
	public Object postProcessAfterInitialization(Object bean, String name)
			throws BeansException {
		
		System.out.println("\n번 초기화 후에 실행되는 메서드 postProcessAfterInitialization");
		System.out.println("\n"+name+", "+bean.getClass().getName());
		
		
		return bean;
	}
	

	//빈 적재후 인스턴스 생성되기 전에 실행되는 메서드.
	public void postProcessBeanFactory(ConfigurableListableBeanFactory factory){
		
		System.out.println("\n번 빈 적재후 인스턴스 생성되기 전에 실행되는 메서드. postProcessBeanFactory");
		
		System.out.println("Bean count : "+factory.getBeanDefinitionCount());

	}//postProcessBeanFactory
	
	
}//class end
