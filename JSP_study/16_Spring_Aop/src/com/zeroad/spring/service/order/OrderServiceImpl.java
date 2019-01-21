package com.zeroad.spring.service.order;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zeroad.spring.model.order.*;
import com.zeroad.spring.exception.*;
//
//xml/log4j.xml
//



public class OrderServiceImpl implements OrderService{

	protected static final Log logger=(Log)LogFactory.getLog(OrderServiceImpl.class);
	
	@Override
	public long createOrder(OrderInfo order, List<OrderItem> items)
			throws InvalidOrderException {
		// TODO Auto-generated method stub
		
		if(logger.isDebugEnabled()){
			logger.debug("--start creatOrder()");
			logger.debug("주문자 : "+order.getOrderName());
			logger.debug("배송지 : "+order.getDelvAddr());
			logger.debug("수신인 : "+order.getRcvName());
			
		}//if 
		
		long ordNo=0;
		
		try{
			//1.ordNo 생성
			System.out.println("1. ordNo 생성");
			
			//2.insert OrderInfo
			System.out.println("2.OrderInfo 생성");
			
			//orderItem이 없다면 Exception 발생
			if(items.size()==0){
				throw new InvalidOrderException("Invalid Order Exception");
			}//if
			
			//3.insert OrderItem
			System.out.println("3.OrderItem 생성");
			
			//commit
			
			
		}catch(InvalidOrderException e){
			logger.error("주문 실패 : "+e);
			throw e;
		}
		
		logger.debug("주문 완료");
		
		return ordNo;
	}
	
	@Override
	public OrderInfo getOrder(long ordNo) {
		// TODO Auto-generated method stub
		
		if(logger.isDebugEnabled()){
			logger.debug(" 주문 정보 조회: "+ordNo);
		}
		
		
		return null;
	}

	@Override
	public List<OrderItem> getOrderItem(long ordNo) {
		// TODO Auto-generated method stub

		if(logger.isDebugEnabled()){
			logger.debug(" 주문 항목 조회: "+ordNo);
		}

		
		return new ArrayList();
	}
	
}//class end


