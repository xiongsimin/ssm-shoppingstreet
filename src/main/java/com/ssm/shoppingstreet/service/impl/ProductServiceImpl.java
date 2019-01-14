package com.ssm.shoppingstreet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.shoppingstreet.dao.ProductDao;
import com.ssm.shoppingstreet.modal.Product;
import com.ssm.shoppingstreet.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	public List<Product> searchProducts(String key) {
//		System.out.println(key);
		return this.productDao.searchProducts(key);
	}

	public Product findProductById(int productId) {
		// TODO Auto-generated method stub
		return this.productDao.findProductById(productId);
	}

}
