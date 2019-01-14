package com.ssm.shoppingstreet.service;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.shoppingstreet.modal.ShoppingCart;

public interface ShoppingCartService {
	/**
	 * 添加购物车
	 * 
	 * @param userId
	 * @param productId
	 * @param time
	 * @param num
	 */
	void addShoppingCart(int userId, int productId, Timestamp time, int num);

	/**
	 * 查找用户所有购物车
	 * @param userId
	 * @return
	 */
	List<ShoppingCart> findShoppingCartByUserId(int userId);
	/**
	 * 根据用户id和商品id查找购物车记录
	 * @param userId
	 * @param productId
	 * @return
	 */
	ShoppingCart findShoppingCartByUserIdAndProductId(int userId,int productId);
	/**
	 * 更新数量
	 * @param userId
	 * @param productId
	 * @param num
	 */
	void updateShoppingCart(int userId,int productId,int num);
	/**
	 * 删除购物车
	 * @param shoppingCartId
	 */
	void delShoppingCart(int shoppingCartId);
}
