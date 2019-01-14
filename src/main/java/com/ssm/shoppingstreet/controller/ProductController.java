package com.ssm.shoppingstreet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssm.shoppingstreet.modal.Product;
import com.ssm.shoppingstreet.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping("/searchProducts")
	public String searchProducts(String key, ModelMap map) {

		List<Product> productList = productService.searchProducts(key);
		if (productList.isEmpty()) {
			map.addAttribute("msg", "没有相匹配的商品！");
			return "CategoryList";
		}
		// System.out.println(productList.toString());
		map.addAttribute("productList", productList);
		return "CategoryList";
	}

	@GetMapping("/goProductPage")
	public String goProductPage(int productId,ModelMap map) {
		Product product=productService.findProductById(productId);
		map.addAttribute("product", product);
		return "Product";
	}

}
