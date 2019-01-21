package com.zeroad.spring.dao.order;

import java.util.*;

import com.zeroad.spring.model.order.OrderInfo;
import com.zeroad.spring.model.order.OrderItem;

public interface OrderDAO {

	public long getOrderSeq();
	public long insertOrder(OrderInfo order);
	
	public List<OrderInfo> selectOrderAll();
	
	public OrderInfo selectOrderInfo(long ordNo);
	public long insertOrderItem(OrderItem orderItem);
	
	public List<OrderItem> selectOrderItem(long ordNo);
	
}
