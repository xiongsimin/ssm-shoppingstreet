package com.ssm.shoppingstreet.service;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.shoppingstreet.modal.Order;

public interface OrderService {
	/**
	 * 生成订单同时删除购物车
	 * 
	 * @param userId
	 * @param number
	 * @param orderName
	 * @param time
	 * @param status
	 * @param addressId
	 * @param payMethod
	 * @param sumPrice
	 */
	int addOrder(int userId, String number, String orderName, Timestamp time, String status, int addressId,
			String payMethod, int sumPrice);

	/**
	 * 根据用户名和订单编号查找订单
	 * 
	 * @param userId
	 * @param number
	 * @return
	 */
	Order findOrderByUserIdAndNumber(int userId, String number);

	/**
	 * 根据id查订单
	 * 
	 * @param orderId
	 * @return
	 */
	Order findOrderByOrderId(int orderId);

	/**
	 * 查找用户所有订单
	 * 
	 * @param userId
	 * @return
	 */
	List<Order> findOrdersByUserId(int userId);

	/**
	 * 删除order
	 * @param orderId
	 * @return
	 */
	int delOrder(int orderId);
}
