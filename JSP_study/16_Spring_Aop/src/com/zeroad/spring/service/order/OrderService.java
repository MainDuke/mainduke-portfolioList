package com.zeroad.spring.service.order;

import java.util.*;

import com.zeroad.spring.model.order.OrderInfo;

import com.zeroad.spring.model.order.*;
import com.zeroad.spring.exception.*;;


public interface OrderService {

	//.1
	public long createOrder(OrderInfo order, List<OrderItem> items) throws InvalidOrderException;
	
	//2. ordNo에 해당하는 주문정보 얻기
	public OrderInfo getOrder(long ordNo);

	//3. 주문 상품 정보들
	public List<OrderItem> getOrderItem(long ordNo);
	
	
	
}//inter end
