package com.ssm.shoppingstreet.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.shoppingstreet.dao.ShoppingCartDao;
import com.ssm.shoppingstreet.modal.ShoppingCart;
import com.ssm.shoppingstreet.service.ShoppingCartService;

@Service("shoppingCartService")
public class ShoppingCartServiceImpl implements ShoppingCartService {
	@Autowired
	private ShoppingCartDao shoppingCartDao;

	public void addShoppingCart(int userId, int productId, Timestamp time, int num) {
		// TODO Auto-generated method stub
		shoppingCartDao.addShoppingCart(userId, productId, time, num);
	}

	public List<ShoppingCart> findShoppingCartByUserId(int userId) {
		// TODO Auto-generated method stub
		return this.shoppingCartDao.findShoppingCartByUserId(userId);
	}

	public ShoppingCart findShoppingCartByUserIdAndProductId(int userId, int productId) {
		// TODO Auto-generated method stub
		return this.shoppingCartDao.findShoppingCartByUserIdAndProductId(userId, productId);
	}

	public void updateShoppingCart(int userId, int productId, int num) {
		this.shoppingCartDao.updateShoppingCart(userId, productId, num);
		
	}

	public void delShoppingCart(int shoppingCartId) {
		this.shoppingCartDao.delShoppingCart(shoppingCartId);
		
	}

}
