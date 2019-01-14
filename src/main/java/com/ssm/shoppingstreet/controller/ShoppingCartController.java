package com.ssm.shoppingstreet.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.shoppingstreet.modal.ShoppingCart;
import com.ssm.shoppingstreet.service.AddressService;
import com.ssm.shoppingstreet.service.OrderService;
import com.ssm.shoppingstreet.service.ShoppingCartService;

@Controller
public class ShoppingCartController {
	@Autowired
	private ShoppingCartService shoppingCartService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private OrderService orderService;

	@PostMapping(value = "/addToCart", produces = "text/html; charset=utf-8")
	@ResponseBody
	public String addtToCart(String productId, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userId") == null) {
			return "请登录！";
		}
		int userId = Integer.parseInt(session.getAttribute("userId").toString());
		ShoppingCart shoppingCart = shoppingCartService.findShoppingCartByUserIdAndProductId(userId,
				Integer.parseInt(productId));
		if (shoppingCart != null) {
			// 数量加1
			shoppingCartService.updateShoppingCart(userId, Integer.parseInt(productId), shoppingCart.getNum() + 1);
		} else {
			Timestamp time = new Timestamp((new Date()).getTime());
			shoppingCartService.addShoppingCart(userId, Integer.parseInt(productId), time, 1);
		}
		// 修改session中购物车信息
		List<ShoppingCart> shoppingCartList = shoppingCartService.findShoppingCartByUserId(userId);
		// System.out.println(shoppingCartList);
		int sumPrice = 0;// 计算总价
		int sumBonusPoints = 0;// 计算积分
		for (ShoppingCart s : shoppingCartList) {
			sumPrice += s.getPrice() * s.getNum();
			sumBonusPoints += s.getBonusPoints() * s.getNum();
		}
		session.setAttribute("shoppingCartList", shoppingCartList);
		session.setAttribute("sumPrice", sumPrice);
		session.setAttribute("sumBonusPoints", sumBonusPoints);
		return "添加成功！";
	}

	@GetMapping("/goShoppingCart")
	public String goShoppingCart(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userId") == null) {
			try {
				response.sendRedirect("/shoppingstreet/goLogin");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "ShoppingCart";
	}

	@PostMapping(value = "/delShoppingCart", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String delShoppingCart(int shoppingCartId, HttpServletRequest request) {
		HttpSession session = request.getSession();
		shoppingCartService.delShoppingCart(shoppingCartId);
		List<ShoppingCart> shoppingCartList = shoppingCartService
				.findShoppingCartByUserId(Integer.parseInt(session.getAttribute("userId").toString()));
		// System.out.println(shoppingCartList);
		int sumPrice = 0;// 计算总价
		int sumBonusPoints = 0;// 计算积分
		for (ShoppingCart shoppingCart : shoppingCartList) {
			sumPrice += shoppingCart.getPrice() * shoppingCart.getNum();
			sumBonusPoints += shoppingCart.getBonusPoints() * shoppingCart.getNum();
		}
		session.setAttribute("shoppingCartList", shoppingCartList);
		session.setAttribute("sumPrice", sumPrice);
		session.setAttribute("sumBonusPoints", sumBonusPoints);
		return "yes";
	}
}
