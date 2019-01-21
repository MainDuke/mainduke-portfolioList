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
			logger.debug("�ֹ��� : "+order.getOrderName());
			logger.debug("����� : "+order.getDelvAddr());
			logger.debug("������ : "+order.getRcvName());
			
		}//if 
		
		long ordNo=0;
		
		try{
			//1.ordNo ����
			System.out.println("1. ordNo ����");
			
			//2.insert OrderInfo
			System.out.println("2.OrderInfo ����");
			
			//orderItem�� ���ٸ� Exception �߻�
			if(items.size()==0){
				throw new InvalidOrderException("Invalid Order Exception");
			}//if
			
			//3.insert OrderItem
			System.out.println("3.OrderItem ����");
			
			//commit
			
			
		}catch(InvalidOrderException e){
			logger.error("�ֹ� ���� : "+e);
			throw e;
		}
		
		logger.debug("�ֹ� �Ϸ�");
		
		return ordNo;
	}
	
	@Override
	public OrderInfo getOrder(long ordNo) {
		// TODO Auto-generated method stub
		
		if(logger.isDebugEnabled()){
			logger.debug(" �ֹ� ���� ��ȸ: "+ordNo);
		}
		
		
		return null;
	}

	@Override
	public List<OrderItem> getOrderItem(long ordNo) {
		// TODO Auto-generated method stub

		if(logger.isDebugEnabled()){
			logger.debug(" �ֹ� �׸� ��ȸ: "+ordNo);
		}

		
		return new ArrayList();
	}
	
}//class end


