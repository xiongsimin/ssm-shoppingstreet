package com.ssm.shoppingstreet.service;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.shoppingstreet.modal.Order;

public interface OrderService {
	/**
	 * ���ɶ���ͬʱɾ�����ﳵ
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
	 * �����û����Ͷ�����Ų��Ҷ���
	 * 
	 * @param userId
	 * @param number
	 * @return
	 */
	Order findOrderByUserIdAndNumber(int userId, String number);

	/**
	 * ����id�鶩��
	 * 
	 * @param orderId
	 * @return
	 */
	Order findOrderByOrderId(int orderId);

	/**
	 * �����û����ж���
	 * 
	 * @param userId
	 * @return
	 */
	List<Order> findOrdersByUserId(int userId);

	/**
	 * ɾ��order
	 * @param orderId
	 * @return
	 */
	int delOrder(int orderId);
}
