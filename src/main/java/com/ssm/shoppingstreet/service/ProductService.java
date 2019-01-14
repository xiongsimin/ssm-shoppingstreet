package com.ssm.shoppingstreet.service;

import java.util.List;

import com.ssm.shoppingstreet.modal.Product;

public interface ProductService {
	/**
	 * ������Ʒ
	 * 
	 * @param key
	 * @return
	 */
	public List<Product> searchProducts(String key);

	/**
	 * ����id���Ҳ�Ʒ
	 * @param productId
	 * @return
	 */
	Product findProductById(int productId);
}
