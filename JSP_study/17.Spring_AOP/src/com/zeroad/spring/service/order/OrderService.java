package com.zeroad.spring.service.order;

import java.util.*;

import com.zeroad.spring.model.order.OrderInfo;

import com.zeroad.spring.model.order.*;
import com.zeroad.spring.exception.*;;


public interface OrderService {

	//.1
	public long createOrder(OrderInfo order, List<OrderItem> items) throws InvalidOrderException;
	
	//2. ordNo�� �ش��ϴ� �ֹ����� ���
	public OrderInfo getOrder(long ordNo);

	//3. �ֹ� ��ǰ ������
	public List<OrderItem> getOrderItem(long ordNo);
	
	
	
}//inter end
