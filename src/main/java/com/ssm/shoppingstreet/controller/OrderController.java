package com.ssm.shoppingstreet.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssm.shoppingstreet.modal.Address;
import com.ssm.shoppingstreet.modal.Order;
import com.ssm.shoppingstreet.modal.ShoppingCart;
import com.ssm.shoppingstreet.service.AddressService;
import com.ssm.shoppingstreet.service.OrderService;
import com.ssm.shoppingstreet.service.ShoppingCartService;

@Controller
public class OrderController {
	@Autowired
	private AddressService addressService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private ShoppingCartService shoppingCartService;

	/**
	 * 前往订单确认页
	 * 
	 * @param request
	 * @param map
	 * @return
	 */
	@GetMapping("/goShoppingCartTwo")
	public String goShoppingCartTwo(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userId") == null) {
			try {
				response.sendRedirect("/shoppingstreet/goLogin");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Address defaultAddress = addressService
				.findDefaultAddress(Integer.parseInt(session.getAttribute("userId").toString()));
		map.addAttribute("defaultAddress", defaultAddress);

		List<ShoppingCart> shoppingCartList = (List) session.getAttribute("shoppingCartList");

		if (!shoppingCartList.isEmpty()) {// 如果

			String orderName = "";// 订单名（所有商品名及数量拼接）
			for (ShoppingCart s : shoppingCartList) {
				orderName += s.getProductName();
				orderName += "X";
				orderName += s.getNum();
				orderName += " ；";
			}
			map.addAttribute("orderName", orderName);
			return "ShoppingCart_Two";
		} else {
			map.addAttribute("msg", "购物车还没有商品，无法结算！");
			return "ShoppingCart";
		}
	}

	/**
	 * 确认订单并前往支付页
	 */
	@PostMapping("/confirmOrder")
	public String goShoppingCartThree(int addressId, String payMethod, ModelMap map, HttpServletRequest request) {

		HttpSession session = request.getSession();
		List<ShoppingCart> shoppingCartList = (List) session.getAttribute("shoppingCartList");
		if (shoppingCartList.isEmpty()) {// 购物车为空，提示请勿重复提交
			map.addAttribute("msg", "请勿重复提交！");
			return "ShoppingCart_Three";
		}
		String orderName = "";// 订单名（所有商品名及数量拼接）
		for (ShoppingCart s : shoppingCartList) {
			orderName += s.getProductName();
			orderName += "X";
			orderName += s.getNum();
			orderName += " ；";
		}
		map.addAttribute("orderName", orderName);
		Date d = new Date();
		Timestamp time = new Timestamp(d.getTime());
		// 拼接订单编号（时间+用户id+5位随机码） 随机码之后再加
		String pattern = "yyyyMMddHHmmss";
		String s = (new SimpleDateFormat(pattern)).format(d.getTime()).toString();
		String number = "";
		number += s;
		number += session.getAttribute("userId").toString();

		// 新增订单
		int rs = orderService.addOrder(Integer.parseInt(session.getAttribute("userId").toString()), number, orderName,
				time, "confirmed", addressId, payMethod, Integer.parseInt(session.getAttribute("sumPrice").toString()));
		// System.out.println(rs);
		if (rs != 0) {
			Order order = orderService
					.findOrderByUserIdAndNumber(Integer.parseInt(session.getAttribute("userId").toString()), number);
			if (payMethod.equals("balance")) {
				map.addAttribute("payMethod", "余额支付");
			} else if (payMethod.equals("alipay")) {
				map.addAttribute("payMethod", "支付宝");
			} else if (payMethod.equals("bank_cart")) {
				map.addAttribute("payMethod", "银行卡");
			} else if (payMethod.equals("cod")) {
				map.addAttribute("payMethod", "货到付款");
			}
			map.addAttribute("sumPrice", order.getSumPrice());
			map.addAttribute("number", order.getNumber());
			// 更新session
			shoppingCartList = shoppingCartService
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
		}
		return "ShoppingCart_Three";
	}
}
