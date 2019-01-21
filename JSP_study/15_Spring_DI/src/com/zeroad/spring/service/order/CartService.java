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
		System.out.println(memId+" : 카트 목롤 적재 \n");
	}
		
	public void storeItems(){
		System.out.println("---------------------destroy-method, storeItems()=============");
		System.out.println(memId+" : 카트 목롤 저장 \n");
	}
	
	//InitializingBean 의 메서드 오버라이딩
	public void afterPropertiesSet() throws Exception{
		System.out.println("InitializingBean.afterPropertiesSet()");
		System.out.println(memId+ " : 카드 목록 적재 \n");
	
	}
	//DisposableBean 의 메서드 오버라이딩
	public void destroy() throws Exception{
		System.out.println("DisposalbleBean.destroy()");
		System.out.println(memId+ " : 카드 목록 저장 \n");
	
	}
	
	
	//빈의 인스턴스 생성, property(속성) 설정,초기화등 이벤트가 발생되는 인터페이스: initializingBean
	//spring 컨테이너가 자동으로 인터페이스를 실행한다.
}//class end
