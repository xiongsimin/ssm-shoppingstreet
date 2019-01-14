package com.ssm.shoppingstreet.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.shoppingstreet.modal.Order;

public interface OrderDao {
	int addOrder(@Param("userId") int userId, @Param("number") String number, @Param("orderName") String orderName,
			@Param("time") Timestamp time, @Param("status") String status, @Param("addressId") int addressId,
			@Param("payMethod") String payMethod, @Param("sumPrice") int sumPrice);

	void confirmOrder(@Param("orderId") int orderId, @Param("status") String status);

	Order findOrderByUserIdAndNumber(@Param("userId") int userId, @Param("number") String number);

	Order findOrderByOrderId(@Param("orderId") int orderId);

	List<Order> findOrdersByUserId(@Param("userId") int userId);

	int delOrder(@Param("orderId") int orderId);

}
