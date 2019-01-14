package com.ssm.shoppingstreet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.shoppingstreet.modal.Product;

public interface ProductDao {
	List<Product> searchProducts(@Param("key") String key);

	Product findProductById(@Param("productId") int productId);
}
