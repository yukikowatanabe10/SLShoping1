package com.slshop.admin.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slshop.admin.order.OrderMapper;
import com.slshop.common.entity.order.Order;

@Service
public class OrderService {

	private OrderMapper orderMapper;
	
	@Autowired
	public OrderService(OrderMapper orderMapper) {
		this.orderMapper = orderMapper;
	}
	
	public List<Order> findOrder(){
		return this.orderMapper.findOrder();
	}
}
