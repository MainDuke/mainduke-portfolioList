package com.zeroad.spring.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyPostProcessor implements BeanPostProcessor{
	
	@Override //before ���ʱ�ȭ ���� ����Ǵ� �޼���.
	public Object postProcessBeforeInitialization(Object bean, String name)
			throws BeansException {
		
		System.out.println("\n�� �ʱ�ȭ ���� ����Ǵ� �޼��� PostProcessBeforeInitialization");
		System.out.println("\n"+name+", "+bean.getClass().getName());
		
		return bean;
	}
	
	@Override //after �� �ʱ�ȭ �Ŀ� ����Ǵ� �޼���.
	public Object postProcessAfterInitialization(Object bean, String name)
			throws BeansException {
		
		System.out.println("\n�� �ʱ�ȭ �Ŀ� ����Ǵ� �޼��� postProcessAfterInitialization");
		System.out.println("\n"+name+", "+bean.getClass().getName());
		
		
		return bean;
	}
	

	//�� ������ �ν��Ͻ� �����Ǳ� ���� ����Ǵ� �޼���.
	public void postProcessBeanFactory(ConfigurableListableBeanFactory factory){
		
		System.out.println("\n�� �� ������ �ν��Ͻ� �����Ǳ� ���� ����Ǵ� �޼���. postProcessBeanFactory");
		
		System.out.println("Bean count : "+factory.getBeanDefinitionCount());

	}//postProcessBeanFactory
	
	
}//class end
