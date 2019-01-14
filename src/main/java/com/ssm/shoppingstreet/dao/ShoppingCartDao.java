package com.ssm.shoppingstreet.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.shoppingstreet.modal.ShoppingCart;

public interface ShoppingCartDao {
	void addShoppingCart(@Param("userId")int userId,@Param("productId")int productId,@Param("time")Timestamp time,@Param("num")int num);
	List<ShoppingCart> findShoppingCartByUserId(@Param("userId")int userId);
	ShoppingCart findShoppingCartByUserIdAndProductId(@Param("userId")int userId,@Param("productId")int productId);
	void updateShoppingCart(@Param("userId")int userId,@Param("productId")int productId,@Param("num")int num);
	void delShoppingCart(@Param("shoppingCartId")int shoppingCartId);
	int clearShoppingCart(@Param("userId") int userId);
}
