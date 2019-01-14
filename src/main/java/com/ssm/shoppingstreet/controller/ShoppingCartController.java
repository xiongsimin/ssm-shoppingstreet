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
			return "���¼��";
		}
		int userId = Integer.parseInt(session.getAttribute("userId").toString());
		ShoppingCart shoppingCart = shoppingCartService.findShoppingCartByUserIdAndProductId(userId,
				Integer.parseInt(productId));
		if (shoppingCart != null) {
			// ������1
			shoppingCartService.updateShoppingCart(userId, Integer.parseInt(productId), shoppingCart.getNum() + 1);
		} else {
			Timestamp time = new Timestamp((new Date()).getTime());
			shoppingCartService.addShoppingCart(userId, Integer.parseInt(productId), time, 1);
		}
		// �޸�session�й��ﳵ��Ϣ
		List<ShoppingCart> shoppingCartList = shoppingCartService.findShoppingCartByUserId(userId);
		// System.out.println(shoppingCartList);
		int sumPrice = 0;// �����ܼ�
		int sumBonusPoints = 0;// �������
		for (ShoppingCart s : shoppingCartList) {
			sumPrice += s.getPrice() * s.getNum();
			sumBonusPoints += s.getBonusPoints() * s.getNum();
		}
		session.setAttribute("shoppingCartList", shoppingCartList);
		session.setAttribute("sumPrice", sumPrice);
		session.setAttribute("sumBonusPoints", sumBonusPoints);
		return "��ӳɹ���";
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
		int sumPrice = 0;// �����ܼ�
		int sumBonusPoints = 0;// �������
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
