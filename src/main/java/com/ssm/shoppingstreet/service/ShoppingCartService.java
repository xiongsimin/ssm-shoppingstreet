package com.ssm.shoppingstreet.service;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.shoppingstreet.modal.ShoppingCart;

public interface ShoppingCartService {
	/**
	 * ��ӹ��ﳵ
	 * 
	 * @param userId
	 * @param productId
	 * @param time
	 * @param num
	 */
	void addShoppingCart(int userId, int productId, Timestamp time, int num);

	/**
	 * �����û����й��ﳵ
	 * @param userId
	 * @return
	 */
	List<ShoppingCart> findShoppingCartByUserId(int userId);
	/**
	 * �����û�id����Ʒid���ҹ��ﳵ��¼
	 * @param userId
	 * @param productId
	 * @return
	 */
	ShoppingCart findShoppingCartByUserIdAndProductId(int userId,int productId);
	/**
	 * ��������
	 * @param userId
	 * @param productId
	 * @param num
	 */
	void updateShoppingCart(int userId,int productId,int num);
	/**
	 * ɾ�����ﳵ
	 * @param shoppingCartId
	 */
	void delShoppingCart(int shoppingCartId);
}
