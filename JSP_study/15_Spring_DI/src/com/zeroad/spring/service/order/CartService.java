package com.zeroad.spring.service.order;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class CartService implements InitializingBean, DisposableBean {

	String memId;
	
	public CartService(String memId){
		this.memId=memId;
	}
	
	public void loadItems(){
		System.out.println("---------------------init-method, loadItems()=============");
		System.out.println(memId+" : īƮ ��� ���� \n");
	}
		
	public void storeItems(){
		System.out.println("---------------------destroy-method, storeItems()=============");
		System.out.println(memId+" : īƮ ��� ���� \n");
	}
	
	//InitializingBean �� �޼��� �������̵�
	public void afterPropertiesSet() throws Exception{
		System.out.println("InitializingBean.afterPropertiesSet()");
		System.out.println(memId+ " : ī�� ��� ���� \n");
	
	}
	//DisposableBean �� �޼��� �������̵�
	public void destroy() throws Exception{
		System.out.println("DisposalbleBean.destroy()");
		System.out.println(memId+ " : ī�� ��� ���� \n");
	
	}
	
	
	//���� �ν��Ͻ� ����, property(�Ӽ�) ����,�ʱ�ȭ�� �̺�Ʈ�� �߻��Ǵ� �������̽�: initializingBean
	//spring �����̳ʰ� �ڵ����� �������̽��� �����Ѵ�.
}//class end
