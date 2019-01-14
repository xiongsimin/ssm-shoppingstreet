package com.ssm.shoppingstreet.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.shoppingstreet.dao.OrderDao;
import com.ssm.shoppingstreet.dao.ShoppingCartDao;
import com.ssm.shoppingstreet.modal.Order;
import com.ssm.shoppingstreet.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ShoppingCartDao shoppingCartDao;

	public Order findOrderByUserIdAndNumber(int userId, String number) {
		// TODO Auto-generated method stub
		return this.orderDao.findOrderByUserIdAndNumber(userId, number);
	}

	public Order findOrderByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return this.orderDao.findOrderByOrderId(orderId);
	}

	@Transactional(rollbackFor = Exception.class)
	public int addOrder(int userId, String number, String orderName, Timestamp time, String status, int addressId,
			String payMethod, int sumPrice) {
		// TODO Auto-generated method stub
		
		int orderId = this.orderDao.addOrder(userId, number, orderName, time, status, addressId, payMethod, sumPrice);
		this.shoppingCartDao.clearShoppingCart(userId);
		return orderId;
	}

	public List<Order> findOrdersByUserId(int userId) {
		// TODO Auto-generated method stub
		return this.orderDao.findOrdersByUserId(userId);
	}

	public int delOrder(int orderId) {
		// TODO Auto-generated method stub
		return this.orderDao.delOrder(orderId);
	}

}
