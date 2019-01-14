package com.ssm.shoppingstreet.service;

import java.util.List;

import com.ssm.shoppingstreet.modal.Product;

public interface ProductService {
	/**
	 * 搜索产品
	 * 
	 * @param key
	 * @return
	 */
	public List<Product> searchProducts(String key);

	/**
	 * 根据id查找产品
	 * @param productId
	 * @return
	 */
	Product findProductById(int productId);
}
