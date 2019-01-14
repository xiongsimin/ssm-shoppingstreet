package com.ssm.shoppingstreet.controller;

import java.io.IOException;
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
import com.ssm.shoppingstreet.modal.User;
import com.ssm.shoppingstreet.service.AddressService;
import com.ssm.shoppingstreet.service.OrderService;
import com.ssm.shoppingstreet.service.UserService;

@Controller
public class MemberController {
	@Autowired
	private AddressService addressService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;

	@GetMapping("/member_goMemberPage")
	public String goMemberPage(ModelMap map,HttpServletRequest request) {
		HttpSession session=request.getSession();
		String name=session.getAttribute("userName").toString();
		User user=userService.findUserByName(name);
		map.addAttribute("user", user);
		return "Member";
	}

	@GetMapping("/member_goAddressPage")
	public String goAddressPage(HttpServletRequest request, ModelMap map) {
		HttpSession session = request.getSession();
		List<Address> addressList = addressService
				.findAddressByUserId(Integer.parseInt(session.getAttribute("userId").toString()));
		map.addAttribute("addressList", addressList);
		return "Member_Address";
	}

	@PostMapping("/member_addAddress")
	public void addAddress(String title, String area, String consigneeName, String consigneeEmail,
			String specifiedAddress, int consigneeMobilePhone, String consigneePhone, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		int userId = Integer.parseInt(session.getAttribute("userId").toString());
		addressService.addAddress(userId, title, area, consigneeName, consigneeEmail, specifiedAddress,
				consigneeMobilePhone, consigneePhone, 0);
		try {
			response.sendRedirect("/shoppingstreet/member_goAddressPage");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@GetMapping("/member_setDefault")
	public void setDefault(int addressId, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int userId = Integer.parseInt(session.getAttribute("userId").toString());
		addressService.setDefault(userId, addressId);
		try {
			response.sendRedirect("/shoppingstreet/member_goAddressPage");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@GetMapping("/member_goOrderPage")
	public String goOrderPage(HttpServletRequest request, ModelMap map) {
		HttpSession session = request.getSession();
		int userId = Integer.parseInt(session.getAttribute("userId").toString());
		List<Order> orderList = orderService.findOrdersByUserId(userId);
		map.addAttribute("orderList", orderList);
		return "Member_Order";
	}

	@GetMapping("/member_goOrderDetailPage")
	public String goOrderDetailPage(int orderId, ModelMap map) {
		Order order = orderService.findOrderByOrderId(orderId);
		map.addAttribute("order", order);
		return "Member_Order_Detail";
	}

	@GetMapping("/member_delAddress")
	public void delAddress(int addressId, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int userId = Integer.parseInt(session.getAttribute("userId").toString());
		addressService.delAddress(addressId);
		try {
			response.sendRedirect("/shoppingstreet/member_goAddressPage");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@GetMapping("/delOrder")
	public void delOrder(int orderId, HttpServletRequest request, HttpServletResponse response) {
		orderService.delOrder(orderId);
		try {
			response.sendRedirect("/shoppingstreet/member_goOrderPage");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
